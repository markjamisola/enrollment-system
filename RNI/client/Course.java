import java.rmi.RemoteException;

public class Course implements CourseInterface {
    private String course_id;
    private int student_id;
    private String course_title;
    private String course_desc;

    Course(String course_id, int student_id, String course_title, String course_desc) throws RemoteException {
        this.course_id = course_id;
        this.student_id = student_id;
        this.course_title = course_title;
        this.course_desc = course_desc;
    }

    public void viewCourse() throws RemoteException {
        System.out.println("List of Courses" +
                "\nCourse_id: " + course_id + "  Student_id: " + student_id +
                "  Course Title: " + course_title +
                "  Course Description: " + course_desc);
    }

    public String getCourseId() throws RemoteException {
        return course_id;
    }

    public int getStudentId() throws RemoteException {
        return student_id;
    }

    public String getCourseTitle() throws RemoteException {
        return course_title;
    }

    public String getCourseDesc() throws RemoteException {
        return course_desc;
    }

}
