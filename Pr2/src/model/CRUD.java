package model;

public interface CRUD<Object>{
    void crear(Brawler obj);

    void actualitzar(Brawler obj);

    void eliminar(int id);

    void llegirUnaEntrada();

    void llegirTot();
}
