import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class CourseParser extends BaseParser {
    private Course[] courses;

    public Course[] getCourses() {
        return courses;
    }

    @Override
    protected void parseDocument(Document doc) throws Exception {
        doc.getDocumentElement().normalize();
        NodeList courseList = doc.getElementsByTagName("course");
        courses = new Course[courseList.getLength()];

        for (int i = 0; i < courseList.getLength(); i++) {
            Node node = courseList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String courseId = element.getAttribute("course_id");
                int studentId = Integer.parseInt(element.getAttribute("student_id"));
                String title = element.getAttribute("course_title");
                String description = element.getAttribute("course_des");

                courses[i] = new Course(courseId, studentId, title, description);
            }
        }
    }
}
