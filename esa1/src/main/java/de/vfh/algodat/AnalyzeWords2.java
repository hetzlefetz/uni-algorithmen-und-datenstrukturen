package de.vfh.algodat;

import java.io.IOException;
import java.lang.reflect.Array;
import java.security.InvalidAlgorithmParameterException;

class SortedWord implements Comparable<SortedWord> {
    private String _word;
    private int _originalPosition;

    public SortedWord(String word, int originalPosition) {
        _word = word;
        _originalPosition = originalPosition;
    }

    @Override
    public int compareTo(SortedWord o) {
        if (_word.equals(o.getWord())) {
            return Integer.compare(_originalPosition, o.getOriginalPosition());
        }
        return 1 * _word.compareTo(o.getWord());
    }

    public String getWord() {
        return _word;
    }

    public void setWord(String _word) {
        this._word = _word;
    }

    public int getOriginalPosition() {
        return _originalPosition;
    }

    public void setOriginalPosition(int _originalPosition) {
        this._originalPosition = _originalPosition;
    }

    @Override
    public String toString() {
        return "{" + getWord() + ":" + getOriginalPosition() + "}";
    }

}

enum SORT_METHOD {
    QUICK_SORT, MERGE_SORT, DUMB_SORT,
}

public class AnalyzeWords2 {

    private DownloadPage _page;
    private String[] _words;
    private SortedWord[] _wordsSorted = new SortedWord[0];
    private int _totalCount = 0;
    private SORT_METHOD _sortMethodToUse;

    public int getTotalCount() {
        return _totalCount;
    }

    public AnalyzeWords2(DownloadPage page, SORT_METHOD sortMethodToUse) throws InvalidAlgorithmParameterException {
        _page = page;
        _sortMethodToUse = sortMethodToUse;
        _words = page.getWords();
        _wordsSorted = AnalyzeWords2.sort(_wordsSorted, _sortMethodToUse, SortedWord.class);
    }

    public AnalyzeWords2(String pageLink, SORT_METHOD sortMethodToUse)
            throws IOException, InvalidAlgorithmParameterException {
        _page = new DownloadPage(pageLink);
        _sortMethodToUse = sortMethodToUse;
        _words = _page.getWords();
        for (var i = 0; i < _words.length; i++) {
            _wordsSorted = Utils.concat(_wordsSorted, new SortedWord(_words[i], i), SortedWord.class);
        }
        System.out.println("IN:");
        Utils.debugArray(_wordsSorted);

        _wordsSorted = AnalyzeWords2.sort(_wordsSorted, _sortMethodToUse, SortedWord.class);
        System.out.println("Out:");
        Utils.debugArray(_wordsSorted);
    }

    /**
     * liefert die Anzahl von Vorkommen des Wortes word.
     *
     * @param word - das gesuchte wort
     * @return - anahl der vorkommnisse
     */
    public int frequency(String word) {
        _totalCount = 0;
        return _frequency(word);
    }

    private int _frequency(String word) {
        var ret = 0;
        for (int i = 0; i < _wordsSorted.length; i++) {
            _totalCount++;
            if (_wordsSorted[i].getWord().equals(word)) {
                for (int j = i; j < _wordsSorted.length; j++) {
                    _totalCount++;
                    if (_wordsSorted[j].getWord().equals(word)) {
                        ret++;
                    } else {
                        _totalCount -= 1; // substract 1 for double ++ of first iteration in 108
                        return ret; // early return
                    }
                }
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
        _totalCount = 0;
        return _mostFrequent();
    }

    private String _mostFrequent() {
        _totalCount++;
        return _wordsSorted[_wordsSorted.length - 1].getWord();

    }

    /**
     * liefert ein Array, das alle Wörter enthält, die nur genau einmal vorkommen.
     *
     * @return
     */
    public String[] unique() {
        _totalCount = 0;
        return _unique();
    }

    private String[] _unique() {
        var res = new String[0];
        for (var curr : _words) {
            _totalCount++;
            if (_frequency(curr) == 1) {
                res = Utils.concat(res, curr, String.class);
            }
        }
        return res;
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
        _totalCount = 0;
        return _distance(string1, string2);
    }

    private int _distance(String string1, String string2) {
        var sortedWordsMatchingS1 = allSortedWordsMatching(string1);
        var sortedWordsMatchingS2 = allSortedWordsMatching(string2);
        if (sortedWordsMatchingS1.length == 0 || sortedWordsMatchingS2.length == 0)
            return Integer.MAX_VALUE;
        if (string1.equals(string2) && sortedWordsMatchingS1.length == 1) { // occures only once
            return Integer.MAX_VALUE;
        }

        var currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < sortedWordsMatchingS2.length; i++) {
            _totalCount++;
            for (int j = 0; j < sortedWordsMatchingS1.length; j++) {
                _totalCount++;
                var tmp = sortedWordsMatchingS2[i].getOriginalPosition()
                        - sortedWordsMatchingS1[j].getOriginalPosition();
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
        _totalCount = 0;
        return _wordsNear(string, dist);
    }

    private String[] _wordsNear(String string, int dist) {
        var result = new String[0];
        for (var sortedWord : allSortedWordsMatching(string)) {
            _totalCount++;
            for (int i = 1; i <= dist; i++) {
                if (sortedWord.getOriginalPosition() - i >= 0) {
                    result = Utils.concat(result, _words[sortedWord.getOriginalPosition() - 1], String.class);
                }
                if (sortedWord.getOriginalPosition() + i < _words.length) {
                    result = Utils.concat(result, _words[sortedWord.getOriginalPosition() + 1], String.class);
                }
            }
        }
        return result;
    }

    private static <T extends Comparable<T>> T[] sort(T[] array, SORT_METHOD method, Class<T> type)
            throws InvalidAlgorithmParameterException {
        switch (method) {
        case DUMB_SORT:
            return dumbSort(array, type);
        case MERGE_SORT:
            return mergeSort(array, type);
        case QUICK_SORT:
            return quickSort(array, type);
        default:
            throw new InvalidAlgorithmParameterException();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] dumbSort(T[] array, Class<T> type) {
        return (T[]) Array.newInstance(type, array.length);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] quickSort(T[] array, Class<T> type) {
        return (T[]) Array.newInstance(type, array.length);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] mergeSort(T[] array, Class<T> type) {
        if (array.length <= 1)
            return array;

        var left = (T[]) Array.newInstance(type, (int) Math.floor(array.length / 2));
        var right = (T[]) Array.newInstance(type, array.length - left.length);
        for (int i = 0; i < array.length; i++) {
            if (i < left.length) {
                left[i] = array[i];
            } else {
                right[i - left.length] = array[i];
            }
        }

        left = mergeSort(left, type);
        right = mergeSort(right, type);

        return merge(left, right, type);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] merge(T[] left, T[] right, Class<T> type) {

        var result = (T[]) Array.newInstance(type, left.length + right.length);

        int cnt = 0;

        while (left.length > 0 && right.length > 0) {
            if (left[0].compareTo(right[0]) <= 0) {
                result[cnt++] = left[0];
                left = Utils.rest(left, type);
            } else {
                result[cnt++] = right[0];
                right = Utils.rest(right, type);
            }
        }

        if (left.length > 0) {
            System.arraycopy(left, 0, result, cnt, left.length);
        }
        if (right.length > 0) {
            System.arraycopy(right, 0, result, cnt, right.length);
        }
        return result;
    }

    private SortedWord[] allSortedWordsMatching(String word) {
        var result = new SortedWord[0];
        for (int i = 0; i < _wordsSorted.length; i++) {
            _totalCount++;
            if (_wordsSorted[i].getWord().equals(word)) {
                result = Utils.concat(result, _wordsSorted[i], SortedWord.class);
                if (i < _wordsSorted.length - 1 && !_wordsSorted[i + 1].getWord().equals(word)) {
                    return result; // Look ahead possible due to sortedness
                }
            }
        }
        return result;
    }
}
