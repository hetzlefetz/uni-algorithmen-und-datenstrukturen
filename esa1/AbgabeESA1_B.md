# ESA1_B Algorithmen und Datenstrukturen (Ivo Valls)

## Aufgabe 1 : Implementieren sie die restlichen methoden in Analyze words

siehe `./src/main/java/de/vfh/algodat/AnalyzeWords1.java`.

## Aufgabe 2 : Vergleiche in der methode mostFrequent.

Durch die sehr naive implementierung werden n \* n = n² Vergleiche ausgeführt, denn die Funktion benutzt intern n mal die frequency Funktion, welche selber schon n Aufrufe ausführt.

### Werte für Blatest.txt und wikiGoethe.html

**Blatest.txt**

- Mostfrequent: bla
- Durchläufe: 100 (entspricht 10\*10)

**wikiGoehte.html**

- Mostfrequent: und
- Durchläufe: 943595524 (entspricht 30718\*30718)
