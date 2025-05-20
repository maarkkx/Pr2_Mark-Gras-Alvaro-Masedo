package model.dao.SQLite;

import model.Brawler;
import model.CRUD;
import model.dao.DBConnection;

import javax.naming.CompositeName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteGadgetDAO implements CRUD {
    @Override
    public void crear(Brawler obj) {
        String sql = "INSERT INTO gadgets (gadget_id,nom,descripcio,brawler_id) VALUES (?,?,?,?)";
        Connection con = DBConnection.openCon();

        try (PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1,obj.getGadgets().get(1).getId());
            stmt.setString(2,obj.getGadgets().get(1).getName());
            stmt.setString(3,obj.getGadgets().get(1).getDescription());
            stmt.setInt(4,obj.getId();
        } catch (SQLException e){
            System.out.println("Error al afegir dades a la Base de Dades (Gadgets)");
        }
    }

    @Override
    public void actualitzar(Brawler obj) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void llegirUnaEntrada() {

    }

    @Override
    public void llegirTot() {

    }
}
