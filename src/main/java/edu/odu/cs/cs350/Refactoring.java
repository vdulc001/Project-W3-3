package edu.odu.cs.cs350;

import java.util.ArrayList;

public class Refactoring {

    private int numRefactors;
    private SourceCodeFile fileToCheck;
    //List of token streams?
    private ArrayList<Token> tokenList = new ArrayList<Token>();
    

    public Refactoring(){
        numRefactors = 0;
    }

    /**
     * 
     * @param num - Number of refactors set by the CLP
     * @param scf - Source code file being checked for refactoring opportunities
     */
    public void setNumRefactors(int num, SourceCodeFile scf){
        numRefactors = num;
        fileToCheck = scf;
    }

    /**
     * Returns the number of tokens found as an opportunity for a refactor
     * @return - number of tokens to be refactored
     */
    public int getNumTokens(){
        return tokenList.size();
    }

    /**
     * Returns the tokens found as an opportunity for a refactor
     * @return - list of tokens to be refactored
     */
    public ArrayList<Token> getRefactoredOpportunities(){
        return tokenList;
    }

    /**
     * Find opportunities for refactoring in the source code file, fileToCheck
     * TODO - Read every token in the tokenized SCF to check for refactoring opportunity
     */
    public void findRefactored(){
        //fileToCheck.tokenize(input);
        /**
         * for every token (stream)
         *      find opportunity for refactoring
         *      add refactored tokens to tokenList
         *      subtract 1 from numRefactors
         */
    }

    /**
     * Output a list of the suggested refactoring for the source code file, fileToCheck
     */
    public void printRefactored(){
    }
}
