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
	
	/**
	 * Creates a token without a lexeme
	 * @param theTokenType
	 * @param lineNum
	 * @param columnNum
	 */
	public Token(final TokenKinds theTokenType, final int lineNum, final int columnNum) {
		lexeme = "";
		tokenType = theTokenType;
		line = lineNum;
		column = columnNum;
	}
	
	/**
	 * Creates a token with a lexeme
	 * @param theTokenType
	 * @param lineNum
	 * @param columnNum
	 * @param theLexeme
	 */
	public Token(final TokenKinds theTokenType, int lineNum, int columnNum, final String theLexeme) {
		lexeme = theLexeme;
		tokenType = theTokenType;
		line = lineNum;
		column = columnNum;
	}
	
	/**
	 * @return type of the token
	 */
	public final TokenKinds getTokenType() {
		return tokenType;
	}
	
	/**
	 * @return lexeme, character string associated with the token
	 */
	public String getLexeme() {
		return lexeme;
	}
	
	/**
	 * @return line number on which token starts
	 */
	public int getLine() {
		return line;
	}
	
	/**
	 * @return column number on which token starts
	 */
	public int getColumn() {
		return column;
	}
	
	/**
	 * Prints token by tokenType and lexeme
	 */
	@Override
	public final String toString() {
		if (getLexeme().length() > 0) {
			return getTokenType() + ":" + getLexeme();
		} else {
			return getTokenType().toString();
		}
	}
	
}

