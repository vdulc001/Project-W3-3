package edu.odu.cs.cs350;

import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;



import java.io.Reader;
public class Refactoring {

    private int maxRefactors;
    private SourceCodeFile fileToCheck;
    private LinkedList < Token > refactoredTokens = new LinkedList < Token > ();

    /**
     * 
     * @param nSuggestions - Number of refactors set by the CLP
     * @param scf - Source code file being checked for refactoring opportunities
     */
    public Refactoring(int nSuggestions, SourceCodeFile scf) {
        maxRefactors = nSuggestions;
        fileToCheck = scf;
    }

    /**
     * Set the number of refactors found to a given int
     * @param num
     */
    public void setMaxNumRefactors(int num) {
        maxRefactors = num;
    }

    /**
     * Returns number of max refactors
     * @return - max number of refactors
     */
    public int getMaxNumRefactors() {
        return maxRefactors;
    }

    /**
     * Returns the number of refactors found
     * @return - number of tokens to be refactored
     */
    public int getNumRefactors() {
        return refactoredTokens.size();
    }

    /**
     * Sets the file to be checked
     * @param sCodeFile
     */
    public void setFile(SourceCodeFile sCodeFile) {
        fileToCheck = sCodeFile;
    }

    /**
     * Returns the file being checked by this refactoring
     * @return - source code file
     */
    public SourceCodeFile getFile() {
        return fileToCheck;
    }

    /**
     * Returns the tokens found as an opportunity for a refactor
     * @return - list of tokens to be refactored
     */
    public LinkedList < Token > getRefactoredOpportunities() {
        return refactoredTokens;
    }

    /**
     * Find opportunities for refactoring in the source code file, fileToCheck
     * Place refactored tokens inside tokenList
     * TODO - Read every token in the tokenized SCF to check for refactoring opportunity
     */
    public void findRefactored() throws Exception {
        //fileToCheck.tokenize(input, tokenList);
        /**
         * for every token (stream)
         *      find opportunity for refactoring
         *      add refactored tokens to tokenList
         *      subtract 1 from numRefactors
         */

        Reader input = fileToCheck.getInput(fileToCheck.getPath());
        LinkedList < Token > fullTokenList = new LinkedList < Token > ();
        LinkedList < Token > temp = new LinkedList < Token > ();

        fileToCheck.tokenize();

        int index = 0;
        for (Token tok: fullTokenList) {
            if (tok.getTokenType() != TokenKinds.SEMICOLON) {
                temp.add(tok);
            } else {
                compareTokenSequence(fullTokenList, temp, index);
            }
			// max refactors reached
			if(refactoredTokens.size() == maxRefactors){
				break;
			}
        }

    }

    /**
     * Add the token nodes to refactoredTokens if code is duplicate
     * Start comparison from the line number the semicolon is detected
     * TODO compare the tokens of 2 lines of code given that a semicolon is present
     */
    public void compareTokenSequence(LinkedList < Token > fullTokenList, LinkedList < Token > tokenSequence, int indexToStart) {
        boolean refactorFound = false;

        for (int i = indexToStart; i < fullTokenList.size(); i++) {

            if (tokenSequence.getFirst() == fullTokenList.get(indexToStart)) {
                //Begins comparison between tokenSequence and a detected line of code from the scf
                for (Token tok: tokenSequence) {
                    if (tok == fullTokenList.get(indexToStart)) {
                        refactoredTokens.add(tokenSequence.get(indexToStart));
                        refactorFound = true;
                    } else {
                        break;
                    }
                }

            }
        }

        if (refactorFound) {
            for (Token tok: tokenSequence) {
                refactoredTokens.add(tok);
            }
        }

    }

    // utility to populate a list with duplicates and print to screen
    public void Dup_finder(List < String > list, List < String > duplicates, File directory) {
        for (File child: directory.listFiles()) {
            if (child.isDirectory()) {
                Dup_finder(list, duplicates, child);
            } else {
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
    
    // for visible output comment out if needed
    public Refactoring() {};
    public int getOpportunityImprovement(SourceCodeFile scf) {return scf.calculateTotalTokens() * 1;};
    public String refactoringOutput(SourceCodeFile scf)
    {
    	String output = "Opportunity: " + getOpportunityImprovement(scf) + ", " + scf.calculateTotalTokens() + " tokens\n";
    	output += scf.getPath() + ":" + scf.getTokens().get(0).getLine() + ":" + scf.getTokens().get(0).getLine() + "\n";
    	output += "a b c\n";
    	return output;
    }
}
