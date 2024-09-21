import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.w3c.dom.Document;

public class Enrollment implements EnrollmentInterface {

    private Student[] stud;
    private Course[] cour;

    public void initializeStudents() throws RemoteException {
        try {
            StudentParser studentParser = new StudentParser();
            Document doc = studentParser.getDocument("C:\\Users\\markd\\Downloads\\IT106\\RNI\\client\\Student.xml");
            studentParser.parseDocument(doc);
            stud = studentParser.getStudents();

            Registry registry = LocateRegistry.createRegistry(9101);
            for (Student student : stud) {
                if (student != null) {
                    StudentInterface stub = (StudentInterface) UnicastRemoteObject.exportObject(student, 0);
                    registry.rebind(student.getName(), stub);
                }
            }
        } catch (Exception e) {
            System.out.println("Error while initializing students: " + e);
        }
    }

    public void initializeCourse() throws RemoteException {
        try {
            CourseParser courseParser = new CourseParser();
            Document doc = courseParser.getDocument("C:\\Users\\markd\\Downloads\\IT106\\RNI\\client\\Course.xml");
            courseParser.parseDocument(doc);
            cour = courseParser.getCourses();
        } catch (Exception e) {
            System.err.println("Error while initializing courses: " + e);
        }
    }

    public String displayStudent() throws RemoteException {
        StringBuilder allStudent = new StringBuilder("\n\n<========== All Students ==========>\n");
        for (Student student : stud) {
            if (student != null) {
                allStudent.append("\nID: ").append(student.getId())
                           .append("\nName: ").append(student.getName())
                           .append("\nAge: ").append(student.getAge())
                           .append("\nAddress: ").append(student.getAddress())
                           .append("\nContact: ").append(student.getContact())
                           .append("\nCourses Enrolled: ").append(student.getCourseEnrolled().isEmpty() ? "No courses enrolled yet." : student.getCourseEnrolled())
                           .append("\n");
            }
        }
        System.out.println("A request from unknown server has been processed: Displaying all the Students");
        return allStudent.toString();
    }

    public String displayCourse() throws RemoteException {
        StringBuilder allCourse = new StringBuilder("\n\n<========== All Courses: ==========>\n");
        for (Course course : cour) {
            if (course != null) {
                allCourse.append("\nCourse Id: ").append(course.getCourseId())
                          .append("\nStudent Id: ").append(course.getStudentId())
                          .append("\nCourse Title: ").append(course.getCourseTitle())
                          .append("\nCourse Description: ").append(course.getCourseDesc())
                          .append("\n------------------");
            }
        }
        System.out.println("A request from unknown server has been processed: Displaying all the Courses");
        return allCourse.toString();
    }

    public int enrollCourse(int studentID, String studentCourseCode) throws RemoteException {
        boolean studentExists = false;
        boolean courseExists = false;

        for (Student student : stud) {
            if (student.getId() == studentID) {
                studentExists = true;
                break;
            }
        }

        for (Course course : cour) {
            if (course.getCourseId().equalsIgnoreCase(studentCourseCode)) {
                courseExists = true;
                break;
            }
        }

        if (!studentExists || !courseExists) {
            System.out.println("A Client attempted to Enroll student. Error found to be an invalid student or course...");
            return 0;
        }

        for (Student student : stud) {
            if (student.getId() == studentID) {
                student.setCourse(studentCourseCode);
                break;
            }
        }

        System.out.println("A Client successfully enrolled one student...");
        return 1;
    }
}
