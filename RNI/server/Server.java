import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.2.1", 9101);

            String[] names = registry.list();
            StudentInterface[] std = new StudentInterface[names.length];

            for (int i = 0; i < names.length; i++) {
                std[i] = (StudentInterface) registry.lookup(names[i]);
            }

            Connect database = new Connect();
            connection = database.getConnect();

            String sql = "INSERT INTO students (id, name, age, address, contact, enrolled) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);

            for (int i = 0; i < std.length; i++) {
                List<String> courses = std[i].getCourseEnrolled();
                stmt.setInt(1, std[i].getId());
                stmt.setString(2, std[i].getName());
                stmt.setInt(3, std[i].getAge());
                stmt.setString(4, std[i].getAddress());
                stmt.setString(5, std[i].getContact());
                
                if (courses != null && !courses.isEmpty()) {
                    stmt.setString(6, String.join(",", courses)); // Join courses with a comma
                } else {
                    stmt.setString(6, "Not enrolled");
                    System.out.println("Student ID " + std[i].getId() + " is not enrolled in any course.");
                }
                stmt.executeUpdate();
            }
            System.out.println("Successfully inserted student data into the database");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace(); // Helpful for debugging
        } catch (Exception e) {
            System.err.println("General Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure resources are closed properly
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }   
        }
    }
}
