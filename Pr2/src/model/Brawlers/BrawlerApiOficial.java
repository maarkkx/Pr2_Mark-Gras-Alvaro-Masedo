package model.Brawlers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Classe que representa un Brawler segons l'API oficial de Brawl Stars.
 * Aquesta classe es fa servir per deserialitzar automàticament les dades JSON obtingudes de l'API.
 */
public class BrawlerApiOficial {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("starPowers")
    private List<StarPower> starPowers;

    @SerializedName("gadgets")
    private List<Gadget> gadgets;

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StarPower> getStarPowers() {
        return starPowers;
    }

    public void setStarPowers(List<StarPower> starPowers) {
        this.starPowers = starPowers;
    }

    public List<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    // Inner classes
    /**
     * Classe interna que representa una Star Power d'un Brawler.
     */
    public static class StarPower {
        private int id;
        private String name;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    /**
     * Classe interna que representa un Gadget d'un Brawler.
     */
    public static class Gadget {
        private int id;
        private String name;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
