import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EnrollmentInterface extends Remote {
    public String displayStudent() throws RemoteException;

    public String displayCourse() throws RemoteException;

    public int enrollCourse(int studentID, String studentCourseCode) throws RemoteException;

    // public String saveEnrollment(String enrolled) throws RemoteException;
}
