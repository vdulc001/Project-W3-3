package edu.odu.cs.cs350;

import java.util.List;

import javax.print.PrintException;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import edu.odu.cs.cs350.sharedphrases.*;
import edu.odu.cs.cs350.sharedphrases.Token;

public class Refactoring {

    private int maxRefactors;
    private ArrayList<SourceCodeFile> filesToCheck = new ArrayList<SourceCodeFile>();
    private List<? extends edu.odu.cs.cs350.sharedphrases.Token> encodedTokens;
    int tokenCount = 0;

    public Refactoring(){
    }
    
    /**
     * 
     * @param num - Number of refactors set by the CLP
     * @param scf - Source code file being checked for refactoring opportunities
     */
    public Refactoring(int nSuggestions, ArrayList<SourceCodeFile> fileList) {
        maxRefactors = nSuggestions;
        filesToCheck = fileList;
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

    public void printRefactored() throws NoClassDefFoundError, IllegalTokenKindException{
        int opportunity = 0;
        System.out.println("Opportunity " + opportunity + ", " + tokenCount + " tokens");

        SharedPhrases phrases = new SharedPhrases();

        for(SourceCodeFile scf: filesToCheck){
            encodeTokens(scf, phrases);
        }

        for (CharSequence p: phrases.allPhrases()) {
            System.out.print (p + ": ");
            for (String source: phrases.sourcesOf(p.toString())) {
                System.out.print (source);
            }
            System.out.println();
        }
         
    }

    public void encodeTokens(SourceCodeFile scf, SharedPhrases phrases) throws IllegalTokenKindException{

        List<? extends edu.odu.cs.cs350.sharedphrases.Token> tokenList = scf.getTokens();

        phrases.addSentence(TokenEncoding.encode(tokenList), "fds");
    }

    // utility to populate a list with duplicates and print to screen
    public void Dup_finder(List < String > list, List < String > duplicates, File directory) {
        for (File child: directory.listFiles()) {
            if (child.isDirectory()) {
                Dup_finder(list, duplicates, child);
            } 
            else {
                String filename = child.getName();
                if (filename.endsWith(".cpp") || filename.endsWith(".h"))

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
