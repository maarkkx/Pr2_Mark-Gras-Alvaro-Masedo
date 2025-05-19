package controller;
import View.*;
import java.util.Scanner;

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


                case 2:
                    //Mostrar el contingut a l'Endpoint.


                case 3:
                    //Modificar personatge segons l’endpoint.


                case 4:
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
                case 5:
                    //Mostrar contingut JSON.


                case 6:
                    //Modificar personatge segons el JSON.


                case 7:
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
