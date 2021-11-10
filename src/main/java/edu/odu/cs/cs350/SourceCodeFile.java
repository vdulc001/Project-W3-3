package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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
	private ArrayList<Token> tokens;
	
	/**
	 * Initializes source code file using its absolute path
	 * @param path
	 */
	public SourceCodeFile(String path)
	{
		scf = new File(path);
		tokens = new ArrayList<Token>();
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
	 * Calculates total number of tokens in a source code file
	 * @return total number of tokens
	 */
	public int calculateTotalTokens() { 
		return tokens.size();
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
}
