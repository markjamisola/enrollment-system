import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class StudentParser extends BaseParser {
    private Student[] students;

    public Student[] getStudents() {
        return students;
    }

    @Override
    protected void parseDoc
    ument(Document doc) throws Exception {
        doc.getDocumentElement().normalize();
        NodeList studentList = doc.getElementsByTagName("student");
        students = new Student[studentList.getLength()];

        for (int i = 0; i < studentList.getLength(); i++) {
            Node node = studentList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                int id = Integer.parseInt(element.getAttribute("id"));
                String name = element.getAttribute("name");
                int age = Integer.parseInt(element.getAttribute("age"));
                String address = element.getAttribute("address");
                String contact = element.getAttribute("contactNumber");

                students[i] = new Student(id, name, age, address, contact);
            }
        }
    }
}
