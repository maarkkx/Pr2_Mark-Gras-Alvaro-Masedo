package model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiConnection {
    public static void getJson(String endpoint, String ruta) {
        try {
            //Creacio conexio HTTP amb la api
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //Llegir el json rebut i donar-li format
            Scanner scanner = new Scanner(conn.getInputStream());
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
