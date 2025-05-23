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
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM starpowers WHERE bralwer_id = ?");
            System.out.println("Escriu l'id del brawler que vols veure les starpower");
            int id = scan.nextInt();
            scan.nextLine();
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            con.close();
            scan.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void llegirTot() {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM starpowers");
            System.out.println("Escriu l'id del brawler que vols veure les starpower");
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
