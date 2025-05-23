package model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OfficialApiConnection {
    //Token de la API
    public static void getJson(String endpoint, String ruta){
        try {
            //Creacio conexio HTTP amb la api
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjdmZmQyYTM4LTU2ZjYtNGQyOC05MjJkLTcwYTgxMmQ2NjIxYyIsImlhdCI6MTc0Nzk5MTQ3Niwic3ViIjoiZGV2ZWxvcGVyLzk1YzQzMzgzLTMzNmItZDAzMS1lZWNlLTg2NGNjOGYwNzI2YiIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sImxpbWl0cyI6W3sidGllciI6ImRldmVsb3Blci9zaWx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9LHsiY2lkcnMiOlsiODUuNTAuMTYwLjQzIl0sInR5cGUiOiJjbGllbnQifV19.TWlEo3LJneRnROn98pcIEQismNP0exHzV87flcZsJ1mnoJU7g7oLRveXT7PWjTYcNsMGgMgJlwx_eiu-5sQqdA";
            con.setRequestProperty("Authorization", token);

            //Llegir el json rebut i donar-li format
            Scanner scanner = new Scanner(con.getInputStream());
            StringBuilder jsonSenseFormat = new StringBuilder();
            while (scanner.hasNext()) {
                jsonSenseFormat.append(scanner.nextLine());
            }
            scanner.close();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement jsonElement = JsonParser.parseString(jsonSenseFormat.toString());
            String jsonFormatejat = gson.toJson(jsonElement);

            //Crear arxiu i guardar el contingut
            File file = new File(ruta);
            if (file.exists()) {
                file.delete();
            }
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            writer.write(jsonFormatejat);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}