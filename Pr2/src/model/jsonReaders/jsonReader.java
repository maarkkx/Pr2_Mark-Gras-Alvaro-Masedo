package model.jsonReaders;

import com.google.gson.Gson;
import model.Brawlers.Brawler;
import model.RootBrawlers.RootBrawlers;
import model.api.ApiConnection;
import model.dao.SQLite.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class jsonReader {
    public static void llegirJson(String ruta) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(ruta)) {

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
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void llegirJsonUnBrawler() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("Pr2/src/jsons/unBrawler.json")) {

            Brawler b = gson.fromJson(reader, Brawler.class);

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

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void afegirBrawlers() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("Pr2/src/jsons/nous_brawlers.json")) {

            RootBrawlers root = gson.fromJson(reader, RootBrawlers.class);
            List<Brawler> brawlers = root.getList();

            for (Brawler b : brawlers) {
                SQLiteRarityDAO daoR = new SQLiteRarityDAO();
                daoR.crear(b);
                SQLiteClassDAO daoC = new SQLiteClassDAO();
                daoC.crear(b);
                SQLiteBrawlerDAO dao = new SQLiteBrawlerDAO();
                dao.crear(b);
                SQLiteStarpowerDAO daoSP = new SQLiteStarpowerDAO();
                daoSP.crear(b);
                SQLiteGadgetDAO daoG = new SQLiteGadgetDAO();
                daoG.crear(b);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void actualitzarBrawlers() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("Pr2/src/jsons/nous_brawlers.json")) {

            RootBrawlers root = gson.fromJson(reader, RootBrawlers.class);
            List<Brawler> brawlers = root.getList();

            for (Brawler b : brawlers) {
                SQLiteRarityDAO daoR = new SQLiteRarityDAO();
                daoR.actualitzar(b);
                SQLiteClassDAO daoC = new SQLiteClassDAO();
                daoC.actualitzar(b);
                SQLiteBrawlerDAO dao = new SQLiteBrawlerDAO();
                dao.actualitzar(b);
                SQLiteStarpowerDAO daoSP = new SQLiteStarpowerDAO();
                daoSP.actualitzar(b);
                SQLiteGadgetDAO daoG = new SQLiteGadgetDAO();
                daoG.actualitzar(b);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void actualitzarUnBrawler() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Escriu l'id del brawler que vols modificar: ");
        String id = scan.nextLine();
        String url = "https://api.brawlify.com/v1/brawlers/" + id;
        ApiConnection.getJson(url, "Pr2/src/jsons/unBrawler.json");
        llegirJsonUnBrawler();

        System.out.println("Vols actualitzar el Brawler? Sí (1), No (0)");
        int num = scan.nextInt();
        scan.nextLine();

        switch (num) {
            case 1:
                Gson gson = new Gson();
                try (FileReader reader = new FileReader("Pr2/src/jsons/unBrawler.json")) {

                    Brawler b = gson.fromJson(reader, Brawler.class);

                        SQLiteRarityDAO daoR = new SQLiteRarityDAO();
                        daoR.actualitzar(b);
                        SQLiteClassDAO daoC = new SQLiteClassDAO();
                        daoC.actualitzar(b);
                        SQLiteBrawlerDAO dao = new SQLiteBrawlerDAO();
                        dao.actualitzar(b);
                        SQLiteStarpowerDAO daoSP = new SQLiteStarpowerDAO();
                        daoSP.actualitzar(b);
                        SQLiteGadgetDAO daoG = new SQLiteGadgetDAO();
                        daoG.actualitzar(b);
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;

            case 0:
                break;
        }
    }
}
