package model;

import com.google.gson.Gson;
import controller.Controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BrawlersWrapper {
    private List<Brawler> brawlers;

    public List<Brawler> getBrawlers() {
        return brawlers;
    }

    //Main
    public static void main(String[] args) {
        Gson gson = new Gson();
        Controller.menu();
        /*try (FileReader reader = new FileReader("nous_brawlers.json")) {

            //Com el json que ens passa no comença amb una llista sino amb un atribut directament podem crear la llista
            //de la clase brawler
            Brawler[] brawlers = gson.fromJson(reader, Brawler[].class);

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

            }

        } catch (IOException e) {
            System.out.println(e);
        }*/
    }
}