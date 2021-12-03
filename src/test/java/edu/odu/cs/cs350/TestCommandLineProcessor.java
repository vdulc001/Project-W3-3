package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sheldon
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