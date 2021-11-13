package edu.odu.cs.cs350;

import java.io.File;
import java.io.Reader;
import java.util.LinkedList;
import java.io.IOException;

/**
 * 
 * @author cs_vdulc001
 * @author cs_jrosa005
 *
 */
public class SourceCodeFile {
	
	private File file;
	private LinkedList<Token> tokens;
	
	/**
	 * Initializes source code file using its absolute path
	 * @param path
	 */
	public SourceCodeFile(String path)
	{
		file = new File(path);
		tokens = new LinkedList<Token>();
	}
	
	/**
	 * Returns the source code file
	 * @return source code file
	 */
	public File getFile()
	{
		return file;
	}
	
	public LinkedList<Token> getTokens()
	{
		return tokens;
	}
	
	/**
	 * Returns the absolute path of the source code file
	 * @return absolute path
	 */
	public String getPath()
	{
		return file.getAbsolutePath();
	}
	
	/*public Boolean isCppFile()
	{
		// needs to handle directory
		String str = scf.getPath().substring(scf.getPath().length()-3, scf.getPath().length());
		if(str.equals("cpp"))
			return true;
		else 
			return false;
	}*/
	
	/**
	 * Calculates total number of tokens in a source code file
	 * @return total number of tokens
	 */
	public int calculateTotalTokens() 
	{ 
		return tokens.size();
	}
	
	/**
	 * Create a list of tokens from the scanner
	 */
	// TODO Make this read in scf
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
