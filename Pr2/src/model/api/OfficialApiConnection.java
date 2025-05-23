package model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import model.main;


import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OfficialApiConnection {
    public static void getJson(String endpoint, String ruta){
        try {
            //Creacio conexio HTTP amb la api
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            //Llegir el json rebut i donar-li format
            Scanner scan = new Scanner(con.getInputStream());
            StringBuilder jsonSenseFormat = new StringBuilder();
            while (scan.hasNext()){
                jsonSenseFormat.append(scan.nextLine();
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement jsonElement = JsonParser.parseString(jsonSenseFormat.toString());
            String jsonFormatejat = gson.toJson(jsonElement);

            //Crear arxiu i guardar el contingut
            File file = new File(ruta);
            if(file.exists()) {
                file.delete();
            }
            file.getParentFile().mkdirs();
        }
    }
}