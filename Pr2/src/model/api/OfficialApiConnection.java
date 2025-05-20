package model.api;

import com.google.gson.Gson;
import model.BrawlersWrapper;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OfficialApiConnection {
    public static String api_url = "https://api.brawlstars.com/v1/brawlers";
    public static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjkxNzU0YTE3LTZkYzAtNDU4MC04MWQ0LTVlNDg0ODY2OGFiNCIsImlhdCI6MTc0NzY0ODIyMiwic3ViIjoiZGV2ZWxvcGVyLzk1YzQzMzgzLTMzNmItZDAzMS1lZWNlLTg2NGNjOGYwNzI2YiIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sImxpbWl0cyI6W3sidGllciI6ImRldmVsb3Blci9zaWx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9LHsiY2lkcnMiOlsiODUuNTAuMTYwLjQzIl0sInR5cGUiOiJjbGllbnQifV19.YAwNvmseFl9dK5zeiol4iwM_rYAmCamcxmWAd9dXSSo5Kye2yhvHoB4BpUkv6aB1ShX2kR89g0ijO63A-h9lIw";

    public static BrawlersWrapper fetchBrawlers(){
        Gson gson = new Gson();

        try {
            URL url = new URL(api_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            connection.setRequestProperty("Authorization", token);

            if(connection.getResponseCode() == 200){
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                BrawlersWrapper wrapper = gson.fromJson(reader, BrawlersWrapper.class);
                reader.close();
                return wrapper;
            } else {
                System.out.println("Error: código " + connection.getResponseCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}