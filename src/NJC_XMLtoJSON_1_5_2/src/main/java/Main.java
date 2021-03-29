import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        List<Employee> list = parseXML("data.xml");
        System.out.println(list);


    }

    public static List<Employee> parseXML(String fileName) throws ParserConfigurationException,
            IOException, SAXException {

        DocumentBuilder factory = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = factory.parse(new File(fileName));

        Element root = doc.getDocumentElement();
        System.out.println("Корневой элемент " + root.getNodeName());

        NodeList nodeList = root.getChildNodes();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (org.w3c.dom.Element) node;
                NamedNodeMap map = element.getAttributes();
                for (int j = 0; j < map.getLength(); j++) {
                    String id = map.item(j).getNodeValue();
                    String firstName = map.item(j + 1).getNodeValue();
                    String lastName = map.item(j + 2).getNodeValue();
                    String country = map.item(j + 3).getNodeValue();
                    String age = map.item(j + 4).getNodeValue();
                    Employee employee = new Employee(Long.parseLong(id), firstName, lastName, country, Integer.parseInt(age));
                    employees.add(employee);
                }
            }
        }
        return employees;
    }
}
