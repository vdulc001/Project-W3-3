package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTokenSequence {

	@Test
	void testTokenSequence() {
		SourceCodeFile scf1 = new SourceCodeFile("src/test/data/test1.cpp");
		TokenSequence ts = new TokenSequence(scf1.getTokens());
		assertFalse(ts.getTokenList().isEmpty());
		assertFalse(ts.getTokenList().size() == 0);
		assertEquals(ts.getTokenList().size(), scf1.getTotalTokens());
		assertTrue(ts.toString() != "");
		
	}

}
