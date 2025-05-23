1- Per executar el programa està a `model/main`.

2- Menú programa:  
  1. Llistar els Brawlers actuals a la Base de Dades:  
     Mostra tots els brawlers guardats a la db.  
  2. Llistar un Brawler actual de la Base de Dades:  
     Segons el nom (no importen majúscules) et retorna el brawler.  
  3. Mostrar el contingut JSON de la API NO OFICIAL:  
     Descarrega el JSON de la API no oficial i el mostra.  
  4. Modificar personatge segons l’endpoint:  
     Modifica una sola entrada segons el brawler que vulgui l'usuari.  
  5. Còpia total de les dades obtingudes de l’endpoint:  
    5.1 Còpia Parcial: Copiar personatges que no existeixen a la Base de Dades:  
        Crea tots els brawlers que no estan en la BBDD.  
    5.2 Còpia completa: copiarà tots els personatges de l’endpoint a la BDD, sobrescrivint els existents:  
        Crea i actualitza tots els brawlers de la BBDD.  
  6. Mostrar contingut JSON de la API OFICIAL:  
     Descarrega el JSON de la API oficial i el mostra.  
  7. Comprovar que existeix el brawler segons la API OFICIAL:  
     Mira si existeix el brawler que l'usuari vol de la API oficial a la db.  
  8. Mostrar tots els gadgets:  
     Mostra tots els gadgets de la db.  
  9. Mostrar gadgets d'un Brawler:  
     Mostra els gadgets d'un brawler segons el seu id.  
  10. Mostrar tots els starpowers:  
      Mostra tots els starpowers de la db.  
  11. Mostrar starpowers d'un Brawler:  
      Mostra les starpowers d'un brawler segons el seu id.

3- Per poder accedir a la API oficial fa falta un token que s'ha de generar en cas de que no funcioni.  
La variable del token està a `src/model/api/OfficialApiConnection`.

4- En la classe Brawler, té subclases dins ja que el JSON de la API no oficial retorna starpowers i gadgets en una llista.  
Per poder controlar les dades hem creat diferents classes dins.

5- `RootBrawler` és una classe que crea una llista de brawlers per poder agafar tots els brawlers del JSON a la vegada.

6- El programa funciona tot amb la API no oficial.  
Per implementar la API oficial hem posat una funció per comparar la informació del JSON que ens dona la API oficial amb la informació de la nostra db.

7- Els JSONs es guarden a `src/jsons`.
