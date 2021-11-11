package de.vfh.algodat;

import java.io.IOException;
import java.util.Stack;

public class AnalyzeWords1 {

    private DownloadPage page;
    private String[] words;
    private int totalCount = 0;

    public int getTotalCount() {
        return totalCount;
    }

    public AnalyzeWords1(DownloadPage page) {
        this.page = page;
        this.words = page.getWords();
    }

    public AnalyzeWords1(String pageLink) throws IOException {
        this.page = new DownloadPage(pageLink);
        this.words = page.getWords();
    }

    /**
     * liefert die Anzahl von Vorkommen des Wortes word.
     * 
     * @param word - das gesuchte wort
     * @return - anahl der vorkommnisse
     */
    public int frequency(String word) {
        totalCount = 0;
        return _frequency(word);
    }

    private int _frequency(String word) {
        var ret = 0;
        for (String w : words) {
            totalCount++;
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
        totalCount = 0;
        return _mostFrequent();
    }

    private String _mostFrequent() {
        var currentMaxWord = "";
        var currentMaxCount = 0;
        for (var curr : words) { // +n
            var count = _frequency(curr);
            if (count > currentMaxCount) {
                currentMaxCount = count;
                currentMaxWord = curr;
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
        totalCount = 0;
        return _unique();
    }

    private String[] _unique() {
        var res = new Stack<String>();
        for (var curr : words) {
            totalCount++;
            if (_frequency(curr) == 1) {
                res.push(curr);
            }
        }
        return res.toArray(new String[0]);
    }

    private Integer[] allIndicesOf(String word) {
        var result = new Integer[0];
        for (int i = 0; i < words.length; i++) {
            totalCount++;
            if (words[i].equals(word)) {
                result = Utils.concat(result, i, Integer.class);
            }
        }
        return result;
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
        totalCount = 0;
        return _distance(string1, string2);
    }

    private int _distance(String string1, String string2) {
        var indexS1 = allIndicesOf(string1);
        var indexS2 = allIndicesOf(string2);
        if (indexS1.length == 0 || indexS2.length == 0)
            return Integer.MAX_VALUE;
        var currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < indexS2.length; i++) {
            totalCount++;
            for (int j = 0; j < indexS1.length; j++) {
                totalCount++;
                var tmp = indexS2[i] - indexS1[j];
                if (tmp != 0 && Math.abs(currentMin) > Math.abs(tmp))
                    currentMin = tmp;
            }
        }
        return currentMin;
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
        totalCount = 0;
        return _wordsNear(string, dist);
    }

    private String[] _wordsNear(String string, int dist) {
        var result = new String[0];
        for (var index : allIndicesOf(string)) {
            totalCount++;
            for (int i = 1; i <= dist; i++) {
                if (index - i >= 0) {
                    result = Utils.concat(result, words[index - 1], String.class);
                }
                if (index + i < words.length) {
                    result = Utils.concat(result, words[index + 1], String.class);
                }
            }
        }
        return result;
    }

}
