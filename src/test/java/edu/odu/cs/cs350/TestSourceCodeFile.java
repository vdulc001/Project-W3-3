package edu.odu.cs.cs350;

import java.io.Reader;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestSourceCodeFile {

	@Test
	void testSourceCodeFile() throws Exception{
		//SourceCodeFile s = new SourceCodeFile("/home/cs_vdulc001/cppTest.cpp");
		//assertTrue(s.isCppFile());
		SourceCodeFile s = new SourceCodeFile("src/test/data/test1.cpp");
		assertTrue(s.getFile().exists());
		//assertEquals(s.getPath(), "src/test/data/test1.cpp");
		Reader input = s.getInput("src/test/data/test1.cpp");
		LinkedList<Token> tokens = new LinkedList<Token>();
	    s.tokenize(input, tokens);
	    assertFalse(tokens.isEmpty());
	    assertEquals(tokens.size(), 21);
		
		
		//SourceCodeFile r = new SourceCodeFile("/home/cs_vdulc001/cppTest.cpp");
	    //SourceCodeFile r = new SourceCodeFile("src/test/data/test1.cpp");
		//assertTrue(s.equals(r));
		//assertNotNull(s.toString());
	
	}

}
