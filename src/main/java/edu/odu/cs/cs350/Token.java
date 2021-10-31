package edu.odu.cs.cs350;

public class Token {
	private String lexeme;
	public enum TokenTypes {KEYWORD, INTEGER_LITERAL, IDENTIFIER, EOF};
	private TokenTypes tokenType;
	private int line;
	private int column;
	//possibly length?
	//setTokenType?
	
	
	//create a token with no lexeme
	public Token(final TokenTypes theTokenType, final int lineNum, final int columnNum) {
		this.lexeme = "";
		this.tokenType = theTokenType;
		this.line = lineNum;
		this.column = columnNum;
	}
	
	//create a token
	public Token(final String theLexeme, final TokenTypes theTokenType, int lineNum, int columnNum) {
		this.lexeme = theLexeme;
		this.tokenType = theTokenType;
		this.line = lineNum;
		this.column = columnNum;
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
	public final TokenTypes getTokenType() {
		return this.tokenType;
	}
	
	/**
	 * what is the lexeme (character string) associated with the token?
	 * @return the lexeme
	 */
	public String getLexeme() {
		return this.lexeme;
	}
	
	public void detectTokenType() {
		
	}
	
	
	/**
	 * @return the line number
	 */
	public int getLine() {
		return this.line;
	}
	
	/**
	 * @return the column number
	 */
	public int getColumn() {
		return this.column;
	}
	
	
}

