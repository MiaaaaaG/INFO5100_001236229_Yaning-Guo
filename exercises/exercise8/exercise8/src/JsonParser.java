import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static void main(String[] args) {
        try {
            File jsonFile = new File("myjson.json");
            FileReader reader = new FileReader(jsonFile);
            StringBuilder sb = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                sb.append((char) character);
            }
            reader.close();

            JSONObject json = new JSONObject(sb.toString());
            JSONArray bookArray = json.getJSONArray("Books");

            for (int i = 0; i < bookArray.length(); i++) {
                JSONObject bookObject = bookArray.getJSONObject(i);
                System.out.println("Title: " + bookObject.getString("title"));
                System.out.println("Published Year: " + bookObject.getInt("publishedYear"));
                System.out.println("Number of Pages: " + bookObject.getInt("numberOfPages"));
                JSONArray authorsArray = bookObject.getJSONArray("authors");
                List<String> authorsList = new ArrayList<>();
                for (int j = 0; j < authorsArray.length(); j++) {
                    authorsList.add(authorsArray.getString(j));
                }
                System.out.println("Authors: " + String.join(", ", authorsList));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

