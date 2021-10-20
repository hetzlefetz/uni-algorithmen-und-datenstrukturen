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

    public static int[] merge(int[] a, int[] b) {
        var result = new int[a.length + b.length];
        var currentLeft = 0;
        var currentRight = 0;
        var lastIndex = 0;
        for (int i = 0; i < Integer.max(a.length, b.length); i++) {
            if (currentLeft < a.length && currentRight < b.length) {
                if (a[currentLeft] <= b[currentRight]) {
                    result[i] = a[currentLeft++];

                } else {
                    result[i] = b[currentRight++];
                }
            }
            lastIndex++;
        }
        if (currentLeft < a.length) {
            for (int i = currentLeft; i < a.length; i++) {
                result[lastIndex++] = a[i];
            }
        }
        if (currentRight < b.length) {
            for (int i = currentRight; i < b.length; i++) {
                result[lastIndex++] = b[i];
            }
        }
        return result;
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

    private int firstIndexOf(String word, int startIndex) {
        for (int i = 0; i < words.length; i++) {
            totalCount++;
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    private Integer[] allIndicesOf(String word) {
        var result = new Stack<Integer>();
        for (int i = 0; i < words.length; i++) {
            totalCount++;
            if (words[i].equals(word)) {
                result.push(i);
            }
        }
        return result.toArray(new Integer[0]);
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

        var indexS1 = firstIndexOf(string1, 0);
        var indexS2 = firstIndexOf(string2, string1.equals(string2) ? indexS1 + 1 : 0);

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
        totalCount = 0;
        return _wordsNear(string, dist);
    }

    private String[] _wordsNear(String string, int dist) {
        var result = new Stack<String>();
        for (var index : allIndicesOf(string)) {
            for (int i = 1; i <= dist; i++) {
                if (index - i >= 0) {
                    result.push(words[index - i]);
                }
                if (index + i < words.length) {
                    result.push(words[index + i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
