package edu.odu.cs.cs350;

import java.util.ArrayList;

public class TokenSequence {

	private ArrayList<Token> tokenList = new ArrayList<Token>();
	
	public TokenSequence(ArrayList<Token> tokenList) 
	{
		for(int i = 0; i < tokenList.size(); i++)
			this.tokenList.add(tokenList.get(i));
	}
	
	public ArrayList<Token> getTokenList() { return tokenList; }
	
	public String toString()
	{
		String output = "";
		for(Token temp : tokenList)
		{
			if(temp.getLexeme() != "")
				output += temp.getLexeme() + " ";
		}
		return output;
	}
}
