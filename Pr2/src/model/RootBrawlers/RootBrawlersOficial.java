package model.RootBrawlers;

import com.google.gson.annotations.SerializedName;
import model.Brawlers.BrawlerApiOficial;

import java.util.List;

public class RootBrawlersOficial {
    @SerializedName("items")
    private List<BrawlerApiOficial> items;

    public List<BrawlerApiOficial> getItems() {
        return items;
    }

    public void setItems(List<BrawlerApiOficial> items) {
        this.items = items;
    }
}
