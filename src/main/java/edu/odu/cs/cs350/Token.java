package edu.odu.cs.cs350;

public class Token {
	private String lexeme;
	private String tokenType; //might need to add a tokenType file and change this line to 'private tokeType type;' instead of string
	private int line;
	private int column;
	//possibly length?
	//setTokenType?
	
	
	//create a token with no explicit lexeme
	public Token(String tokenType, int line, int column) {
		this.lexeme = "";
		this.tokenType = tokenType;
		this.line = line;
		this.column = column;
	}
	
	//create a token
	public Token(String lexeme, String tokenType, int line, int column) {
		this.lexeme = lexeme;
		this.tokenType = tokenType;
		this.line = line;
		this.column = column;
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
	public String getTokenType() {
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
	
/*	public final tokenType getType() {
		return this.type;
	}
*/
	
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

