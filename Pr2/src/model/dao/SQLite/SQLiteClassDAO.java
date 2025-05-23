package model.dao.SQLite;

import model.Brawlers.Brawler;
import model.CRUD;
import model.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteClassDAO implements CRUD {

    @Override
    public void crear(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO classes (class_id, nom) VALUES (?,?)");
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM classes WHERE class_id = ?");

            checkStmt.setInt(1, obj.getBrawlerClass().getId());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                ps.setInt(1, obj.getBrawlerClass().getId());
                ps.setString(2, obj.getBrawlerClass().getName());
                ps.executeUpdate();
            }

            checkStmt.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actualitzar(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE classes SET class_id = ?, nom = ? WHERE class_id = ?");
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM classes WHERE class_id = ?");

            checkStmt.setInt(1, obj.getBrawlerClass().getId());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count == 1) {
                ps.setInt(1, obj.getBrawlerClass().getId());
                ps.setString(2, obj.getBrawlerClass().getName());
                ps.setInt(3, obj.getBrawlerClass().getId());
                ps.executeUpdate();
            }

            checkStmt.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(int id) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM classes WHERE class_id = ?");

            PreparedStatement check = con.prepareStatement("SELECT COUNT(*) FROM classes WHERE class_id = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("S'ha eliminat correctament");
            } else {
                System.out.println("La classe no existeix, prova amb un altre");
            }

            check.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void llegirUnaEntrada() {

    }

    @Override
    public void llegirTot() {

    }
}
