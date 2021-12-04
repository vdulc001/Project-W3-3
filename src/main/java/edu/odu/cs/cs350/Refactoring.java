package edu.odu.cs.cs350;


import java.util.ArrayList;
//import java.util.LinkedList;
//import javax.xml.transform.Source;
//import java.io.Reader;
//import java.util.List;
//import java.io.File;
//import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.FilterReader;
//import java.io.IOException;



public class Refactoring {

	private ArrayList<Token> testSequence;
	private ArrayList<TokenSequence> suggestions;
	
	public Refactoring () 
	{
		testSequence = new ArrayList<Token>();
		suggestions = new ArrayList<TokenSequence>();
	}
	
	public ArrayList<Token> getTestSequence() { return testSequence; }
	public ArrayList<TokenSequence> getSuggestions() { return suggestions; }
	
	public int getOpportunityForImprovement () {return testSequence.size() * suggestions.size();}
	
	public void createTestSequence(SourceCodeFile firstFile)
	{
		for(int i = 0; i < firstFile.getTotalTokens(); i++)
		{
			if(firstFile.getTokens().get(i).getTokenType() == TokenKinds.SEMICOLON)
			{
				testSequence.add(firstFile.getTokens().get(i));
				break;
			}
			else
				testSequence.add(firstFile.getTokens().get(i));
		}
	}
	
	public void findDupSequences(SourceCodeFile testFile)
	{
		ArrayList<Token> testFileSequence = new ArrayList<Token>();
		
		int i = 0;
		//int cnt = 0;
		
		while(i < testFile.getTotalTokens())
		{
			int j;
			for(j = i; j < testFile.getTotalTokens(); j++)
			{
				if(testFile.getTokens().get(j).getTokenType() == TokenKinds.SEMICOLON)
				{
					testFileSequence.add(testFile.getTokens().get(j));
					break;
				}
				else
					testFileSequence.add(testFile.getTokens().get(j));
			}
			
			/*if(cnt == 0)
			{
				System.out.println("Opportunity " + getOpportunityForImprovement() + ", " + testSequence.size() + " tokens");
				cnt++;
			}*/
			
			if(compareSequences(testFileSequence))
				suggestions.add(new TokenSequence(testFileSequence));
			
			//System.out.println(testFileSequence);
			
			testFileSequence.clear();
			i = j+1;
		}
	}
	
	public Boolean compareSequences(ArrayList<Token> temp)
	{
		if(testSequence.size() != temp.size())
			return false;
		for(int i = 0; i < testSequence.size(); i++)
		{
			if(testSequence.get(i).getTokenType() != temp.get(i).getTokenType())
				return false;
		}
		return true;
	}
	
	public void /*String*/ refactoringOutput(SourceCodeFile scf)
	{
		System.out.println("Opportunity: " + getOpportunityForImprovement() + ", " + testSequence.size() + " tokens");
		for(TokenSequence temp : suggestions)
		{
			System.out.println(scf.getPath() + ":" + temp.getTokenList().get(0).getLine() + ":" + temp.getTokenList().get(0).getColumn());
			System.out.println(temp.toString());
		}
		
		/*String output = "";
		output += scf.getPath() + ": " + testFileSequence.get(0).getLine() + ", " + testFileSequence.get(0).getColumn() + "\n";
		for(Token temp : testFileSequence)
		{
			if(temp.getLexeme() != "")
				output += temp.getLexeme() + " ";
		}
		return output;*/
	}
}
