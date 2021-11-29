package edu.odu.cs.cs350;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayList;
import javax.xml.transform.Source;
import java.io.Reader;

public class Refactoring {

	public Refactoring () {}
	
	public int findOpportunityForImprovement () {return 0;}
	
	public String refactoringOutput(SourceCodeFile scf)
	{
		String output = "Opportunity 0, 0 tokens\n";
		output += scf.getPath() + ": 0, 0\n";
		output += "x y z";
		return output;
	}
	
    private int numOccurrences;
    private int maxRefactors;
    private ArrayList<SourceCodeFile> fileList = new ArrayList<SourceCodeFile>();
    private LinkedList<Token> refactoredTokens = new LinkedList<Token>();

    /**
     * @param num - Number of refactors set by the CLP
     * @param scf - Source code file being checked for refactoring opportunities
     */
    public Refactoring(int nSuggestions, ArrayList<SourceCodeFile> fileList){
        maxRefactors = nSuggestions;
        this.fileList = fileList;
    }

    /**
     * @param refactoredTokens - linked list of tokenized line/block of refactored code
     */
    public void setRefactoredTokens(LinkedList<Token> refactoredTokens){
        this.refactoredTokens = refactoredTokens;
    }

    /**
     * @return - linked list of tokenized line/block of refactored code
     */
    public LinkedList<Token> getRefactoredTokens(){
        return refactoredTokens;
    }

    /**
     * @param scf - add a source code file to be scanned for cases of refactored tokens
     */
    public void addFiles(SourceCodeFile scf){
        fileList.add(scf);
    }

    /**
     * @return - return the list of files that was found with the refactored code
     */
    public ArrayList<SourceCodeFile> getSourceCodeFiles(){
        return fileList;
    }

    /**
     * @param nSuggestions - set nSuggestions
     */
    public void setNumRefactors(int nSuggestions){
        maxRefactors = nSuggestions;
    }

    /**
     * @return - return nSuggestions
     */
    public int getNumRefactors(){
        return maxRefactors;
    }

    /**
     * Output a list of the suggested refactoring from the source code files
     */
    public void findRefactored() throws Exception{
        //fileToCheck.tokenize(input, tokenList);
        /**
         * for every token (stream)
         *      find opportunity for refactoring
         *      add refactored tokens to tokenList
         *      subtract 1 from numRefactors
         */

        Reader input = fileToCheck.getInput(fileToCheck.getPath());
        LinkedList<Token> fullTokenList = new LinkedList<Token>();
        LinkedList<Token> temp = new LinkedList<Token>();

        //fileToCheck.tokenize(/*input,fullTokenList*///);

        int index = 0;
        for(Token tok : fullTokenList){
            if(tok.getTokenType() != TokenKinds.SEMICOLON){
                temp.add(tok);
            }
            else{
                //compareTokenSequence(fullTokenList, temp, index);
            }
        }

    }


    /**
     * Output a list of the suggested refactoring from the source code files, string format
     */
    public String printRefactoredToString(){
        String toString = " ";
    	// see refactoringOutput() above!
        return toString;
    }
}
