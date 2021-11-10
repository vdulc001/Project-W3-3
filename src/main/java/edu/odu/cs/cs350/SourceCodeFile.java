package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author cs_vdulc001
 * @author cs_jrosa005
 *
 */
public class SourceCodeFile {
	
	private File scf;
	private List<Token> tokens;
	int numberOfTokens;
	
	/**
	 * Initializes source code file using its absolute path
	 * @param path
	 */
	public SourceCodeFile(String path)
	{
		scf = new File(path);
		numberOfTokens = 0;
	}
	
	/**
	 * Returns the source code file
	 * @return source code file
	 */
	public File getFile()
	{
		return scf;
	}
	
	/**
	 * Returns the absolute path of the source code file
	 * @return absolute path
	 */
	public String getPath()
	{
		return scf.getAbsolutePath();
	}
	
	/**
	 * Returns number of tokens in a source code file
	 * @return number of tokens
	 */
	public int getNumberOfTokens()
	{
		calculateTotalTokens(tokens, numberOfTokens);
		return numberOfTokens; 
	}

	/**
	 * Calculates total number of tokens in a source code file
	 * @return total number of tokens
	 */
	public void calculateTotalTokens(final List<Token> listTok, int size) { 
		size = listTok.size();
	}
	
	/**
	 * Create a list of tokens from the scanner **we need to make this read in scf
	 */
	public void tokenize(final Reader input) {
		tokens = new LinkedList<Token>();
		GeneratedScanner scanner = new GeneratedScanner (input);
		try {
            Token token = scanner.yylex();
            while (token != null && token.getTokenType() != TokenKinds.EOF) {
                tokens.add (token);
                token = scanner.yylex();
            }
        } catch (IOException ex) {
            // Not necessarily a problem, depending on the input source
        }
	}
	
	/**
	 * Compares 2 files for equality
	 * @param other source code file
	 * @return true if paths are equal
	 */
	public Boolean equals(SourceCodeFile other)
	{
		if(getPath().equals(other.getPath()))
			return true;
		else
			return false;
	}
	
	/**
	 * Format and return the absolute path of a file and its number of tokens
	 */
	public String toString()
	{
		String output = getPath() + ", " + numberOfTokens;
		return output;
	}
}
