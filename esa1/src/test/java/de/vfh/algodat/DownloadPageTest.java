package de.vfh.algodat;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import org.junit.Test;

public class DownloadPageTest {

    @Test
    public void testToString() throws IOException {
        System.out.println(Path.of("").toAbsolutePath().toString());
        DownloadPage dp = new DownloadPage("file:TestMaterial/blatest.txt");
        assertEquals("toString:", "\"file:TestMaterial/blatest.txt\", 52, 0, 10", dp.toString());
    }

    @Test
    public void testDownloadPage() throws IOException {
        DownloadPage dp = new DownloadPage("file:TestMaterial/blatest.txt");
        assertEquals("abc ab abcd abc bla blabla blablabla bla. bla, bla! ", dp.getContent());
        assertTrue(dp.getTime() >= 0L);
        assertTrue(dp.getTime() < 200L);
        String[] words = { "abc", "ab", "abcd", "abc", "bla", "blabla", "blablabla", "bla", "bla", "bla" };
        assertTrue("Words same?", Arrays.equals(words, dp.getWords()));
        assertTrue("no urls!", Arrays.equals(new String[0], dp.getLinks()));
    }

    @Test(expected = IOException.class)
    public void testDownloadPageException() throws IOException {
        new DownloadPage("file:TestMaterial/notexistant.txt");
    }

    @Test
    public void testDownloadPageHttps() throws IOException {
        DownloadPage dp = new DownloadPage("https://www.ostfalia.de/cms/de/i/index.html");
        assertTrue(dp.getLinks().length > 0);
    }

    @Test(expected = IOException.class)
    public void testDownloadPageHttpsNonExist() throws IOException {
        DownloadPage dp = new DownloadPage("https://www.ostfalia.de/cms/de/i/blabla");
        assertNotNull(dp);
    }

    @Test
    public void testGetUrl() throws IOException {
        DownloadPage dp = new DownloadPage("file:TestMaterial/blatest.txt");
        assertEquals("file:TestMaterial/blatest.txt", dp.getUrl());
    }

    @Test
    public void testCount() throws IOException {
        StringBuffer sb = new StringBuffer("abcdefabc");
        assertEquals(2, DownloadPage.count(sb.toString(), "ab"));
    }

    // @Test
    // public void testLoadStart() throws IOException {
    // DownloadPage.loadStart();
    // }
    //
    // @Test
    // public void testMain() throws IOException {
    // DownloadPage.main(new String[0]);
    // }

    @Test
    public void testGetUrls() throws IOException {
        DownloadPage dp = new DownloadPage("file:TestMaterial/testFile.html");
        assertTrue(Arrays.deepEquals(
                new String[] { "https://www.ostfalia.de/cms/de/i/index.html",
                        "https://www.ostfalia.de/cms/de/i/blabla.html", "https://www.ostfalia.de/cms/de/i/zzzz.html" },
                dp.getLinks()));
    }

    @Test
    public void testCalculatePrefix1() {
        String url = "http://example.com/dir/file.html";
        assertEquals("http://example.com", DownloadPage.calculatePrefix(url));
    }

    @Test
    public void testCalculatePrefix2() {
        String url = "https://example.com/dir/file.html";
        assertEquals("https://example.com", DownloadPage.calculatePrefix(url));
    }

    @Test
    public void testCalculatePrefix3() {
        String url = "file:TestMaterial/file.html";
        assertEquals("file:", DownloadPage.calculatePrefix(url));
    }

}
