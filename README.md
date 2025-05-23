1-Per executar el programa esta a model/main.

2-Menu programa:
  1-Llistar els Brawlers actuals a la Base de Dades: Mostra tots els brawlers guardats a la db.
  2-Llistar un Brawler actual de la Base de Dades: Segons el nom (no importan majuscules) et retorna el brawler.
  3-Mostrar el contingut JSON de la API NO OFICIAL: Descarrega el json de la api no oficial y el mostra.
  4-Modificar personatge segons l’endpoint: Modifica una sola entrada segons el brawler que vulgui l'usuari.
  5-Còpia total de les dades obtingudes de l’endpoint.
    5.1-Còpia Parcial: Copiar personatges que no existeixen a la Base de Dades: Crea tots els brawlers que no estan en la BBDD.
    5.2-Còpia complerta: copiarà tots els personatges de l’endpoint a la BDD, sobrescrivint els existents: Crea i actualitza tots els brawlers de la BBDD.
  6-Mostrar contingut JSON de la API OFICIAL: Descarrega el JSON de la api oficial i el mostra.
  7-Comprovar que existeix el brawler segons la API OFICIAL: Mira si existeix el brawler que l'usuari vol de la API oficial a la db.
  8-Mostrar tots els gadgets: Mostra tots els gadgets de la db.
  9-Mostrar gadgets d'un Brawler: Mostra els gadgets de un brawler segons el seu id.
  10-Mostrar tots els starpowers: Mostra tots els starpowers de la db.
  11-Mostrar starpowers d'un Brawler: Mostra les starpower de un brawler segons el seu id.

3-Per poder accedir a la API oficial fa falta un token que s'ha de generar en cas de que no funcioni. La variable del token esta a "src/model/api/OfficialApiConnection".

4-En la clase Brawler, te subclases dins ja que el json de la api no oficial retorna starpowers i gadgets en una llista. Per poder controlar les dades hem creat diferents clases dins.

5-RootBrawler es una clase que crea una llista de brawlers per poder agafar tots els brawlers del json a la vegada.

6-El programa funciona tot amb la api no oficial. Per implementar la API oficial hem posat una funcio per comparar la informacio del json que ens dona la api oficial amb l'informacio de la nostre db.

7-Els jsons es guarden a "src/jsons"
