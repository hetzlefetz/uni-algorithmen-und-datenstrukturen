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

// import de.vfh.algodat.AnalyzeWords5;

// public class AnalyzeWords5Test {

// @Rule
// public TestRule timeout = new DisableOnDebug(new Timeout(500,
// TimeUnit.MILLISECONDS));

// @Test
// public void testFrequency() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Wort \"abc\" kommt zweimal vor", 2, aw.frequency("abc"));
// }

// @Test
// public void testFrequency2() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Wort \"bla\" kommt viermal vor, mit Satzzeichen", 4,
// aw.frequency("bla"));
// }

// @Test
// public void testFrequency3() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Wort kommt nicht vor", 0, aw.frequency("qwer"));
// }

// @Test
// public void testFrequency4() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Wort ab kommt einmal vor", 1, aw.frequency("ab"));
// }

// @Test
// public void testFrequency5() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Wort \"blablabla\" kommt einmal vor", 1,
// aw.frequency("blablabla"));
// }

// @Test
// public void testDistance1() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Abstand 1", 1, aw.distance("abc", "ab"));
// }

// @Test
// public void testDistance2() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Abstand -1", -1, aw.distance("ab", "abc"));
// }

// @Test
// public void testDistance3() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Abstand 1", 1, aw.distance("bla", "bla"));
// }

// @Test
// public void testDistance4() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("blub existiert nicht", Integer.MAX_VALUE, aw.distance("bla",
// "blub"));
// }

// @Test
// public void testDistance5() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("blabla existiert nur einmal", Integer.MAX_VALUE,
// aw.distance("blabla", "blabla"));
// }

// @Test
// public void testDistance6() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Abstand Infinity", Integer.MAX_VALUE, aw.distance("qwer",
// "ab"));
// }

// @Test
// public void testDistance7() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("Abstand Infinity", Integer.MAX_VALUE, aw.distance("abc",
// "qwer"));
// }

// @Test
// public void testDistance8() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("blablabla existiert nur einmal, blabla davor!", -1,
// aw.distance("blablabla", "blabla"));
// }

// @Test
// public void testMostFrequent() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// assertEquals("bla ist am häufigsten", "bla", aw.mostFrequent());
// }

// @Test
// public void testMostFrequent2() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest2.txt");
// String mf = aw.mostFrequent();
// assertTrue("bla or xx ist in blatest2.txt am häufigsten", mf.equals("bla") ||
// mf.equals("xx"));
// }

// @Test
// public void testUnique() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// List<String> uniqueWords = aw.unique();
// assertNotNull(uniqueWords);
// assertEquals("four unique words!", 4, uniqueWords.size());
// String[] sorted = uniqueWords.toArray(new String[uniqueWords.size()]);
// Arrays.sort(sorted);
// assertEquals("first: ab", "ab", sorted[0]);
// assertEquals("second: abcd", "abcd", sorted[1]);
// assertEquals("third: blabla", "blabla", sorted[2]);
// }

// @Test
// public void testWordsNear() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// List<String> wordsNear = aw.wordsNear("abc", 1);
// assertNotNull(wordsNear);
// assertEquals("three words near abc!", 3, wordsNear.size());
// String[] sorted = wordsNear.toArray(new String[wordsNear.size()]);
// Arrays.sort(sorted);
// assertEquals("first: ab", "ab", sorted[0]);
// assertEquals("second: abcd", "abcd", sorted[1]);
// assertEquals("third: bla", "bla", sorted[2]);

// }

// @Test
// public void testWordsNearNonexistent() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// List<String> wordsNear = aw.wordsNear("qwer", 1);
// assertNotNull(wordsNear);
// assertEquals("No words near qwer!", 0, wordsNear.size());
// }

// @Test
// public void testWordsNear2() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// List<String> wordsNear = aw.wordsNear("blabla", 1);
// assertNotNull(wordsNear);
// assertEquals("two words near blabla!", 2, wordsNear.size());
// String[] sorted = wordsNear.toArray(new String[wordsNear.size()]);
// Arrays.sort(sorted);
// assertEquals("first: bla", "bla", sorted[0]);
// assertEquals("second: blablabla", "blablabla", sorted[1]);
// }

// @Test
// public void testWordsNear3() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// List<String> wordsNear = aw.wordsNear("blablabla", 1);
// assertNotNull(wordsNear);
// assertEquals("One word near blablabla!", 2, wordsNear.size());
// String[] sorted = wordsNear.toArray(new String[wordsNear.size()]);
// Arrays.sort(sorted);
// assertEquals("first: bla", "bla", sorted[0]);
// assertEquals("second: blabla", "blabla", sorted[1]);
// }

// @Test
// public void testWordsNear4() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blatest.txt");
// List<String> wordsNear = aw.wordsNear("bla", 1);
// assertNotNull(wordsNear);
// assertEquals("words near bla!", 7, wordsNear.size());
// String[] sorted = wordsNear.toArray(new String[wordsNear.size()]);
// Arrays.sort(sorted);
// assertEquals("first: ", "abc", sorted[0]);
// assertEquals("fourth: ", "bla", sorted[1]);
// assertEquals("fifth: ", "bla", sorted[2]);
// assertEquals("sixth: ", "bla", sorted[3]);
// assertEquals("seventh: ", "bla", sorted[4]);
// assertEquals("second: ", "blabla", sorted[5]);
// assertEquals("third: ", "blablabla", sorted[6]);
// }

// private int count = 0;

// @Test
// public void testTraverse() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blaTree.txt");
// count = 0;
// aw.traverse((String s) -> count++);
// assertEquals(" traverse should find 5 nodes", count, 5);
// }

// @Test
// public void testToString() throws IOException {
// AnalyzeWords5 aw = new AnalyzeWords5("file:blaTree.txt");
// String res = aw.toString();
// assertTrue("toString should contain bbb", res.contains("bbb"));
// }
// }
