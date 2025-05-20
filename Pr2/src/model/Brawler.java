package model;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Brawler {

    private int id;
    private String name;

    /*Com el json que ens passa la api te diferents items dins de altres items necessitem clases dintre de aquesta
    * per poder gestionar tot. (Rarity esta dintre del brawler). starpower i gadget es una List ja que cada brawler
    * te 2 de cada.*/
    @SerializedName("class")
    private BrawlerClass brawlerClass;

    private Rarity rarity;

    //necessitem dues llistes ja que cada brawler te 2 starpower i 2 gadgets
    private List<StarPower> starPowers;
    private List<Gadget> gadgets;

    public int getId() { return id; }
    public String getName() { return name; }
    public BrawlerClass getBrawlerClass() { return brawlerClass; }
    public Rarity getRarity() { return rarity; }
    public List<StarPower> getStarPowers() { return starPowers; }
    public List<Gadget> getGadgets() { return gadgets; }


    /*Clases de les que he parlat abans per poder gestionar els objectes que hi ha dintre del brawler*/
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
