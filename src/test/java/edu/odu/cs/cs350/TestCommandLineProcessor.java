package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sheldon
 * 
 */
public class TestCommandLineProcessor {

        CommandLineProcessor clp = new CommandLineProcessor();

        @Test
        public void testSetSuggestions() {
            assertEquals(0, clp.getnSuggestions());
            clp.setnSuggestions(8);
            assertEquals(8, clp.getnSuggestions());
        }
        @SuppressWarnings("static-access")
        @Test
        public void readSourceCodeFiles() {
        	String args[] = {"2", "src/test/data/test1.cpp", "src/test/data/test2.cpp"};
            clp.readInSourceCodeFiles(args);
            assertEquals(2, clp.getFileList().size());
        }

        @SuppressWarnings("static-access")
        @Test
        public void findFilesInNestedDirectories() {
        	String args[] = {"2", "src/test/data/testDir"};
        	clp.readInSourceCodeFiles(args);
            clp.findFilesInNestedDirectories();
            assertEquals(2, clp.getFileList().size());
        }
    }