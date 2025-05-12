import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BrawlerWrapper {
    private List<Brawler> brawlers;
    public static void main(String[] args) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("nous_brawlers.json")) {
            BrawlerWrapper wrapper = gson.fromJson(reader, BrawlerWrapper.class);

            for (Brawler b : wrapper.getBrawlers()) {
                System.out.println("Nom:" + b.getNom);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
