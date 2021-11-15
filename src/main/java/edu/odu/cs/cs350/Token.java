package edu.odu.cs.cs350;


/**
 * 
 * @author cs_jrosa005
 *
 */
public class Token {
	private String lexeme;
	private TokenKinds tokenType;
	private int line;
	private int column;
	//private int tokenStart;
	//private int tokenLength;
	
	
	//create a token with no lexeme
	public Token(final TokenKinds theTokenType, final int lineNum, final int columnNum) {
		this.lexeme = "";
		this.tokenType = theTokenType;
		this.line = lineNum;
		this.column = columnNum;
	}
	
	//create a token
	public Token(final TokenKinds theTokenType, int lineNum, int columnNum, final String theLexeme) {
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
	public final TokenKinds getTokenType() {
		return this.tokenType;
	}
	
	/**
	 * what is the lexeme (character string) associated with the token?
	 * @return the lexeme
	 */
	public String getLexeme() {
		return this.lexeme;
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

