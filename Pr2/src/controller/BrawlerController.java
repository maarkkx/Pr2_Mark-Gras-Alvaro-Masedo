package controller;

import model.dao.SQLite.SQLiteBrawlerDAO;

public class BrawlerController {
    public static void llistarTot(){
        SQLiteBrawlerDAO dao = new SQLiteBrawlerDAO();
        dao.llegirTot();
    }

    public static void llistarUn(){
        SQLiteBrawlerDAO dao = new SQLiteBrawlerDAO();
        dao.llegirUnaEntrada();
    }
}
