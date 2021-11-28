package edu.odu.cs.cs350;

import java.util.LinkedList;
import java.util.ArrayList;

import javax.xml.transform.Source;

import java.io.Reader;
public class Refactoring {

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
    public void printRefactored(){

    }

    /**
     * Output a list of the suggested refactoring from the source code files, string format
     */
    public String printRefactoredToString(){
        String toString = " ";

        return toString;
    }
}
