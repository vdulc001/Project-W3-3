package edu.odu.cs.cs350;

import java.util.ArrayList;

/**
 * 
 * @author cs_vdulc001
 *
 */
public class TokenSequence {

	private ArrayList<Token> tokenList = new ArrayList<Token>();
	
	/**
	 * Creates TokenSequence object from existing list of tokens
	 * @param tokenList
	 */
	public TokenSequence(ArrayList<Token> tokenList) 
	{
		for(int i = 0; i < tokenList.size(); i++)
			this.tokenList.add(tokenList.get(i));
	}
	
	public ArrayList<Token> getTokenList() { return tokenList; }
	
	/**
	 * Prints each token in tokenList
	 */
	@Override
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
