package edu.odu.cs.cs350;

import java.io.Reader;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSourceCodeFile {

	@Test
	void testSourceCodeFile() {
		//SourceCodeFile s = new SourceCodeFile("/home/cs_vdulc001/cppTest.cpp");
		//assertTrue(s.isCppFile());
		SourceCodeFile s = new SourceCodeFile("src/test/resources/test1.cpp");
		assertTrue(s.getFile().exists());
		assertEquals(s.getPath(), "src/test/resources/test1.cpp");
		Reader input = s.getInput(s.getPath());
	    s.tokenize(input);
	    assertEquals(s.calculateTotalTokens(), 17);
		
		
		//SourceCodeFile r = new SourceCodeFile("/home/cs_vdulc001/cppTest.cpp");
	    SourceCodeFile r = new SourceCodeFile("src/test/resources/test1.cpp");
		assertTrue(s.equals(r));
		assertNotNull(s.toString());
	
	}

}
