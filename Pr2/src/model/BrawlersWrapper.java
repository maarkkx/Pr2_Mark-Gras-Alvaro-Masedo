package model;

import com.google.gson.Gson;
import controller.Controller;

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

        Controller.menu();
    }
}