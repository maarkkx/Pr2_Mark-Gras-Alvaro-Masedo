package model.dao.SQLite;

import model.Brawlers.Brawler;
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
        // Query SQL per llegir tots els brawlers
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

        // Query SQL per llegir un brawler
        String sql = "SELECT * FROM brawlers WHERE nom = ?";

        // Obre la connexió a la BD
        Connection con = DBConnection.openCon();

        try (PreparedStatement stmt = con.prepareStatement(sql)){
            // Demana el nom del Brawler a consultar
            System.out.println("Escriu el nom del Brawler que vols comprovar: ");
            String nom = scan.nextLine();

            //Fica el nom amb la primera lletra en majuscula
            nom = nom.substring(0, 1).toUpperCase() + nom.substring(1).toLowerCase();

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
            check.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llegir dades de la base de dades");
        }
    }

    /**
     * Funcio per eliminar un brawler segons el id
     * @param id el que utilitza per eliminar el brawler
     */
    @Override
    public void eliminar(int id) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM brawlers WHERE brawler_id = ?");

            //statement per veure si el brawler existeix abans de eliminar-lo
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

    /**
     * Funcio per crear un brawler
     * @param obj objecte que necessita per crear un brawler a la BBDD
     */
    @Override
    public void crear(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO brawlers(brawler_id, nom, class_id, rarity_id) VALUES (?,?,?,?)");

            //Comprovació si el brawler ja existeix, en el cas de que si no fa res.
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM brawlers WHERE brawler_id = ?");
            checkStmt.setInt(1, obj.getId());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if(count == 0) {
                ps.setInt(1, obj.getId());
                ps.setString(2, obj.getName());
                ps.setInt(3, obj.getBrawlerClass().getId());
                ps.setInt(4, obj.getRarity().getId());

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
     * Actualitza un brawler
     * @param obj objecte necessari per agafar els atributs del brawler i actualitzar-lo
     */
    @Override
    public void actualitzar(Brawler obj) {
        Connection con = DBConnection.openCon();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE brawlers SET brawler_id = ?, nom = ?, class_id = ?, rarity_id = ? WHERE brawler_id = ?");

            //Comprovacio de que existeix el brawler, en cas de que existeixi l'actualitza, sino no fa res
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM brawlers WHERE brawler_id = ?");
            checkStmt.setInt(1, obj.getId());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 1) {
                ps.setInt(1, obj.getId());
                ps.setString(2, obj.getName());
                ps.setInt(3, obj.getBrawlerClass().getId());
                ps.setInt(4, obj.getRarity().getId());
                ps.setInt(5, obj.getId());

                ps.executeUpdate();
            }


            checkStmt.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
