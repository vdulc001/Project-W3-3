package edu.odu.cs.cs350;

import java.util.LinkedList;
import java.io.Reader;
public class Refactoring {

    private int numRefactors;
    private SourceCodeFile fileToCheck;
    private LinkedList<Token> fullTokenList = new LinkedList<Token>();
    private LinkedList<Token> refactoredTokens = new LinkedList<Token>();

    /**
     * 
     * @param num - Number of refactors set by the CLP
     * @param scf - Source code file being checked for refactoring opportunities
     */
    public Refactoring(int nSuggestions, SourceCodeFile scf){
        numRefactors = nSuggestions;
        fileToCheck = scf;
    }
    
    /**
     * Set the number of refactors found to a given int
     * @param num
     */
    public void setNumRefactors(int num){
        numRefactors = num;
    }

    /**
     * Returns the number of tokens found as an opportunity for a refactor
     * @return - number of tokens to be refactored
     */
    public int getNumTokens(){
        return refactoredTokens.size();
    }

    /**
     * Returns the tokens found as an opportunity for a refactor
     * @return - list of tokens to be refactored
     */
    public LinkedList<Token> getRefactoredOpportunities(){
        return refactoredTokens;
    }

    /**
     * Find opportunities for refactoring in the source code file, fileToCheck
     * Place refactored tokens inside tokenList
     * TODO - Read every token in the tokenized SCF to check for refactoring opportunity
     * @throws Exception
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
        fileToCheck.tokenize(input,fullTokenList);
        LinkedList<Token> temp = new LinkedList<Token>();
        boolean semicolonDetected = false;

        for(Token tok : fullTokenList){
            if(tok.getTokenType() != TokenKinds.SEMICOLON){
                temp.add(tok);
            }
            else{
                semicolonDetected = true;
                int semicolonLineNum = tok.getLine();
            }

            if(semicolonDetected){
            }
        }

    }

    /**
     * Add the token nodes to refactoredTokens if code is duplicate
     * Start comparison from the line number the semicolon is detected
     * TODO compare the tokens of 2 lines of code given that a semicolon is present
     */
    public void compareTokenSequence(LinkedList<Token> fullTokenList, LinkedList<Token> tokenSequence){

    }

    /**
     * Output a list of the suggested refactoring for the source code file, fileToCheck
     */
    public void printRefactored(){
    }
}
