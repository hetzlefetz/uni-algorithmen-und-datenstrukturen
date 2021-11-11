package de.vfh.algodat;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InvalidAlgorithmParameterException {
        try {

            AnalyzeWords1 aw1 = new AnalyzeWords1("file:esa1/TestMaterial/wikiGoethe.html");
            AnalyzeWords2 aW11 = new AnalyzeWords2("file:esa1/TestMaterial/wikiGoethe.html", SORT_METHOD.MERGE_SORT);

            System.out.println("Frequency von Goethe aus AnalyzeWords1: " + aw1.frequency("Goethe"));
            System.out.println("Frequency von Goethe aus AnalyzeWords2: " + aW11.frequency("Goethe"));

            System.out.println("Durchläufe AnalyzeWords1: " + aw1.getTotalCount());
            System.out.println("Durchläufe AnalyzeWords2: " + aW11.getTotalCount());

            System.out.println("Frequency von Wolfgang aus AnalyzeWords1: " + aw1.frequency("Wolfgang"));
            System.out.println("Frequency von Wolfgang aus AnalyzeWords2: " + aW11.frequency("Wolfgang"));

            System.out.println("Durchläufe AnalyzeWords1: " + aw1.getTotalCount());
            System.out.println("Durchläufe AnalyzeWords2: " + aW11.getTotalCount());

            System.out.println("mostFrequent von abc aus AnalyzeWords1: " + aw1.mostFrequent());
            System.out.println("mostFrequent von abc aus AnalyzeWords2: " + aW11.mostFrequent());

            System.out.println("Durchläufe AnalyzeWords1: " + aw1.getTotalCount());
            System.out.println("Durchläufe AnalyzeWords2: " + aW11.getTotalCount());

            AnalyzeWords1 aw2 = new AnalyzeWords1("file:esa1/TestMaterial/blatest.txt");
            AnalyzeWords2 aw22 = new AnalyzeWords2("file:esa1/TestMaterial/blatest.txt", SORT_METHOD.BUBBLE_SORT);

            System.out.println("Frequency von abc aus AnalyzeWords1: " + aw2.frequency("abc"));
            System.out.println("Frequency von abc aus AnalyzeWords2: " + aw22.frequency("abc"));

            System.out.println("Durchläufe AnalyzeWords1: " + aw2.getTotalCount());
            System.out.println("Durchläufe AnalyzeWords2: " + aw22.getTotalCount());

            System.out.println("Frequency von ab aus AnalyzeWords1: " + aw2.frequency("ab"));
            System.out.println("Frequency von ab aus AnalyzeWords2: " + aw22.frequency("ab"));

            System.out.println("Durchläufe AnalyzeWords1: " + aw2.getTotalCount());
            System.out.println("Durchläufe AnalyzeWords2: " + aw22.getTotalCount());

            System.out.println("mostFrequent von abc aus AnalyzeWords1: " + aw2.mostFrequent());
            System.out.println("mostFrequent von abc aus AnalyzeWords2: " + aw22.mostFrequent());

            System.out.println("Durchläufe AnalyzeWords1: " + aw2.getTotalCount());
            System.out.println("Durchläufe AnalyzeWords2: " + aw22.getTotalCount());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
