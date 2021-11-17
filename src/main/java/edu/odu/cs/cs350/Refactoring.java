package edu.odu.cs.cs350;

import java.util.LinkedList;

import javax.xml.transform.Source;

import java.io.Reader;
public class Refactoring {

    private int maxRefactors;
    private SourceCodeFile fileToCheck;
    private LinkedList<Token> refactoredTokens = new LinkedList<Token>();

    /**
     * 
     * @param num - Number of refactors set by the CLP
     * @param scf - Source code file being checked for refactoring opportunities
     */
    public Refactoring(int nSuggestions, SourceCodeFile scf){
        maxRefactors = nSuggestions;
        fileToCheck = scf;
    }
    
    /**
     * Set the number of refactors found to a given int
     * @param num
     */
    public void setMaxNumRefactors(int num){
        maxRefactors = num;
    }

    /**
     * Returns number of max refactors
     * @return - max number of refactors
     */
    public int getMaxNumRefactors(){
        return maxRefactors;
    }

    /**
     * Returns the number of refactors found
     * @return - number of tokens to be refactored
     */
    public int getNumRefactors(){
        return refactoredTokens.size();
    }

    /**
     * Sets the file to be checked
     * @param sCodeFile
     */
    public void setFile(SourceCodeFile sCodeFile){
        fileToCheck = sCodeFile;
    }

    /**
     * Returns the file being checked by this refactoring
     * @return - source code file
     */
    public SourceCodeFile getFile(){
        return fileToCheck;
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

        fileToCheck.tokenize(/*input,fullTokenList*/);

        int index = 0;
        for(Token tok : fullTokenList){
            if(tok.getTokenType() != TokenKinds.SEMICOLON){
                temp.add(tok);
            }
            else{
                compareTokenSequence(fullTokenList, temp, index);
            }
        }

    }

    /**
     * Add the token nodes to refactoredTokens if code is duplicate
     * Start comparison from the line number the semicolon is detected
     * TODO compare the tokens of 2 lines of code given that a semicolon is present
     */
    public void compareTokenSequence(LinkedList<Token> fullTokenList, LinkedList<Token> tokenSequence, int indexToStart){
        boolean refactorFound = false;

        for(int i = indexToStart; i < fullTokenList.size(); i++){

            if(tokenSequence.getFirst() == fullTokenList.get(indexToStart)){
                //Begins comparison between tokenSequence and a detected line of code from the scf
                for(Token tok: tokenSequence){
                    if(tok == fullTokenList.get(indexToStart)){
                        refactoredTokens.add(tokenSequence.get(indexToStart));
                    }
                    else{
                        break;
                    }
                }

            }
        }

        if(refactorFound){
            for(Token tok: tokenSequence){
                refactoredTokens.add(tok);
            }
        }

    }

    /**
     * Output a list of the suggested refactoring for the source code file, fileToCheck
     */
    public void printRefactored(){

    }
}
