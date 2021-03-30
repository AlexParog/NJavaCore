import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        List<Employee> list = parseXML("data.xml");
        String json = listToJson(list);
        try (FileWriter file = new FileWriter("dataJson.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Employee> parseXML(String fileName) throws ParserConfigurationException,
            IOException, SAXException {

        DocumentBuilder factory = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = factory.parse(new File(fileName));

        Element root = doc.getDocumentElement();

        NodeList nodeList = root.getChildNodes();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (org.w3c.dom.Element) node;
                NamedNodeMap map = element.getAttributes();
                String id = map.getNamedItem("id").getNodeValue();
                String firstName = map.getNamedItem("firstName").getNodeValue();
                String lastName = map.getNamedItem("lastName").getNodeValue();
                String country = map.getNamedItem("country").getNodeValue();
                String age = map.getNamedItem("age").getNodeValue();
                Employee employee = new Employee(Long.parseLong(id), firstName, lastName, country, Integer.parseInt(age));
                employees.add(employee);
            }
        }
        return employees;
    }

    public static String listToJson(List<Employee> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        return gson.toJson(list, listType);
    }
}
