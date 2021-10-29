package edu.odu.cs.cs350;

public class Token {
	private String lexeme;
	private String tokenType;
	
	public Token(String lexeme) {
		this.lexeme = lexeme;
	}
	
	public String getTokenType() {
		return this.tokenType;
	}
	
	public String getLexeme() {
		return this.lexeme;
	}
	
	public void detectTokenType() {
		
	}
}
