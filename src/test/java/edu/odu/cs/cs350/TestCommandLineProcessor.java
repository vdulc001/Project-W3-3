package edu.odu.cs.cs350;

import static edu.odu.cs.cs350.CommandLineProcessor.findFilesInNestedDirectories;
import static edu.odu.cs.cs350.CommandLineProcessor.printListOfSourceCodeFiles;
import static edu.odu.cs.cs350.CommandLineProcessor.readInSourceCodeFiles;
import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Seth's
 * 
 */
public class TestCommandLineProcessor {
	
    public TestCommandLineProcessor() {    
		findFilesInNestedDirectories();
		printListOfSourceCodeFiles();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setnSuggestions method, of class CommandLineProcessor.
     */
    @Test
    public void testSetnSuggestions() {
        System.out.println("setnSuggestions");
        int num = 0;
        CommandLineProcessor instance = null;
        instance.setnSuggestions(num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getnSuggestions method, of class CommandLineProcessor.
     */
    @Test
    public void testGetnSuggestions() {
        System.out.println("getnSuggestions");
        CommandLineProcessor instance = null;
        int expResult = 0;
        int result = instance.getnSuggestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileList method, of class CommandLineProcessor.
     */
    @Test
    public void testGetFileList() {
        System.out.println("getFileList");
        CommandLineProcessor instance = null;
        ArrayList<SourceCodeFile> expResult = null;
        ArrayList<SourceCodeFile> result = instance.getFileList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCppFiles method, of class CommandLineProcessor.
     */
    @Test
    public void testFindCppFiles() {
        System.out.println("findCppFiles");
        CommandLineProcessor instance = null;
        instance.findCppFiles();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CommandLineProcessor.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CommandLineProcessor.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readInSourceCodeFiles method, of class CommandLineProcessor.
     */
    @Test
    public void testReadInSourceCodeFiles() {
        System.out.println("readInSourceCodeFiles");
        String[] args = null;
        CommandLineProcessor.readInSourceCodeFiles(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFilesInNestedDirectories method, of class CommandLineProcessor.
     */
    @Test
    public void testFindFilesInNestedDirectories() {
        System.out.println("findFilesInNestedDirectories");
        CommandLineProcessor.findFilesInNestedDirectories();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchForDirectories method, of class CommandLineProcessor.
     */
    @Test
    public void testSearchForDirectories() {
        System.out.println("searchForDirectories");
        File[] files = null;
        int index = 0;
        ArrayList<String> pathsToDirectories = null;
        CommandLineProcessor.searchForDirectories(files, index, pathsToDirectories);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printListOfSourceCodeFiles method, of class CommandLineProcessor.
     */
    @Test
    public void testPrintListOfSourceCodeFiles() {
        System.out.println("printListOfSourceCodeFiles");
        CommandLineProcessor.printListOfSourceCodeFiles();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
