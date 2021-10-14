// package de.vfh.algodat.test;

// import static org.junit.Assert.*;

// import java.io.IOException;
// import java.util.Arrays;
// import java.util.List;
// import java.util.concurrent.TimeUnit;

// import org.junit.Rule;
// import org.junit.Test;
// import org.junit.rules.DisableOnDebug;
// import org.junit.rules.TestRule;
// import org.junit.rules.Timeout;

// import de.vfh.algodat.AnalyzeWords4;

// public class AnalyzeWords4GoetheTest {

// @Rule
// public TestRule timeout = new DisableOnDebug(new Timeout(500,
// TimeUnit.MILLISECONDS));

// @Test
// public void testFrequencyGoethe() throws IOException {
// AnalyzeWords4 aw = new AnalyzeWords4("file:wikiGoethe.html");
// assertEquals("Halbgötter kommt einmal vor", 1, aw.frequency("Halbgötter"));
// }
// @Test
// public void testDistanceGoethe() throws IOException {
// AnalyzeWords4 aw = new AnalyzeWords4("file:wikiGoethe.html");
// assertEquals("Abstand \"Halbgötter\", \"Götter\"", -2,
// aw.distance("Halbgötter", "Götter"));
// }
// @Test
// public void testMostFrequentGoethe() throws IOException {
// AnalyzeWords4 aw = new AnalyzeWords4("file:wikiGoethe.html");
// assertEquals(" \"und\" ist am häufigsten", "und", aw.mostFrequent());
// }
// @Test
// public void testUniqueGoethe() throws IOException {
// AnalyzeWords4 aw = new AnalyzeWords4("file:wikiGoethe.html");
// List<String> uniqueWords = aw.unique();
// assertNotNull(uniqueWords);
// assertEquals("many unique words!", 4777, uniqueWords.size());
// assertTrue("\"Abend\": pos ", uniqueWords.contains("Abend"));
// }
// @Test
// public void testWordNearGoethe() throws IOException {
// AnalyzeWords4 aw = new AnalyzeWords4("file:wikiGoethe.html");
// List<String> wordsNear = aw.wordsNear("Goethe", 2);
// assertNotNull(wordsNear);
// assertEquals("many words near Goethe!", 2988, wordsNear.size());
// String[] sorted = wordsNear.toArray(new String[wordsNear.size()]);
// Arrays.sort(sorted);
// assertEquals("\"Album\": pos ", "Album", sorted[8]);
// }
// }
