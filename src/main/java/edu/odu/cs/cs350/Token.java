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
<<<<<<< HEAD
	private int tokenStart;
	private int tokenLength;
=======
>>>>>>> branch 'main' of git@github.com:vdulc001/Project-W3-3.git
	
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
	
<<<<<<< HEAD
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
	
	/**
	 * @return the token start
	 */
	public int getStart() {
		return this.tokenStart;
	}
	
	/**
	 * @return token length
	 */
	public int getLength() {
		return this.tokenLength;
	}
	
=======
>>>>>>> branch 'main' of git@github.com:vdulc001/Project-W3-3.git
}

