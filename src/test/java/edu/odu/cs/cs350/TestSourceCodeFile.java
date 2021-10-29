package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSourceCodeFile {

	@Test
	void testSourceCodeFile() {
		SourceCodeFile s = new SourceCodeFile("/this/is/a/fake/path");
		assertEquals(s.getPath(), "/this/is/a/fake/path");
		
		SourceCodeFile r = new SourceCodeFile("/this/is/a/fake/path");
		assertTrue(s.equals(r));
		assertEquals(s.toString(), "Path to file/directory: /this/is/a/fake/path");
	}
	
	

}
