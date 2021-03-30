import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String json = readString("new_data.json");
        List<Employee> list = jsonToList(json);
        System.out.println(list.toString());
    }

    public static String readString(String filename) {
        JSONParser parser = new JSONParser();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Employee> jsonToList(String json) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JSONParser parser = new JSONParser();
        List<Employee> out = new ArrayList<>();

        try {
            Object obj = parser.parse(json);
            JSONArray array = (JSONArray) obj;

            for (int i = 0; i < array.toArray().length; i++) {
                String s = array.get(i).toString();
                out.add(gson.fromJson(s, Employee.class));
            }
            return out;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
