package edu.odu.cs.cs350;


import java.util.ArrayList;

public class Refactoring {

	private ArrayList<TokenSequence> suggestions;
	
	public Refactoring () 
	{
		suggestions = new ArrayList<TokenSequence>();
	}
	
	public Refactoring (ArrayList<TokenSequence> suggestions)
	{
		for(int i = 0; i < suggestions.size(); i++)
			this.suggestions.add(suggestions.get(i));
	}
	
	public ArrayList<TokenSequence> getSuggestions() { return suggestions; }
	
	public int getOpportunityForImprovement (ArrayList<Token> testSequence) {return testSequence.size() * suggestions.size();}
	
	public void findDupSequences(ArrayList<Token> testSequence, SourceCodeFile testFile)
	{
		ArrayList<Token> currentSequence = new ArrayList<Token>();
		int i = 0;
		
		while(i < testFile.getTotalTokens())
		{
			int j;
			for(j = i; j < testFile.getTotalTokens(); j++)
			{
				if(testFile.getTokens().get(j).getTokenType() == TokenKinds.SEMICOLON)
				{
					currentSequence.add(testFile.getTokens().get(j));
					break;
				}
				else
					currentSequence.add(testFile.getTokens().get(j));
			}
			
			if(compareSequences(testSequence, currentSequence))
				suggestions.add(new TokenSequence(currentSequence));
			
			currentSequence.clear();
			i = j+1;
		}
	}
	
	public Boolean compareSequences(ArrayList<Token> testSequence, ArrayList<Token> currentSequence)
	{
		if(testSequence.size() != currentSequence.size())
			return false;
		for(int i = 0; i < testSequence.size(); i++)
		{
			if(testSequence.get(i).getTokenType() != currentSequence.get(i).getTokenType())
				return false;
		}
		return true;
	}
	
	public void refactoringOutput(ArrayList<Token> testSequence, SourceCodeFile testFile)
	{
		System.out.println("Opportunity: " + getOpportunityForImprovement(testSequence) + ", " + testSequence.size() + " tokens");
		for(TokenSequence temp : suggestions)
		{
			System.out.println(testFile.getPath() + ":" + temp.getTokenList().get(0).getLine() + ":" + temp.getTokenList().get(0).getColumn());
			System.out.println(temp.toString());
		}
	}
}
