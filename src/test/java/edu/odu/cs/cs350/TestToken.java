package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestToken() {
	
	/*need to implement token stream and jflex scanner in order to properly test
	*/
	@Test
	void testToken() {
		Token t = new Token("123", TokenTypes.INTEGER_LITERAL, 1, 1);
		assertEquals (TokenTypes.INTEGER_LITERAL, t.getTokenType());
		assertEquals ("123", t.getLexeme());
		assertEquals (1, t.getLine());
		assertEquals (1, t.getColumn());
	}
}