package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSourceCodeFile {

	@Test
	void testSourceCodeFile() {
		SourceCodeFile s = new SourceCodeFile("/home/cs_vdulc001/cppTest.cpp");
		//assertTrue(s.isCppFile());
		assertTrue(s.getFile().exists());
		assertEquals(s.getPath(), "/home/cs_vdulc001/cppTest.cpp");
		assertEquals(s.calculateTotalTokens(), 0);
		
		SourceCodeFile r = new SourceCodeFile("/home/cs_vdulc001/cppTest.cpp");
		assertTrue(s.equals(r));
		assertNotNull(s.toString());
		
	}
	
	

}
