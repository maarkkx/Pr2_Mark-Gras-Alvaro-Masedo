package model.dao.SQLite;

import model.Brawler;
import model.CRUD;
import model.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLiteStarpowerDAO implements CRUD {
    @Override
    public void crear(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO starpowers (starpower_id, nom, descripcio, brawler_id) VALUES (?,?,?,?)");
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM starpowers WHERE starpower_id = ?");
            for (Brawler.StarPower starpower : obj.getStarPowers()) {

                checkStmt.setInt(1, starpower.getId());
                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count == 0) {
                    ps.setInt(1, starpower.getId());
                    ps.setString(2, starpower.getName());
                    ps.setString(3, starpower.getDescription());
                    ps.setInt(4, obj.getId());
                    ps.executeUpdate();
                }
            }
            ps.close();
            checkStmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actualitzar(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM starpowers WHERE starpower_id = ?");
            PreparedStatement ps = con.prepareStatement("UPDATE starpowers SET starpower_id = ?, nom = ?, descripcio = ?, brawler_id = ? WHERE starpower_id = ?");

            for (Brawler.StarPower starpower : obj.getStarPowers()) {

                checkStmt.setInt(1, starpower.getId());
                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count == 1) {
                    ps.setInt(1, starpower.getId());
                    ps.setString(2, starpower.getName());
                    ps.setString(3, starpower.getDescription());
                    ps.setInt(4, obj.getId());
                    ps.setInt(5, starpower.getId());
                    ps.executeUpdate();
                }
            }
            ps.close();
            checkStmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(int id) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM starpowers WHERE brawler_id = ?");
            ps.setInt(1, id);

            PreparedStatement check = con.prepareStatement("SELECT COUNT(*) FROM starpowers WHERE starpower_id = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("S'ha eliminat correctament");
            } else {
                System.out.println("Les starpowers no existeixen, prova amb un altre");
            }

            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void llegirUnaEntrada() {
        Scanner scan = new Scanner(System.in);

        // Query SQL per llegir un brawler
        String sql = "SELECT * FROM starpowers WHERE brawler_id = ?";

        // Obre la connexió a la BD
        Connection con = DBConnection.openCon();

        try (PreparedStatement stmt = con.prepareStatement(sql)){
            // Demana el id del Brawler a consultar
            System.out.println("Escriu el ID del Brawler que vols comprovar: ");
            int id = scan.nextInt();

            // Comprova si el brawler existeix
            PreparedStatement check = con.prepareStatement("SELECT COUNT(*) FROM brawlers WHERE brawler_id = ?");
            check.setInt(1,id);
            ResultSet rs = check.executeQuery();
            stmt.setInt(1,id);
            ResultSet rs2 = stmt.executeQuery();
            while(rs2.next() && rs.getInt(1) == 1){
                // Mostra les dades del gadget
                System.out.printf("StarPower ID: %-10d Nom: %-25s Descripcio: %-130s Brawler ID: %-5d\n",
                        rs2.getInt("starpower_id"),
                        rs2.getString("nom"),
                        rs2.getString("descripcio"),
                        rs2.getInt("brawler_id")
                );
            }

            check.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llegir dades de la base de dades");
        }
    }

    @Override
    public void llegirTot() {
        // Query SQL per llegir tots els gadgets
        String sql = "SELECT * FROM starpowers";

        // Obre la connexió a la BD
        Connection con = DBConnection.openCon();

        try(PreparedStatement stmt = con.prepareStatement(sql)){
            // Executa la consulta i processa els resultats
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.printf("StarPower ID: %-10d Nom: %-25s Descripcio: %-130s Brawler ID: %-5d\n",
                        rs.getInt("starpower_id"),
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
