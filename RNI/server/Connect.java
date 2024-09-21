import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public Connection getConnect() {

        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/Student";
        String username = "postgres";
        String pass = "09282402911";

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, username, pass);

            if (connection != null) {
                System.out.println("Successfully Connected");
            } else {
                System.out.println("Not successfully");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return connection;

    }
}