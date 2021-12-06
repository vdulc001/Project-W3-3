package edu.odu.cs.cs350;

import java.util.ArrayList;

/**
 * 
 * @author cs_vdulc001
 * @author cs_cdiaz014
 * @author sheldon
 *
 */
public class Refactoring {

<<<<<<< HEAD
    private int numRefactors;
    private static ArrayList<SourceCodeFile> fileList = new ArrayList<SourceCodeFile>();
=======
	private ArrayList<TokenSequence> suggestions;
	
	/**
	 * Creates refactoring object holding new list of suggestions
	 */
	public Refactoring () 
	{
		suggestions = new ArrayList<TokenSequence>();
	}
	
	/**
	 * Creates refactoring object holding existing list of suggestions
	 */
	public Refactoring (ArrayList<TokenSequence> suggestions)
	{
		for(int i = 0; i < suggestions.size(); i++)
			this.suggestions.add(suggestions.get(i));
	}
	
	public ArrayList<TokenSequence> getSuggestions() { return suggestions; }
	
	/**
	 * Calculates the total tokens saved from all suggestions
	 * @param testSequence
	 * @return opportunity for improvement
	 */
	public int getOpportunityForImprovement (ArrayList<Token> testSequence) {return testSequence.size() * suggestions.size();}
	
	/**
	 * Finds duplicate sequences and adds them to the list of suggested replacements
	 * @param testSequence
	 * @param testFile
	 */
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
	
	/**
	 * 
	 * @param testSequence
	 * @param currentSequence
	 * @return true if testSequence == currentSequence
	 */
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
	
	/**
	 * Prints the suggested refactorings for a source file
	 * @param testSequence
	 * @param testFile
	 */
	public void refactoringOutput(ArrayList<Token> testSequence, SourceCodeFile testFile)
	{
		System.out.println("Opportunity: " + getOpportunityForImprovement(testSequence) + ", " + testSequence.size() + " tokens");
		for(TokenSequence temp : suggestions)
		{
			System.out.println(testFile.getPath() + ":" + temp.getTokenList().get(0).getLine() + ":" + temp.getTokenList().get(0).getColumn());
			System.out.println(temp.toString());
		}
	}
>>>>>>> branch 'main' of git@github.com:vdulc001/Project-W3-3.git

<<<<<<< HEAD
    public Refactoring(){
        numRefactors = 0;
    }
=======
    /**
	 * Prints the suggested refactorings for a source file
	 * @param testSequence
	 * @param testFile
     * @return outputString
	 */
	public String refactoringOutputToString(ArrayList<Token> testSequence, SourceCodeFile testFile)
	{
        String outputString = "";
        outputString += "Opportunity: " + getOpportunityForImprovement(testSequence) + ", " + testSequence.size() + " tokens";
		for(TokenSequence temp : suggestions)
		{
            outputString += "\n" + testFile.getPath() + ":" + temp.getTokenList().get(0).getLine() + ":" + temp.getTokenList().get(0).getColumn();
            outputString += "\n " + temp.toString() + "\n";
		}
>>>>>>> branch 'main' of git@github.com:vdulc001/Project-W3-3.git

<<<<<<< HEAD
    public Refactoring(int num, ArrayList<SourceCodeFile> list){
        fileList = list;
        numRefactors = num;
    }

    public void setFileList(ArrayList<SourceCodeFile> list){
        fileList = list;
    }

    public ArrayList<SourceCodeFile> getFileList(){
        return fileList;
    }

    public void setNumRefactors(int num){
        numRefactors = num;
    }

    public int getNumRefactors(){
        return numRefactors;
    }

    public String printRefactoredtoString(){
        String output;
        output = "Files scanned: ";

        for(int i = 0; i < fileList.size(); i++){
            //5 is just an arbitrary number as placeholder for num refactors actually found
            output = output + fileList.get(i).toString() + "5\n";
        }

        return output;
    }

    public void printRefactored(){
        System.out.println("Files scanned: ");
        for(int i = 0; i < fileList.size(); i++){
            //5 is just an arbitrary number as placeholder for num refactors actually found
            System.out.println(fileList.get(i).toString() + "5");
        }
    }
=======
        return outputString;
	}
>>>>>>> branch 'main' of git@github.com:vdulc001/Project-W3-3.git
}
