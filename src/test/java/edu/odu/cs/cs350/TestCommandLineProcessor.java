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

        CommandLineProcessor clp = new CommandLineProcessor(0, null);

        @Test
        public void testSetSuggestions() {
            assertEquals(0, clp.getnSuggestions());
            clp.setnSuggestions(8);
            assertEquals(8, clp.getnSuggestions());
        }
        
        @SuppressWarnings("static-access")
        @Test
        public void readSourceCodeFiles() {
            String args[] = {"src/test/data/test1.cpp", "src/test/data/test1.cpp"};
            clp.readInSourceCodeFiles(args);
            
            assertEquals(2, clp.getFileList().size());
        }
        
        @SuppressWarnings("static-access")
        @Test
        public void findFilesInNestedDirectories() {
            clp.findFilesInNestedDirectories();
            assertEquals(2, clp.getFileList());
        }
    }