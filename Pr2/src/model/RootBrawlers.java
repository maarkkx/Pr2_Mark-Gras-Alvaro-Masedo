package model;

import java.util.List;
/*Com el json comença amb una List hem de crear una clase amb una list per poder guardar aquesta llista de json dins
* de una llista d'aquesta clase. Dintre de auqesta llista hi ha brawlers amb tots els atributs del objecte*/
public class RootBrawlers {
    private List<Brawler> list;

    public List<Brawler> getList() {
        return list;
    }

    public void setList(List<Brawler> list) {
        this.list = list;
    }
}
