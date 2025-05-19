package controller;
import View.*;
import java.util.Scanner;

public class Controller {
    public static void menu(){
        int num = -1;
        Scanner scan = new Scanner(System.in);
        while (num != 0) {
            View.menuPrincipal();
            num = scan.nextInt();
            scan.nextLine();
            switch (num){
                case 1:
                    //Llistar els Brawlers actuals a la Base de Dades.
                    BrawlerController.llistarTot();

                case 2:
                    //Llistar un Brawler actual de la Base de Dades.
                    BrawlerController.llistarUn();

                case 3:
                    //Mostrar el contingut a l'Endpoint.


                case 4:
                    //Modificar personatge segons l’endpoint.


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


                            case 2:
                                //Còpia complerta: copiarà tots els personatges de l’endpoint a la BDD, sobrescrivint els existents.


                        }
                    }
                    break;
                case 6:
                    //Mostrar contingut JSON.


                case 7:
                    //Modificar personatge segons el JSON.


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


                            case 2:
                                //Còpia complerta: copiarà tots els personatges del JSON a la BDD, sobrescrivint els existents.


                        }
                    }
                    break;
                case 0:
                    break;
            }
        }
    }
}
