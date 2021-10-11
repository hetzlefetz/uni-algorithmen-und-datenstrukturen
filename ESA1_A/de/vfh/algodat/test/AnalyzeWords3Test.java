package de.vfh.algodat.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import de.vfh.algodat.AnalyzeWords3;

public class AnalyzeWords3Test {

    @Rule
    public TestRule timeout = new DisableOnDebug(new Timeout(500, TimeUnit.MILLISECONDS));

    @Test
    public void testFrequency() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Wort \"abc\" kommt zweimal vor", 2, aw.frequency("abc"));
    }

    @Test
    public void testFrequency2() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Wort \"bla\" kommt viermal vor, mit Satzzeichen", 4, aw.frequency("bla"));
    }

    @Test
    public void testFrequency3() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Wort kommt nicht vor", 0, aw.frequency("qwer"));
    }

    @Test
    public void testFrequency4() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Wort ab kommt einmal vor", 1, aw.frequency("ab"));
    }

    @Test
    public void testFrequency5() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Wort \"blablabla\" kommt einmal vor", 1, aw.frequency("blablabla"));
    }
    @Test
    public void testDistance1() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Abstand 1", 1, aw.distance("abc", "ab"));
    }

    @Test
    public void testDistance2() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Abstand -1", -1, aw.distance("ab", "abc"));
    }

    @Test
    public void testDistance3() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Abstand 1", 1, aw.distance("bla", "bla"));
    }

    @Test
    public void testDistance4() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("blub existiert nicht", Integer.MAX_VALUE, aw.distance("bla", "blub"));
    }

    @Test
    public void testDistance5() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("blabla existiert nur einmal", Integer.MAX_VALUE, aw.distance("blabla", "blabla"));
    }

    @Test
    public void testDistance6() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Abstand Infinity", Integer.MAX_VALUE, aw.distance("qwer", "ab"));
    }

    @Test
    public void testDistance7() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("Abstand Infinity", Integer.MAX_VALUE, aw.distance("abc", "qwer"));
    }

    @Test
    public void testDistance8() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("blablabla existiert nur einmal, blabla davor!", -1, aw.distance("blablabla", "blabla"));
    }

    @Test
    public void testMostFrequent() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	assertEquals("bla ist am häufigsten", "bla", aw.mostFrequent());
    }
    @Test
    public void testMostFrequent2() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest2.txt");
	assertEquals("bla ist am häufigsten", "bla", aw.mostFrequent());
    }

    @Test
    public void testUnique() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	String[] uniqueWords = aw.unique();
	assertNotNull(uniqueWords);
	assertEquals("four unique words!", 4, uniqueWords.length);
	Arrays.sort(uniqueWords);
	assertEquals("first: ab", "ab", uniqueWords[0]);
	assertEquals("second: abcd", "abcd", uniqueWords[1]);
	assertEquals("third: blabla", "blabla", uniqueWords[2]);	
    }

    @Test
    public void testWordsNear() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	String[] wordsNear = aw.wordsNear("abc", 1);
	assertNotNull(wordsNear);
	assertEquals("three words near abc!", 3, wordsNear.length);
	Arrays.sort(wordsNear);
	assertEquals("first: ab", "ab", wordsNear[0]);
	assertEquals("second: abcd", "abcd", wordsNear[1]);
	assertEquals("third: bla", "bla", wordsNear[2]);
	
    }

    @Test
    public void testWordsNearNonexistent() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	String[] wordsNear = aw.wordsNear("qwer", 1);
	assertNotNull(wordsNear);
	assertEquals("No words near qwer!", 0, wordsNear.length);
    }
    @Test
    public void testWordsNear2() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	String[] wordsNear = aw.wordsNear("blabla", 1);
	assertNotNull(wordsNear);
	assertEquals("two words near blabla!", 2, wordsNear.length);
	Arrays.sort(wordsNear);
	assertEquals("first: bla", "bla", wordsNear[0]);
	assertEquals("second: blablabla", "blablabla", wordsNear[1]);
    }
    @Test
    public void testWordsNear3() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	String[] wordsNear = aw.wordsNear("blablabla", 1);
	assertNotNull(wordsNear);
	assertEquals("One word near blablabla!", 2, wordsNear.length);
	Arrays.sort(wordsNear);
	assertEquals("first: bla", "bla", wordsNear[0]);
	assertEquals("second: blabla", "blabla", wordsNear[1]);
    }
    @Test
    public void testWordsNear4() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blatest.txt");
	String[] wordsNear = aw.wordsNear("bla", 1);
	assertNotNull(wordsNear);
	assertEquals("words near bla!", 7, wordsNear.length);
	Arrays.sort(wordsNear);
	assertEquals("first: ", "abc", wordsNear[0]);
	assertEquals("fourth: ", "bla", wordsNear[1]);
	assertEquals("fifth: ", "bla", wordsNear[2]);
	assertEquals("sixth: ", "bla", wordsNear[3]);
	assertEquals("seventh: ", "bla", wordsNear[4]);
	assertEquals("second: ", "blabla", wordsNear[5]);
	assertEquals("third: ", "blablabla", wordsNear[6]);
    }
    
    @Test
    public void testLeftChildNull() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blaTree.txt");
	String child = aw.leftChild("zzz");
	assertNull(" text \"zzz\" does not occur, should be null", child);
    }

    @Test
    public void testLeftChildEmptyTree() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:empty.txt");
	String child = aw.leftChild("zzz");
	assertNull(" Empty tree, should return null", child);
    }

    @Test
    public void testLeftChild() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blaTree.txt");
	String child = aw.leftChild("bbb");
	assertEquals("aaa", child);
    }


    @Test
    public void testRightChild() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blaTree.txt");
	String child = aw.rightChild("bbb");
	assertEquals("ccc", child);
    }

    @Test
    public void testRightChildNull() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blaTree.txt");
	String child = aw.rightChild("zzz");
	assertNull(" text \"zzz\" does not occur, should be null", child);
    }

    @Test
    public void testRightChildEmptyTree() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:empty.txt");
	String child = aw.rightChild("zzz");
	assertNull(" Empty tree, should return null", child);
    }

    @Test
    public void testChildren2() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blaTree.txt");
	assertEquals(2, aw.frequency("bbb"));
	String lchild = aw.leftChild("bbb");
	assertEquals("aaa", lchild);
	String rchild = aw.rightChild("bbb");
	assertEquals("ccc", rchild);
    }
    
    private int count = 0;
    @Test
    public void testTraverse() throws IOException {
	AnalyzeWords3 aw = new AnalyzeWords3("file:blaTree.txt");
	count = 0;
	aw.traverse((String s)-> count++);
	assertEquals(" traverse should find 5 nodes", count, 5);
    }
   
}
