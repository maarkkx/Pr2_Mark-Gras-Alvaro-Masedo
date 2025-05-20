package model.dao.SQLite;

import model.Brawler;
import model.CRUD;
import model.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLiteBrawlerDAO implements CRUD {

    /**
     *Llegeix totes les entrades de la Base de Dades
     */
    public void llegirTot(){
        // Query SQL per llegir tots els sectors
        String sql = "SELECT * FROM brawlers";

        // Obre la connexió a la BD
        Connection con = DBConnection.openCon();

        try(PreparedStatement stmt = con.prepareStatement(sql)){
            // Executa la consulta i processa els resultats
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.printf("Brawler ID: %-10d Nom: %-15s Class ID: %-5d Rarity ID: %-5d\n",
                        rs.getInt("brawler_id"),
                        rs.getString("nom"),
                        rs.getInt("class_id"),
                        rs.getInt("rarity_id")
                );
            }
            stmt.close();
            con.close();
        } catch (SQLException e){
            System.out.println("Error al llegir dades de la Base de Dades");
        }
    }

    /**
     * Demana el nom de un Brawler
     * Cerca a la Base de dades si existeix
     * Retorna les dades d'aquest Brawler
     */
    public void llegirUnaEntrada(){
        Scanner scan = new Scanner(System.in);

        // Query SQL per llegir un sector
        String sql = "SELECT * FROM brawlers WHERE nom = ?";

        // Obre la connexió a la BD
        Connection con = DBConnection.openCon();

        try (PreparedStatement stmt = con.prepareStatement(sql)){
            // Demana el nom del Brawler a consultar
            System.out.println("Escriu el nom del Brawler que vols comprovar: ");
            String nom = scan.nextLine();

            // Comprova si el brawler existeix
            PreparedStatement check = con.prepareStatement("SELECT COUNT(*) FROM brawlers WHERE nom = ?");
            check.setString(1,nom);
            ResultSet rs = check.executeQuery();

            if(rs.next() && rs.getInt(1) == 1){

                // Mostra les dades del Brawler
                stmt.setString(1,nom);
                ResultSet rs2 = stmt.executeQuery();
                    System.out.printf("Brawler ID: %-10d Nom: %-15s Class ID: %-5d Rarity ID: %-5d\n",
                            rs2.getInt("brawler_id"),
                            rs2.getString("nom"),
                            rs2.getInt("class_id"),
                            rs2.getInt("rarity_id")
                    );
            } else {
                System.out.println("El Brawler no existeix, prova amb un altre nom");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llegir dades de la base de dades");
        }
    }

    @Override
    public void eliminar(int id) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM brawlers WHERE brawler_id = ?");

            PreparedStatement check = con.prepareStatement("SELECT COUNT(*) FROM brawlers WHERE brawler_id = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("S'ha eliminat correctament");
            } else {
                System.out.println("El brawler no existeix, prova amb un altre");
            }
            con.close();
            ps.close();
            check.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @Override
    public void crear(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO brawlers(brawler_id, nom, class_id, rarity_id) VALUES (?,?,?,?)");
            ps.setInt(1, obj.getId());
            ps.
        } catch (SQLException e) {

        }
    }

    @Override
    public void actualitzar(Brawler obj) {

    }

}
