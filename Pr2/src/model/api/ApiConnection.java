package model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import model.Brawler;
import model.RootBrawlers;
import model.dao.SQLite.SQLiteBrawlerDAO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
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

    public static void llegirJson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/jsons/nous_brawlers.json")) {

            RootBrawlers root = gson.fromJson(reader, RootBrawlers.class);
            List<Brawler> brawlers = root.getList();

            for (Brawler b : brawlers) {
                System.out.println("Brawler: " + b.getName());
                System.out.println("  Class: " + b.getBrawlerClass().getName());
                System.out.println("  Rarity: " + b.getRarity().getName());

                if (b.getStarPowers() != null) {
                    for (Brawler.StarPower sp : b.getStarPowers()) {
                        System.out.println("  Star Power: " + sp.getName() + " - " + sp.getDescription());
                    }
                }

                if (b.getGadgets() != null) {
                    for (Brawler.Gadget gd : b.getGadgets()) {
                        System.out.println("  Gadget: " + gd.getName() + " - " + gd.getDescription());
                    }
                }
                System.out.println();
                SQLiteBrawlerDAO dao = new SQLiteBrawlerDAO();
                dao.crear(b);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
