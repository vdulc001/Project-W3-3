package edu.odu.cs.cs350;

import edu.odu.cs.cs350.sharedphrases.*;

/**
 * 
 * @author cs_jrosa005
 *
 */
public class Token implements edu.odu.cs.cs350.sharedphrases.Token {
	private String lexeme;
	private TokenKinds tokenType;
	private int line;
	private int column;
	//private int tokenStart;
	//private int tokenLength;
	
	
	//create a token with no lexeme
	public Token(final TokenKinds theTokenType, final int lineNum, final int columnNum) {
		lexeme = "";
		tokenType = theTokenType;
		line = lineNum;
		column = columnNum;
	}
	
	//create a token
	public Token(final TokenKinds theTokenType, int lineNum, int columnNum, final String theLexeme) {
		lexeme = theLexeme;
		tokenType = theTokenType;
		line = lineNum;
		column = columnNum;
	}
	
	/**
	 * representation of the token for debugging
	 */
	@Override
	public final String toString() {
		if (getLexeme().length() > 0) {
			return getTokenType() + ":" + getLexeme();
		} else {
			return getTokenType().toString();
		}
	}
	
	/**
	 * @return the type of token
	 */
	public final TokenKinds getTokenType() {
		return tokenType;
	}
	
	/**
	 * what is the lexeme (character string) associated with the token?
	 * @return the lexeme
	 */
	public String getLexeme() {
		return lexeme;
	}
	
	/**
	 * @return the line number
	 */
	public int getLine() {
		return line;
	}
	
	/**
	 * @return the column number
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return token kind as an int value
	 */
	public int getTokenKind() {
		return tokenType.ordinal();
	}
	
}

