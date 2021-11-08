package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;


public class TestCommandLineProcessor {

    @Test
    void testConstructor(){
        SourceCodeFile file1 = new SourceCodeFile("foo.cpp");
        SourceCodeFile file2 = new SourceCodeFile("foo.h");
        SourceCodeFile file3 = new SourceCodeFile("bar.cpp");
        SourceCodeFile file4 = new SourceCodeFile("main.cpp");
    }

	@Test
	void testNumRefactors(){
		SourceCodeFile file1 = new SourceCodeFile("foo.cpp");
		ArrayList<SourceCodeFile> testList = new ArrayList<SourceCodeFile>();
		testList.add(file1);

        /* to be implemented
            TestCommandLineProcessor.main(new String[]{4, file1, file2, file3, file4});
        */
    }

	@Test
	void testNumRefactors(){
		SourceCodeFile file1 = new SourceCodeFile("foo.cpp");
		ArrayList<SourceCodeFile> testList = new ArrayList<SourceCodeFile>();
		testList.add(file1);

		CommandLineProcessor clp = new CommandLineProcessor(3, testList);

		assertEquals(clp.getNumRefactors(), 3);

		clp.setNumRefactors(6);
		assertEquals(clp.getNumRefactors(), 6);
	}

	@Test
  void testFileExists()
  {   //Test Set-up//
	  ArrayList<SourceCodeFile> testfileList = new ArrayList<SourceCodeFile>();
	  
	  //Edit to your Directory//
	  File testFolder = new File("C:\Users\sTRICTLY VS\Documents\Testfolder");
	  File testFile = new File("C:\\Users\\sTRICTLY VS\\Documents\\Testfolder\testfile.txt");
	  //---------------------------------------------------------------------------------------//
	  //Testing Adding and Cloning
	 testfileList.add(testFile);
	 testfileList.add(testFolder);
	 ArrayList<SourceCodeFile> TestTempArray = new ArrayList<SourceCodeFile>();
	 TestTempArray = (ArrayList)testfileList.clone();
	 //-----------------------------------------------------------------------------------------//
	  
	 boolean ArrayEqual = TestFile.equals(testFolder);
	 assertThat(ArrayEqual,is(true));
	 
	 //Test Function//
	 boolean Exists = testFile.exists();
	  assertThat(testFile.exists(),is(true));
	  assertThat(testfile.isDirectory(),is(true));
	  assertThat(testFile.isFile(),is(false))
	  assertThat(testFolder.exists(),is(true));
	  assertThat(testFolder.isDirectory(),is(true));
	  assertThat(testFolder.isFile(),is(false));
	   
	 	  
  }
    
}
