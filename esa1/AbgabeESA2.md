1- Zählen Sie in der Methode frequency, wie viele Vergleiche ausgeführt werden. Die entspricht dem Abschätzen, wie oft die grundlegende Anweisung ausgeführt wird, wie wir im Kapitel "Analyse von Algorithmen" sehen werden. Welche Zahlen bekommen Sie, wenn die Methode frequency die Wörter "abc" und "ab" Datei "Blatest.txt" und "Goethe", "Wolfgang" Datei "wikiGoethe.html" als Parameter hat. Kommentieren Sie kurz das Ergebnis.

Unter der annahme das es sich um ein sortiertes Array handelt kann man annehmen das sobald man das gesuchte wort gefunden hat und das nächste Wort nicht mehr dem gesuchten Wort entspricht, dass man die schleife verlassen kann. Durch dieses early return lassen sich die benötigten schleifendurchläufe reduzieren:

Ergebnisse Goethe.html:

Frequency von Goethe aus AnalyzeWords1: 747
Frequency von Goethe aus AnalyzeWords2: 747
Durchläufe AnalyzeWords1: 30718
Durchläufe AnalyzeWords2: 5533
Frequency von Wolfgang aus AnalyzeWords1: 89
Frequency von Wolfgang aus AnalyzeWords2: 89
Durchläufe AnalyzeWords1: 30718
Durchläufe AnalyzeWords2: 13893

Ergebnisse blatext.txt
Frequency von abc aus AnalyzeWords1: 2
Frequency von abc aus AnalyzeWords2: 2
Durchläufe AnalyzeWords1: 10
Durchläufe AnalyzeWords2: 3
Frequency von ab aus AnalyzeWords1: 1
Frequency von ab aus AnalyzeWords2: 1
Durchläufe AnalyzeWords1: 10
Durchläufe AnalyzeWords2: 1

2- Zählen Sie in der Methode mostFrequent, wie viele Vergleiche ausgeführt werden. Die entspricht dem Abschätzen, wie oft die grundlegende Anweisung ausgeführt wird, wie wir im Kapitel "Analyse von Algorithmen" sehen werden. Welche Zahlen bekommen Sie, wenn die Methode mostFrequent mit den Dateien "Blatest.txt" und "wikiGoethe.html" ausgeführt wird? Kommentieren Sie kurz das Ergebnis. Was ist das Ergebnis der Methode mostFrequent für beide Dateien und wie oft kommt das häufigste Wort vor?

Gleiches gilt für die Mostfrequent methode, nur das hier kein early return verwendet wird, sondern die Schrittweite der suche im array angepasst werden kann jenachdem wie häufig das gesuchte wort vorkommt können die nächsten n elemente übersprungen werden, da sie ja gleich sind.

mostFrequent von abc aus AnalyzeWords1: und
mostFrequent von abc aus AnalyzeWords2: und
Durchläufe AnalyzeWords1: 943595524
Durchläufe AnalyzeWords2: 101095887
IN:
Out:

mostFrequent von abc aus AnalyzeWords1: bla
mostFrequent von abc aus AnalyzeWords2: bla
Durchläufe AnalyzeWords1: 100
Durchläufe AnalyzeWords2: 41
