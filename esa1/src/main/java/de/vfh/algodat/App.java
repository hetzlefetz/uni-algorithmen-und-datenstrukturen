package de.vfh.algodat;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            System.out.println(Path.of("").toAbsolutePath().toString());
            AnalyzeWords1 aw = new AnalyzeWords1("file:esa1/TestMaterial/wikiGoethe.html");
            System.out.println("Frequency von Goethe: " + aw.frequency("Goethe"));
            System.out.println("Durchläufe: " + aw.getTotalCount());
            System.out.println("Frequency von  Wofgang: " + aw.frequency("Wolfgang"));
            System.out.println("Durchläufe: " + aw.getTotalCount());
            System.out.println("Mostfrequent: " + aw.mostFrequent());
            System.out.println("Durchläufe: " + aw.getTotalCount());

            AnalyzeWords1 aw2 = new AnalyzeWords1("file:esa1/TestMaterial/blatest.txt");

            System.out.println("Frequency von abc: " + aw2.frequency("abc"));
            System.out.println("Durchläufe: " + aw2.getTotalCount());
            System.out.println("Frequency von  ab: " + aw2.frequency("ab"));
            System.out.println("Durchläufe: " + aw2.getTotalCount());
            System.out.println("Mostfrequent: " + aw2.mostFrequent());
            System.out.println("Durchläufe: " + aw2.getTotalCount());
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
