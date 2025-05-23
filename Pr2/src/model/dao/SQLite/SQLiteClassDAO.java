package model.dao.SQLite;

import model.Brawler;
import model.CRUD;
import model.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteClassDAO implements CRUD {

    /**
     * Funcio per crear una clase
     * @param obj objecte necessari per els atributs de la clase
     */
    @Override
    public void crear(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO classes (class_id, nom) VALUES (?,?)");

            //comprova si ja existeix la clase, en cas de existir no fa res
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

    /**
     * Actualitza un objecte
     * @param obj objecte necessari per omplir els atributs del registre
     */
    @Override
    public void actualitzar(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE classes SET class_id = ?, nom = ? WHERE class_id = ?");

            //comprova si existeix la clase, en cas de existir la actualitza
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

    /**
     * Eliminar una clase segons el id
     * @param id id que necessita per eliminar la clase
     */
    @Override
    public void eliminar(int id) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM classes WHERE class_id = ?");

            //Comprovacio de si existeix la clase amb el id introduit
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
