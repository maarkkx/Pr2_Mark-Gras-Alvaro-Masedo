package controller;

import model.dao.SQLite.SQLiteBrawlerDAO;

public class BrawlerController {
    /**
     *Funció que llista tots els Brawlers de la base de dades
     */
    public static void llistarTot(){
        SQLiteBrawlerDAO dao = new SQLiteBrawlerDAO();
        dao.llegirTot();
    }

    /**
     * Funció que llista un brawler en especific de la Base de Dades
     */
    public static void llistarUn(){
        SQLiteBrawlerDAO dao = new SQLiteBrawlerDAO();
        dao.llegirUnaEntrada();
    }
}
