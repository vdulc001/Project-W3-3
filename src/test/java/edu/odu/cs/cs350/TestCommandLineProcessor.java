package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

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

		CommandLineProcessor clp = new CommandLineProcessor(3, testList);

		assertEquals(clp.getNumRefactors(), 3);

		clp.setNumRefactors(6);
		assertEquals(clp.getNumRefactors(), 6);
	}
    
    
}
