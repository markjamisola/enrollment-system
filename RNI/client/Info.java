import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.util.Scanner;

public class Info {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        System.setProperty("java.rmi.client.hostname", "127.0.2.1");
        System.out.println("Client has been started...");

        Enrollment client = new Enrollment();
        client.initializeStudents();
        client.initializeCourse();

        try (Scanner scan = new Scanner(System.in)) {
            int userSelection = 0;
            String course = " ";
            do {
                System.out.println("\n\nMENU:");
                System.out.println("1. Display ALL Students" + "\n" +
                        "2. Display ALL available Courses" + "\n" +
                        "3. Enroll a Student " + "\n" +
                        "0. Exit " + "\n");
                System.out.print("Enter your choice: ");
                userSelection = scan.nextInt();
                switch (userSelection) {
                    case 1:
                        System.out.println(client.displayStudent());
                        break;
                    case 2:
                        System.out.println(client.displayCourse());
                        break;
                    case 3:
                        System.out.println("\n\nEnter Student ID: ");
                        int studentId = scan.nextInt();
                        System.out.println("Enter Course: ");
                        course = scan.next();
                        int result = client.enrollCourse(studentId, course);
                        if (result == 0) {
                            System.out.println("Invalid Student or Course");
                        } else {
                            System.out.println(
                                    "Successfully enrolled to course with a code " + course);
                        }
                        break;
                    case 4:

                        break;
                    default:
                        break;
                }
            } while (userSelection != 0);

            System.out.println("Exporting and binding of objects completed...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}