import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Student implements StudentInterface {
    private int id;
    private String name;
    private int age;
    private String address;
    private String contact;
    private List<String> courses = new ArrayList<>();

    

    Student(int id, String name, int age, String address, String contact) throws RemoteException {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact = contact;
    }

    public int getId() throws RemoteException {
        return id;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public int getAge() throws RemoteException {
        return age;
    }

    public String getAddress() throws RemoteException {
        return address;
    }

    public String getContact() throws RemoteException {
        return contact;
    }

    public List<String> getCourseEnrolled() throws RemoteException {

        return courses;
    }

    public void setCourse(String courseCode) throws RemoteException {
        courses.add(courseCode);
    }

}