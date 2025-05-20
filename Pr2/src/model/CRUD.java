package model;

public interface CRUD<Brawler>{
    void crear(Brawler obj);

    void actualitzar(Brawler obj);

    void eliminar(int id);

    void llegirUnaEntrada();

    void llegirTot();
}
