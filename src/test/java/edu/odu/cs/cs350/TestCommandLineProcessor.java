package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;

public class TestCommandLineProcessor {

    @Test
    void testConstructor(){
        SourceCodeFile file1 = new SourceCodeFile("foo.cpp");
        SourceCodeFile file2 = new SourceCodeFile("foo.h");
        SourceCodeFile file3 = new SourceCodeFile("bar.cpp");
        SourceCodeFile file4 = new SourceCodeFile("main.cpp");


        /* to be implemented
            TestCommandLineProcessor.main(new String[]{4, file1, file2, file3, file4});
        */
    }
  void testFileExists()
  {
	  //Edit to your Directory//
	  File testFolder = new File("C:\Users\sTRICTLY VS\Documents\Testfolder");
	  File testFile = new File("C:\\Users\\sTRICTLY VS\\Documents\\Testfolder\testfile.txt");
	  //---------------------------------------------------------------------------------------//
	  boolean Exists = testFile.exists();
	  assertThat(testFile.exists(),is(true));
	  assertThat(testfile.isDirectory(),is(true));
	  assertThat(testFile.isFile(),is(false))
	  assertThat(testFolder.exists(),is(true));
	  assertThat(testFolder.isDirectory(),is(true));
	  assertThat(testFolder.isFile(),is(false));
	 	  
  }
    
}
