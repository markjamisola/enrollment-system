import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentInterface extends Remote {

	public int getId() throws RemoteException;

	public String getName() throws RemoteException;

	public int getAge() throws RemoteException;

	public String getAddress() throws RemoteException;

	public String getContact() throws RemoteException;

    public List<String> getCourseEnrolled() throws RemoteException;

	public void setCourse(String courseCode) throws RemoteException;
}