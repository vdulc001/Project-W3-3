package edu.odu.cs.cs350;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.transform.Source;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Refactoring {

    private int maxRefactors;
    private ArrayList<SourceCodeFile> filesToCheck = new ArrayList<SourceCodeFile>();
    private LinkedList<Token> tokenSequence = new LinkedList<Token>();
    private LinkedList <String> refactoredTokens = new LinkedList <String> ();
    int tokenCount = 0;

    /**
     * 
     * @param num - Number of refactors set by the CLP
     * @param scf - Source code file being checked for refactoring opportunities
     */
    public Refactoring(int nSuggestions, ArrayList<SourceCodeFile> fileList, LinkedList<Token> tokenSequence) {
        maxRefactors = nSuggestions;
        filesToCheck = fileList;
        this.tokenSequence = tokenSequence;
    }

    public void setTokenSequence(LinkedList<Token> tokenSequence){
        this.tokenSequence = tokenSequence;
    }

    public LinkedList<Token> getTokenSequence(){
        return tokenSequence;
    }

    
    public void setRefactoredTokens(LinkedList<String> tokens){
        refactoredTokens = tokens;
    }

    public LinkedList<String> getRefactoredTokens(){
        return refactoredTokens;
    }
    

    public void setNumRefactors(int nSuggestions){
        maxRefactors = nSuggestions;
    }

    public int getNumRefactors(){
        return maxRefactors;
    }

    public void addFiles(SourceCodeFile scf){
        filesToCheck.add(scf);
    }

    public ArrayList<SourceCodeFile> getSourceCodeFiles(){
        return filesToCheck;
    }

    public String printRefactoredToString(){
        String s = "";

        return s;
    }

    public void printRefactored(){
        int opportunity = 0;
        System.out.println("Opportunity " + opportunity + ", " + tokenCount + " tokens");

    }

    public void findRefactored(){
        for(SourceCodeFile scf: filesToCheck){
            scf.tokenize();
            int index = 0;
            for(Token tok: scf.getTokens()){
                if( (tok.getTokenType() == TokenKinds.INT
                || tok.getTokenType() == TokenKinds.DOUBLE
                || tok.getTokenType() == TokenKinds.STRING
                || tok.getTokenType() == TokenKinds.BOOL
                || tok.getTokenType() == TokenKinds.IDENTIFIER
                || tok.getTokenType() == TokenKinds.INTEGER_LITERAL
                || tok.getTokenType() == TokenKinds.OPERATOR) 
                && tok == tokenSequence.get(index)){
                    addToken(tok);
                }
                else{
                    break;
                }
            }
        }
    }

    public void addToken(Token tok){
        if(tok.getTokenType() == TokenKinds.IDENTIFIER
        || tok.getTokenType() == TokenKinds.INTEGER_LITERAL){
            refactoredTokens.add(tok.getLexeme());
        }

        tokenCount++;
    }

    // utility to populate a list with duplicates and print to screen
    public void Dup_finder(List < String > list, List < String > duplicates, File directory) {
        for (File child: directory.listFiles()) {
            if (child.isDirectory()) {
                Dup_finder(list, duplicates, child);
            } 
            else {
                String filename = child.getName();
                if (filename.endsWith(".cpp") | filename.endsWith(".h"))

                    // similar files will return same hashcode in runtime
                    if (isDuplicate(list, child.getAbsolutePath())) {
                        duplicates.add(child.getAbsolutePath());
                    }
                else {
                    list.add(child.getAbsolutePath());
                }
            }
        }   
    }

    // Function to check if file has duplicate file
    public boolean isDuplicate(List < String > list, String check) {
        BufferedReader in , tmp;
        boolean flag = false;
        for (String token: list) {
            try {
                flag = false; in = new BufferedReader(new FileReader(check));
                tmp = new BufferedReader(new FileReader(token));
                String _in_ = null, _tmp_ = null;
                while ((_in_ = in .readLine()) != null && (_tmp_ = tmp.readLine()) != null) {
                    // flag not equal
                    if (!_in_.equalsIgnoreCase(_tmp_)) {
                        flag = true;
                        break;
                        }
                }
                if (!flag) { 
                    in .close();
                    tmp.close();
                    return true;
                }
            } catch (IOException e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
        return false;
    }
    /**
     * Output a list of the suggested refactoring for the source code file, fileToCheck
     *
    public void printRefactored() {
        for(Token tok:refactoredTokens){
            printf("%s", tok.toString());
        }
    }
*/
}
