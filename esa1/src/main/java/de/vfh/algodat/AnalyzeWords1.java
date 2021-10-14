package de.vfh.algodat;

import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Stack;

public class AnalyzeWords1 {

    private DownloadPage page;

    public AnalyzeWords1(DownloadPage page) {
        this.page = page;

    }

    public AnalyzeWords1(String pageLink) throws IOException {
        this.page = new DownloadPage(pageLink);

    }

    /**
     * liefert die Anzahl von Vorkommen des Wortes word.
     * 
     * @param word - das gesuchte wort
     * @return - anahl der vorkommnisse
     */
    public int frequency(String word) {

        var ret = 0;
        for (String w : page.getWords()) { // +n
            if (w.equals(word)) {
                ret++;
            }
        }
        return ret;

    }

    /**
     * liefert das häufigste Wort in der Seite.
     * 
     * @return
     */
    public String mostFrequent() {
        var words = page.getWords(); // +1
        var x = new Hashtable<String, Integer>((int) words.length / 2); // +1
        var currentMaxWord = "";
        var currentMaxCount = 0;
        for (var curr : words) { // +n
            var cnt = x.putIfAbsent(curr, 1); // +n
            if (cnt != null) { // +n
                x.put(curr, ++cnt); // bestcase: +0 wenn nur unique wörter im dokument, worstcase +n wenn nur
                                    // gleiche wörter im dokument

            }
            if (cnt != null && cnt > currentMaxCount) { // +n
                currentMaxWord = curr; // worstcase: +0 wenn nur unique wörter im dokument, bestcase +n wenn nur
                // gleiche wörter im dokument
            }
        }
        return currentMaxWord;

    }

    /**
     * liefert ein Array, das alle Wörter enthält, die nur genau einmal vorkommen.
     * 
     * @return
     */
    public String[] unique() {
        var words = page.getWords(); // +1
        var x = new Hashtable<String, Integer>((int) words.length / 2); // +1

        for (var curr : words) { // +n
            var cnt = x.putIfAbsent(curr, 1); // +n
            if (cnt != null) { // +n
                x.put(curr, ++cnt); // bestcase: +0 wenn nur unique wörter im dokument, worstcase +n wenn nur
                                    // gleiche wörter im dokument
            }

        }
        var res = new Stack<String>();
        for (var item : x.entrySet()) {
            if (item.getValue() == 1) {
                res.push(item.getKey());

            }
        }

        return res.toArray(new String[0]);
    }

    /**
     * berechnet die kleinste Distanz zwischen einem Vorkommen von string1 und einem
     * Vorkommen von string2 . Dabei soll das Vorzeichen negativ sein, wenn die
     * kürzeste Distanz erreicht ist, wenn string2 vor string1 vorkommt. Sollte eine
     * der beiden Zeichenketten gar nicht vorkommen, dann soll distance den Wert
     * Integer.MAX_VALUE liefern. Falls string2 gleich string1 ist, dann soll
     * distance nicht 0 liefern, sondern die kleinste Distanz zwischen zwei
     * verschiedenen Vorkommen von string1, bzw. Integer.MAX_VALUE, wenn das Wort
     * nur einmal vorkommt.
     * 
     * @param string1
     * @param string2
     * @return
     */
    public int distance(String string1, String string2) {
        var words = page.getWords(); // +1
        var x = new LinkedHashMap<String, Integer>((int) words.length / 2); // +1
        var indexS1 = -1;
        var indexS2 = -1;
        var i = -1;
        for (var curr : words) { // +n
            i += 1;
            var cnt = x.putIfAbsent(curr, 1); // +n
            if (cnt != null) { // +n
                x.put(curr, ++cnt); // bestcase: +0 wenn nur unique wörter im dokument, worstcase +n wenn nur
                                    // gleiche wörter im dokument
            }
            if (curr == string1 && indexS1 == -1) {
                indexS1 = i;
            }
            if (curr == string2 && indexS2 == -1) {
                indexS2 = i;
                if (indexS2 == indexS1) { // reset if indices were same
                    indexS2 = -1;
                }
            }

        }
        if (indexS1 == -1 || indexS2 == -1) {
            return Integer.MAX_VALUE;
        }
        return indexS2 - indexS1;

    }

    /**
     * liefert ein Array aller Wörter, die in einer Distanz von maximal dist zu dem
     * Wort stehen (davor oder danach). Das Array kann doppelte Einträge enthalten,
     * wenn Wörter mehrfach vorkommen. Das Array ist nicht sortiert.
     * 
     * @param string
     * @param dist
     * @return
     */
    public String[] wordsNear(String string, int dist) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
