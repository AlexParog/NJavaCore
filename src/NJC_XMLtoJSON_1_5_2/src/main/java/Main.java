import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        List<Employee> list = parseXML("data.xml");
        System.out.println(list);

    }

    public static List<Employee> parseXML(String fileName) throws ParserConfigurationException,
            IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));

        Node root = doc.getDocumentElement();
        System.out.println("Корневой элемент " + root.getNodeName());

        NodeList childList = root.getChildNodes();
        List<Employee> employees = null;
        for (int i = 0; i < childList.getLength(); i++) {
            if (childList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) childList.item(i);
                NamedNodeMap map = (NamedNodeMap) element.getAttributes();
                for (int j = 0; j < map.getLength(); j++) {
                    String id = map.item(j).getNodeValue();
                    String firstName = map.item(j + 1).getNodeValue();
                    String lastName = map.item(j + 2).getNodeValue();
                    String country = map.item(j + 3).getNodeValue();
                    String age = map.item(j + 4).getNodeValue();
                    Employee employee = new Employee(Long.parseLong(id), firstName, lastName, country, Integer.parseInt(age));
                    System.out.println(employee);
                }
            }
        }
        return employees;
    }

}
