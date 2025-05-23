package model.dao.SQLite;

import model.Brawler;
import model.CRUD;
import model.dao.DBConnection;

import javax.naming.CompositeName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLiteGadgetDAO implements CRUD {
    @Override
    public void crear(Brawler obj) {
        String sql = "INSERT INTO gadgets (gadget_id, nom, descripcio, brawler_id) VALUES (?, ?, ?, ?)";
        String sqlCheck = "SELECT COUNT(*) FROM gadgets WHERE gadget_id = ?";
        Connection con = DBConnection.openCon();

        try {
            for (Brawler.Gadget gadget : obj.getGadgets()) {
                try (PreparedStatement stmt = con.prepareStatement(sql);
                     PreparedStatement checkStmt = con.prepareStatement(sqlCheck)) {

                    checkStmt.setInt(1, gadget.getId());
                    ResultSet rs = checkStmt.executeQuery();
                    rs.next();
                    int count = rs.getInt(1);

                    if (count == 0) {
                        stmt.setInt(1, gadget.getId());
                        stmt.setString(2, gadget.getName());
                        stmt.setString(3, gadget.getDescription());
                        stmt.setInt(4, obj.getId());
                        stmt.executeUpdate();
                        stmt.close();
                        checkStmt.close();
                        System.out.println("Gadget afegit: " + gadget.getName());
                    }
                }
            }
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actualitzar(Brawler obj) {
        String sql = "UPDATE gadgets SET gadget_id = ?, nom = ?, descripcio = ?, brawler_id = ? WHERE gadget_id = ?";
        String sqlCheck = "SELECT COUNT(*) FROM gadgets WHERE gadget_id = ?";
        Connection con = DBConnection.openCon();

        try {
            for (Brawler.Gadget gadget : obj.getGadgets()) {
                try (PreparedStatement stmt = con.prepareStatement(sql);
                     PreparedStatement checkStmt = con.prepareStatement(sqlCheck)) {

                    checkStmt.setInt(1, gadget.getId());
                    ResultSet rs = checkStmt.executeQuery();
                    rs.next();
                    int count = rs.getInt(1);

                    if (count == 0) {
                        stmt.setInt(1, gadget.getId());
                        stmt.setString(2, gadget.getName());
                        stmt.setString(3, gadget.getDescription());
                        stmt.setInt(4, obj.getId());
                        stmt.setInt(5, gadget.getId());

                        stmt.executeUpdate();

                    }
                    stmt.close();
                    checkStmt.close();
                }

            }
            con.close();

        } catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM gadgets WHERE brawler_id = ?";
        String sqlSelect = "SELECT COUNT(*) FROM gadgets WHERE brawler_id = ?";
        Connection con = DBConnection.openCon();

        try(PreparedStatement stmt = con.prepareStatement(sql)){
            PreparedStatement check = con.prepareStatement(sqlSelect);

            check.setInt(1,id);
            ResultSet rs = check.executeQuery();

            if(rs.next() && rs.getInt(1) > 0){
                stmt.setInt(1,id);
                stmt.executeUpdate();
                System.out.println("S'ha eliminat correctament");
            } else {
                System.out.println("El brawler o gadget no existeixen a la base de dades, proba amb una altre");
            }
            con.close();
            stmt.close();
            check.close();
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    /**
     * Demana el id de un Brawler
     * Cerca a la Base de dades si existeix
     * Retorna els gadgets d'aquest Brawler
     */
    public void llegirUnaEntrada(){
        Scanner scan = new Scanner(System.in);

        // Query SQL per llegir un brawler
        String sql = "SELECT * FROM gadgets WHERE brawler_id = ?";

        // Obre la connexió a la BD
        Connection con = DBConnection.openCon();

        try (PreparedStatement stmt = con.prepareStatement(sql)){
            // Demana el id del Brawler a consultar
            System.out.println("Escriu el ID del Brawler que vols comprovar: ");
            int id = scan.nextInt();

            // Comprova si el brawler existeix
            PreparedStatement check = con.prepareStatement("SELECT COUNT(*) FROM brawlers WHERE nom = ?");
            check.setInt(1,id);
            ResultSet rs = check.executeQuery();

            if(rs.next() && rs.getInt(1) == 1){
                // Mostra les dades del gadget
                stmt.setInt(1,id);
                ResultSet rs2 = stmt.executeQuery();
                System.out.printf("Gadget ID: %-10d Nom: %-25s Descripcio: %-130s Brawler ID: %-5d\n",
                        rs2.getInt("gadget_id"),
                        rs2.getString("nom"),
                        rs2.getString("descripcio"),
                        rs2.getInt("brawler_id")
                );
            } else {
                System.out.println("El Brawler no existeix, prova amb un altre ID");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llegir dades de la base de dades");
        }
    }

    @Override
    public void llegirTot() {
        // Query SQL per llegir tots els gadgets
        String sql = "SELECT * FROM gadgets";

        // Obre la connexió a la BD
        Connection con = DBConnection.openCon();

        try(PreparedStatement stmt = con.prepareStatement(sql)){
            // Executa la consulta i processa els resultats
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.printf("Gadget ID: %-10d Nom: %-25s Descripcio: %-130s Brawler ID: %-5d\n",
                        rs.getInt("gadget_id"),
                        rs.getString("nom"),
                        rs.getString("descripcio"),
                        rs.getInt("brawler_id")
                );
            }
            stmt.close();
            con.close();
        } catch (SQLException e){
            System.out.println("Error al llegir dades de la Base de Dades");
        }
    }
}
