# Instruccions del Programa

## 1. Execució del Programa
El programa es troba a:  
`model/main`

---

## 2. Menú del Programa

1. **Llistar els Brawlers actuals a la Base de Dades**  
   Mostra tots els brawlers guardats a la db.

2. **Llistar un Brawler actual de la Base de Dades**  
   Segons el nom (no importen majúscules) et retorna el brawler.

3. **Mostrar el contingut JSON de la API NO OFICIAL**  
   Descarrega el JSON de la API no oficial i el mostra.

4. **Modificar personatge segons l’endpoint**  
   Modifica una sola entrada segons el brawler que vulgui l'usuari.

5. **Còpia total de les dades obtingudes de l’endpoint**
   - **5.1 Còpia Parcial:**  
     Copiar personatges que no existeixen a la Base de Dades.  
     Crea tots els brawlers que no estan en la BBDD.
   - **5.2 Còpia Completa:**  
     Copiarà tots els personatges de l’endpoint a la BDD, sobrescrivint els existents.  
     Crea i actualitza tots els brawlers de la BBDD.

6. **Mostrar contingut JSON de la API OFICIAL**  
   Descarrega el JSON de la API oficial i el mostra.

7. **Comprovar que existeix el brawler segons la API OFICIAL**  
   Mira si existeix el brawler que l'usuari vol de la API oficial a la db.

8. **Mostrar tots els gadgets**  
   Mostra tots els gadgets de la db.

9. **Mostrar gadgets d'un Brawler**  
   Mostra els gadgets d'un brawler segons el seu id.

10. **Mostrar tots els starpowers**  
    Mostra tots els starpowers de la db.

11. **Mostrar starpowers d'un Brawler**  
    Mostra les starpowers d'un brawler segons el seu id.

---

## 3. Token de la API Oficial
Per accedir a la API oficial fa falta un token que s'ha de generar en cas que no funcioni.  
La variable del token està a:  
`src/model/api/OfficialApiConnection`

---

## 4. Classe Brawler
La classe `Brawler` té subclases internes perquè el JSON de la API no oficial retorna `starpowers` i `gadgets` en una llista.  
Per controlar aquestes dades s'han creat diferents classes dins.

---

## 5. Classe RootBrawler
`RootBrawler` és una classe que crea una llista de brawlers per poder agafar tots els brawlers del JSON alhora.

---

## 6. Funcionament amb la API No Oficial
El programa funciona amb la API no oficial.  
Per implementar la API oficial, s'ha afegit una funció que compara la informació del JSON de la API oficial amb la informació de la base de dades.

---

## 7. Emmagatzematge de JSONs
Els JSONs es guarden a:  
`src/jsons`

---

## 8. Creació de la Base de Dades
Per crear la base de dades (si es vol crear de nou), es poden utilitzar els scripts situats a:  
`/BDD/scripts`

---

## 9. Funcions Buïdes en Algunes Classes
Hi ha funcions a classes com `SQLiteRarityDAO` on les funcions de lectura de dades estan buides.  
Això és perquè tenim el CRUD implementat, però no és necessari mostrar algunes taules de la base de dades.
