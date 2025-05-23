package controller;

import model.dao.SQLite.SQLiteBrawlerDAO;
import model.dao.SQLite.SQLiteGadgetDAO;

public class GadgetController {

    /**
     * Funció que llista tots els gadgets de la Base de Dades
     */
    public static void llistarTot(){
        SQLiteGadgetDAO dao = new SQLiteGadgetDAO();
        dao.llegirTot();
    }

    /**
     * Funció que llista un gadget en especific de la base de Dades
     */
    public static void llistarUn(){
        SQLiteGadgetDAO dao = new SQLiteGadgetDAO();
        dao.llegirUnaEntrada();
    }
}
