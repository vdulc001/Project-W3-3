package edu.odu.cs.cs350;

import java.io.Reader;
import java.util.LinkedList;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSourceCodeFile {

	@Test
	void testSourceCodeFile() throws Exception{
		//assertTrue(s.isCppFile());
		ArrayList<Token> toks = new ArrayList<Token>();
		SourceCodeFile s = new SourceCodeFile("src/test/data/test1.cpp");
		toks = s.getTokens();
        
		assertFalse (toks.isEmpty());
        assertEquals (70, s.calculateTotalTokens());
		assertTrue(s.getFile().exists());
		//assertEquals(s.getPath(), "src/test/data/test1.cpp");
	}

}
