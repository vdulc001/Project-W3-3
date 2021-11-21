package edu.odu.cs.cs350;

import java.util.ArrayList;
import java.util.LinkedList;

public class Refactoring {

    private int maxRefactors;
    private ArrayList<SourceCodeFile> sourceCodeFiles = new ArrayList<SourceCodeFile>();
    private LinkedList<Token> tokenSequence = new LinkedList<Token>();

    /**
     * 
     * @param num - Number of refactors set by the CLP
     * @param scf - Source code file being checked for refactoring opportunities
     */
    public Refactoring(int nSuggestions, ArrayList<SourceCodeFile> sourceCodeFiles){
        maxRefactors = nSuggestions;
        this.sourceCodeFiles = sourceCodeFiles;
    }
    
    /**
     * Set the number of refactors to be found
     * @param nSuggestions - Max number of refactors
     */
    public void setnSuggestions(int nSuggestions){
        maxRefactors = nSuggestions;
    }

    /**
     * Returns number of max refactors
     * @return - max number of refactors
     */
    public int getnSuggestions(){
        return maxRefactors;
    }

    /**
     * Returns the number of refactors found
     * @return - number of tokens to be refactored
     */
    public int getNumRefactors(){
        //return startTokens.size();
        return 0;
    }

    /**
     * Sets the file to be checked
     * @param sCodeFile
     */
    public void addFile(SourceCodeFile scf){
        this.sourceCodeFiles.add(scf);
    }

    /**
     * Returns the file being checked by this refactoring
     * @return - source code file
     */
    public ArrayList<SourceCodeFile> getFiles(){
        return sourceCodeFiles;
    }

    /**
     * Find opportunities for refactoring in the source code file, fileToCheck
     * Place refactored tokens inside tokenList
     * TODO - Read every token in the tokenized SCF to check for refactoring opportunity
     */
    public void findRefactored() throws Exception{

        for(SourceCodeFile scf : sourceCodeFiles){

        }

    }


    /**
     * Output a list of the suggested refactoring for the source code file, fileToCheck
     */
    public void printRefactored(){
        int opportunity = 0;
        int tokens = 0;

        System.out.println("Opportunity " + opportunity + ", " + tokens + " tokens");

    }
}
