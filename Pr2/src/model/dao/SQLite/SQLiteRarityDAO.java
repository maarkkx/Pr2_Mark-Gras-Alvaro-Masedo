package model.dao.SQLite;

import model.Brawlers.Brawler;
import model.CRUD;
import model.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteRarityDAO implements CRUD {

    @Override
    public void crear(Brawler obj) {
        String sql = "INSERT INTO rarities (rarity_id, nom) VALUES (?,?)";
        String sqlSelect = "SELECT COUNT(*) FROM rarities WHERE rarity_id = ?";
        Connection con = DBConnection.openCon();

        try (PreparedStatement stmt = con.prepareStatement(sql);
            PreparedStatement checkStmt = con.prepareStatement(sqlSelect)){

            checkStmt.setInt(1, obj.getRarity().getId());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                stmt.setInt(1,obj.getRarity().getId());
                stmt.setString(2,obj.getRarity().getName());
                stmt.executeUpdate();
                System.out.println("Rarity afegida: " + obj.getRarity().getName());
            }

            checkStmt.close();
            stmt.close();
            con.close();
        } catch (SQLException e){
            System.out.println("Error al afegir dades a la Base de Dades (Rarity)");
        }
    }

    @Override
    public void actualitzar(Brawler obj) {
        String sql = "UPDATE rarities SET rarity_id = ?, nom = ? WHERE rarity_id = ?";
        String sqlSelect = "SELECT COUNT(*) FROM rarities WHERE rarity_id = ?";
        Connection con = DBConnection.openCon();

        try(PreparedStatement stmt = con.prepareStatement(sql);
            PreparedStatement checkStmt = con.prepareStatement(sqlSelect)){

            checkStmt.setInt(1, obj.getRarity().getId());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count == 1) {
                stmt.setInt(1,obj.getRarity().getId());
                stmt.setString(2,obj.getRarity().getName());
                stmt.setInt(3,obj.getRarity().getId());
                stmt.executeUpdate();
            }

            checkStmt.close();
            stmt.close();
            con.close();
        } catch (SQLException e){
            System.out.println("Error al actualitzar dades a la Base de Dades (Rarity)");
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM rarities WHERE rarity_id = ?";
        String sqlSelect = "SELECT COUNT(*) FROM rarities WHERE rarity_id = ?";
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
                System.out.println("La rarity no existeix, proba amb una altre");
            }
            con.close();
            stmt.close();
            check.close();
        } catch (SQLException e){
            System.out.println("Error al eliminar dades a la Base de Dades (Rarity)");
        }
    }

    @Override
    public void llegirUnaEntrada() {

    }

    @Override
    public void llegirTot() {

    }
}
