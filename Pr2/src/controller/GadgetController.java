package controller;

import model.dao.SQLite.SQLiteBrawlerDAO;
import model.dao.SQLite.SQLiteGadgetDAO;

public class GadgetController {
    public static void llistarTot(){
        SQLiteGadgetDAO dao = new SQLiteGadgetDAO();
        dao.llegirTot();
    }

    public static void llistarUn(){
        SQLiteGadgetDAO dao = new SQLiteGadgetDAO();
        dao.llegirUnaEntrada();
    }
}
