package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

class TestRecursionSearch {

    @Test
    void testRecursionSearch() {

        //Current test of directory / file creation, more to be added.

        createDirectory1 d = new File("/home/cs_sdean008/projectDir/Temp").mkdirs();
        createFile1 f = new File("/home/cs_sdean008/projectDir/Temp/tempFile.txt");
        createDirectory2 x = new File("/home/cs_sdean008/projectDir/Temp/Temp2").mkdirs();
        createFile2 y = new File("/home/cs_sdean008/projectDir/Temp/Temp2/tempFile2.txt");


        assertTrue(d.exists("/home/cs_sdean008/projectDir/Temp"));
        assertTrue(f.exists("/home/cs_sdean008/projectDir/Temp/tempFile.txt"));
        assertTrue(x.exists("/home/cs_sdean008/projectDir/Temp/Temp2"));
        assertTrue(y.exists("/home/cs_sdean008/projectDir/Temp/Temp2/tempFile2.txt"));

        assertEquals(f.getPath(), "/home/cs_sdean008/projectDir/Temp/tempFile.txt");
        assertEquals(f.getPath(), "/home/cs_sdean008/projectDir/Temp/Temp2/tempFile2.txt");

    }

}