package model;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Brawler {

    private int id;
    private String name;

    @SerializedName("class")
    private BrawlerClass brawlerClass;

    private Rarity rarity;

    private List<StarPower> starPowers;
    private List<Gadget> gadgets;

    // Getters y setters

    public int getId() { return id; }
    public String getName() { return name; }
    public BrawlerClass getBrawlerClass() { return brawlerClass; }
    public Rarity getRarity() { return rarity; }
    public List<StarPower> getStarPowers() { return starPowers; }
    public List<Gadget> getGadgets() { return gadgets; }

    // Clases internas para las estructuras anidadas

    public static class BrawlerClass {
        private int id;
        private String name;

        public int getId() { return id; }
        public String getName() { return name; }
    }

    public static class Rarity {
        private int id;
        private String name;

        public int getId() { return id; }
        public String getName() { return name; }
    }

    public static class StarPower {
        private int id;
        private String name;
        private String description;

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDescription() { return description; }
    }

    public static class Gadget {
        private int id;
        private String name;
        private String description;

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDescription() { return description; }
    }
}
