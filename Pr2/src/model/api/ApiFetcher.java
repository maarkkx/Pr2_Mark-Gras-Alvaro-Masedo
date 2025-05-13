package model.api;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import model.BrawlersWrapper;
import com.google.gson.Gson;

public class ApiFetcher {

    public static BrawlersWrapper fetchBrawlers(){
        String urlString = "https://api.brawlify.com/v1/brawlers";
        Gson gson = new Gson();

        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200){
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                BrawlersWrapper wrapper = gson.fromJson(reader, model.BrawlersWrapper.class);
                reader.close();
                return wrapper;
            }  else {
                System.out.println("Error: codi " + connection.getResponseCode());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
