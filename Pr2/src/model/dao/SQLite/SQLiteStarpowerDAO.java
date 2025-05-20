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
            ps.setInt(1, obj.getStarPowers().get(0).getId());
            ps.setString(2, obj.getStarPowers().get(0).getName());
            ps.setString(3, obj.getStarPowers().get(0).getDescription());
            ps.setInt(4, obj.getId());

            ps.executeUpdate();
            ps.close();

            PreparedStatement ps2 = con.prepareStatement("INSERT INTO starpowers (starpower_id, nom, descripcio, brawler_id) VALUES (?,?,?,?)");
            ps2.setInt(1, obj.getStarPowers().get(1).getId());
            ps2.setString(2, obj.getStarPowers().get(1).getName());
            ps2.setString(3, obj.getStarPowers().get(1).getDescription());
            ps2.setInt(4, obj.getId());

            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actualitzar(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE starpowers SET starpower_id = ?, nom = ?, descripcio = ?, brawler_id = ? WHERE starpower_id = ?");
            ps.setInt(1, obj.getStarPowers().get(0).getId());
            ps.setString(2, obj.getStarPowers().get(0).getName());
            ps.setString(3, obj.getStarPowers().get(0).getDescription());
            ps.setInt(4, obj.getId());
            ps.setInt(5, obj.getStarPowers().get(0).getId());

            ps.executeUpdate();
            ps.close();

            PreparedStatement ps2 = con.prepareStatement("UPDATE starpowers SET starpower_id = ?, nom = ?, descripcio = ?, brawler_id = ? WHERE starpower_id = ?");
            ps2.setInt(1, obj.getStarPowers().get(1).getId());
            ps2.setString(2, obj.getStarPowers().get(1).getName());
            ps2.setString(3, obj.getStarPowers().get(1).getDescription());
            ps2.setInt(4, obj.getId());
            ps2.setInt(5, obj.getStarPowers().get(1).getId());

            ps2.executeUpdate();
            ps2.close();
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
