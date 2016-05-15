package paulo.android.nackademin.api_server_projekt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JSONParse {


    public static List<Book> parseFeed(String content) {

        try {
            JSONArray ar = new JSONArray(content);
            List<Book> countryList = new ArrayList<>();

            for (int i = 0; i < ar.length(); i++) {

                JSONObject obj = ar.getJSONObject(i);
                Book book = new Book();

                book.setName(obj.getString("name"));
                book.setDescription(obj.getString("description"));
                book.setPrice(obj.getDouble("price"));

                countryList.add(book);
            }

            return countryList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
