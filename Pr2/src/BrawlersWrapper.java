import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BrawlersWrapper {
    private List<Brawler> brawlers;

    public List<Brawler> getBrawlers() {
        return brawlers;
    }

    //Main
    public static void main(String[] args) {
        DBConnection.openCon();
        DBConnection.closeCon(DBConnection.openCon());
        /*Gson gson = new Gson();

        try (FileReader reader = new FileReader("nous_brawlers.json")) {

            //un wrapper o "stream wrapper" ens permet llegir el cos de la petició HTTP. És a dir, una interfície que permet accedir a dades d’E/S (fitxers, sockets, text, ...)
            //amb la següent línia el que estem fent és convertir el contingut del JSON en un objecte java, com? utilitzant GSon
            //gson.fromJson > Llegeix dades JSON (des d'un Reader, String, InputStream, etc.)
            //Deserialitza aquest JSON (és a dir, el converteix en objectes Java)
            //que li passem per paràmetre a la funció fromJson?
            //1er argument (reader): està referenciant el fitxer
            //2n argument (BrawlersWrapper.class): nom de la classe que serialitzem, aquest argument li diu a Gson: "Vull que l'objecte que surt d'aquest JSON sigui un BrawlersWrapper."
            //és a dir, li estem dient quin tipus d'objecte Java ha de construir a partir del JSON.
            //en definitiva el que fa aquesta línia és dir-li a GSon: "Llegeix el JSON i crea un objecte de la classe BrawlersWrapper, omplint-ne els camps segons les dades que trobis"
            BrawlersWrapper wrapper = gson.fromJson(reader, BrawlersWrapper.class);

            //Gson busca al JSON la clau brawlers >> obrir nou_brawlers.json
            //Com que BrawlersWrapper té un camp List<Brawler> brawlers (linia 6 del codi), Gson sap que ha de deserialitzar aquesta llista d'objectes.
            //Per cada element dins l'array, crea un objecte de tipus Brawler i l'omple amb les dades corresponents (nom, raritat, etc.).
            //Finalment, retorna un objecte BrawlersWrapper que conté la llista.

            for (Brawler b : wrapper.getBrawlers()) {
                System.out.println("Brawler ID: " + b.getBrawler_id());
                System.out.println("Nom: " + b.getNom());
                System.out.println("Classe ID: " + b.getClass_id());
                System.out.println("Raritat ID: " + b.getRarity_id());
                System.out.println("-----------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}