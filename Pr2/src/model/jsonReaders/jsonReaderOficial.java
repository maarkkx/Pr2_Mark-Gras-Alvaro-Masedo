package model.jsonReaders;

import com.google.gson.Gson;
import model.Brawlers.BrawlerApiOficial;
import model.RootBrawlers.RootBrawlersOficial;
import model.dao.DBConnection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class jsonReaderOficial {
    /**
     * Funcio per llegir un json
     * @param ruta ruta d'on esta guardat el json
     */
    public static void llegirJson(String ruta) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(ruta)) {

            RootBrawlersOficial root = gson.fromJson(reader, RootBrawlersOficial.class);
            List<BrawlerApiOficial> brawlers = root.getItems();

            for (BrawlerApiOficial b : brawlers) {
                System.out.println("Brawler: " + b.getName());

                if (b.getStarPowers() != null) {
                    for (BrawlerApiOficial.StarPower sp : b.getStarPowers()) {
                        System.out.println("  Star Power: " + sp.getName());
                    }
                }

                if (b.getGadgets() != null) {
                    for (BrawlerApiOficial.Gadget g : b.getGadgets()) {
                        System.out.println("  Gadget: " + g.getName());
                    }
                }

                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error al leer el JSON oficial: " + e.getMessage());
        }
    }

    /**
     * funcio per comprovar si un brawler de la api oficial existeix a la bdd
     * @param rutaJson ruta del json de la api oficial
     */
    public static void comprovarBrawlerJson (String rutaJson){
        Scanner scan = new Scanner(System.in);
        System.out.println("Escriu el nom del Brawler que vols comprobar");
        String nomFormat = scan.nextLine().trim().toLowerCase();

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(rutaJson)) {

            RootBrawlersOficial root = gson.fromJson(reader, RootBrawlersOficial.class);
            List<BrawlerApiOficial> brawlers = root.getItems();

            boolean trobat = false;
            String nomComplet = null;

            for (BrawlerApiOficial b : brawlers) {
                if (b.getName().toLowerCase().equals(nomFormat)) {
                    trobat = true;
                    nomComplet = b.getName();
                    break;
                }
            }

            if (!trobat) {
                System.out.println("El brawler no existeix a la API oficial.");
                return;
            }

            // Comprovar a la base de dades
            Connection con = DBConnection.openCon();
            String sql = "SELECT COUNT(*) FROM brawlers WHERE nom = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                String NomFormatejat = nomComplet.substring(0, 1).toUpperCase() + nomComplet.substring(1).toLowerCase();
                stmt.setString(1,NomFormatejat );
                ResultSet rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    System.out.println("El Brawler '" + NomFormatejat + "' ja existeix a la base de dades.");
                } else {
                    System.out.println("El Brawler '" + NomFormatejat + "' NO existeix a la base de dades.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error al llegir el JSON: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al accedir a la base de dedaes: " + e.getMessage());
        }
    }
}
