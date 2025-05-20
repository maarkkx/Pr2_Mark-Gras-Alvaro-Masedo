package controller;
import View.*;
import java.util.Scanner;

import model.api.ApiConnection;
import model.dao.SQLite.SQLiteGadgetDAO;

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
                    //Mostrar el contingut a l'Endpoint.

                    break;
                case 4:
                    //Modificar personatge segons l’endpoint.

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

                                break;
                            case 2:
                                //Còpia complerta: copiarà tots els personatges de l’endpoint a la BDD, sobrescrivint els existents.
                                ApiConnection.getJson("https://api.brawlify.com/v1/brawlers", "src/jsons/nous_brawlers.json");
                                ApiConnection.llegirJson();
                                break;
                        }
                    }
                    break;
                case 6:
                    //Mostrar contingut JSON.

                    break;
                case 7:
                    //Modificar personatge segons el JSON.

                    break;
                case 8:
                    //Còpia total de les dades obtingudes del JSON.
                    int num3 = -1;
                    while (num3 != 0){
                        View.menuCopiaJSON();
                        num3 = scan.nextInt();
                        scan.nextLine();
                        switch (num3){
                            case 1:
                                //Còpia Parcial: Copiar personatges que no existeixen a la Base de Dades.

                                break;
                            case 2:
                                //Còpia complerta: copiarà tots els personatges del JSON a la BDD, sobrescrivint els existents.

                                break;
                        }
                    }
                    break;
                case 9:
                    //Mostrar tots els gadgets
                    BrawlerController.llistarTot();
                    break;
                case 10:
                    //Mostrar gadgets d'un Brawler
                    BrawlerController.llistarUn();
                    break;
                case 11:
                    //Mostrar tots els starpowers

                    break;
                case 12:
                    //Mostrar starpowers d'un Brawler

                    break;
                case 0:
                    break;
            }
        }
    }
}
