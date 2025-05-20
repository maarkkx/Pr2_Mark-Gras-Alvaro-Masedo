package View;

public class View {
    public static void menuPrincipal(){
        System.out.println("\n----- BRAWL STARS -----\n");

        System.out.println("1. Llistar els Brawlers actuals a la Base de Dades.");
        System.out.println("2. Llistar un Brawler actual de la Base de Dades.");
        System.out.println("3. Mostrar el contingut a l'Endpoint.");
        System.out.println("4. Modificar personatge segons l’endpoint.");
        System.out.println("5. Còpia total de les dades obtingudes de l’endpoint.");
        System.out.println("6. Mostrar contingut JSON.");
        System.out.println("7. Modificar personatge segons el JSON.");
        System.out.println("8. Còpia total de les dades obtingudes del JSON.");
        System.out.println("9. Mostrar tots els gadgets");
        System.out.println("10. Mostrar gadgets d'un Brawler");
        System.out.println("11. Mostrar tots els starpowers");
        System.out.println("12. Mostrar starpowers d'un Brawler");
        System.out.println("0. Sortir");
    }

    public static void menuCopiaEndpoint(){
        System.out.println("----- COPIAR DADES ENDPOINT -----\n");

        System.out.println("1. Còpia Parcial: Copiar personatges que no existeixen a la Base de Dades.");
        System.out.println("2. Còpia complerta: copiarà tots els personatges de l’endpoint a la BDD, sobrescrivint els existents.");
        System.out.println("0. Enrere.");
    }

    public static void menuCopiaJSON(){
        System.out.println("----- COPIAR DADES JSON -----\n");

        System.out.println("1. Còpia Parcial: Copiar personatges que no existeixen a la Base de Dades.");
        System.out.println("2. Còpia complerta: copiarà tots els personatges del JSON a la BDD, sobrescrivint els existents.");
        System.out.println("0. Enrere.");
    }
}
