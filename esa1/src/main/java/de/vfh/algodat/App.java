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
            System.out.println(aw.frequency("Goethe"));
            System.out.println(aw.frequency("Wolfgang"));

            AnalyzeWords1 aw2 = new AnalyzeWords1("file:esa1/TestMaterial/blatest.txt");
            System.out.println(aw2.frequency("abc"));
            System.out.println(aw2.frequency("ab"));
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
