package controller;
import View.*;
import java.util.Scanner;

import model.api.ApiConnection;
import model.api.OfficialApiConnection;
import model.dao.SQLite.SQLiteStarpowerDAO;
import model.jsonReaders.jsonReader;
import model.jsonReaders.jsonReaderOficial;

public class Controller {
    public static void menu(){
        int num = -2;
        Scanner scan = new Scanner(System.in);
        while (num != 0) {
            num = -1;
            View.menuPrincipal();
            num = scan.nextInt();
            scan.nextLine();
            switch (num){
                case 1:
                    //Llistar els Brawlers actuals a la Base de Dades.
                    BrawlerController.llistarTot();
                    break;
                case 2:
                    //Llistar un Brawler actual de la Base de Dades.
                    BrawlerController.llistarUn();
                    break;
                case 3:
                    //Mostrar el contingut JSON de la API NO OFICIAL
                    ApiConnection.getJson("https://api.brawlify.com/v1/brawlers", "Pr2/src/jsons/nous_brawlers.json");
                    jsonReader.llegirJson("Pr2/src/jsons/nous_brawlers.json");
                    break;
                case 4:
                    //Modificar personatge segons l’endpoint.
                    jsonReader.actualitzarUnBrawler();
                    break;
                case 5:
                    //Còpia total de les dades obtingudes de l’endpoint.
                    int num2 = -1;
                    while (num2 != 0){
                        View.menuCopiaEndpoint();
                        num2 = scan.nextInt();
                        scan.nextLine();
                        switch (num2){
                            case 1:
                                //Còpia Parcial: Copiar personatges que no existeixen a la Base de Dades.
                                ApiConnection.getJson("https://api.brawlify.com/v1/brawlers", "Pr2/src/jsons/nous_brawlers.json");
                                jsonReader.afegirBrawlers();
                                break;
                            case 2:
                                //Còpia complerta: copiarà tots els personatges de l’endpoint a la BDD, sobrescrivint els existents.
                                ApiConnection.getJson("https://api.brawlify.com/v1/brawlers", "Pr2/src/jsons/nous_brawlers.json");
                                jsonReader.llegirJson("Pr2/src/jsons/nous_brawlers.json");
                                jsonReader.actualitzarBrawlers();
                                break;
                        }
                    }
                    break;
                case 6:
                    //Mostrar contingut JSON de la API OFICIAL.
                    OfficialApiConnection.getJson("https://api.brawlstars.com/v1/brawlers", "Pr2/src/jsons/nous_brawlers_APIOFICIAL.json");
                    jsonReaderOficial.llegirJson("Pr2/src/jsons/nous_brawlers_APIOFICIAL.json");
                    break;
                case 7:
                    //Comprovar que existeix el Brawler segons la API oficial.
                    jsonReaderOficial.comprovarBrawlerJson("Pr2/src/jsons/nous_brawlers_APIOFICIAL.json");
                    break;
                case 8:
                    //Mostrar tots els gadgets
                    GadgetController.llistarTot();
                    break;
                case 9:
                    //Mostrar gadgets d'un Brawler
                    GadgetController.llistarUn();
                    break;
                case 10:
                    //Mostrar tots els starpowers
                    SQLiteStarpowerDAO sp = new SQLiteStarpowerDAO();
                    sp.llegirTot();
                    break;
                case 11:
                    //Mostrar starpowers d'un Brawler
                    SQLiteStarpowerDAO sp2 = new SQLiteStarpowerDAO();
                    sp2.llegirUnaEntrada();
                    break;
                case 0:
                    break;
            }
        }
    }
}
