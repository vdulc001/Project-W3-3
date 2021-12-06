package edu.odu.cs.cs350;

import java.io.File;
import java.io.Reader;
<<<<<<< HEAD
import java.util.LinkedList;
import java.io.IOException;
=======
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.StringReader;

>>>>>>> branch 'main' of git@github.com:vdulc001/Project-W3-3.git

/**
 * 
 * @author cs_vdulc001
 * @author cs_jrosa005
 *
 */
public class SourceCodeFile {
	
	private File file;
	private ArrayList<Token> tokens;
	
	/**
	 * Initializes source code file using its absolute path
	 * @param path
	 */
	public SourceCodeFile(final String path)
	{
		file = new File(path);
<<<<<<< HEAD
		tokens = new LinkedList<Token>();
=======
		tokens = new ArrayList<Token>();
		try {
            tokens = tokenize();
            }
        catch (Exception ex) {
            // Not necessarily a problem, depending on the input source
        }
>>>>>>> branch 'main' of git@github.com:vdulc001/Project-W3-3.git
	}
	
	/**
	 * Returns the source code file
	 * @return source code file
	 */
	public File getFile()
	{
		return file;
	}
	
	public ArrayList<Token> getTokens()
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
	public int getTotalTokens() 
	{ 
		return tokens.size();
	}
	
	/**
	 * Create a list of tokens from the scanner
	 */
<<<<<<< HEAD
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
=======
	public ArrayList<Token> tokenize() throws Exception{
		String content = Files.readString(Paths.get(getPath()));
		Reader input = new StringReader(content);
		TokenStream tokenstream = new TokenStream(input);
        for (Token tok: tokenstream) {
            tokens.add(tok);
>>>>>>> branch 'main' of git@github.com:vdulc001/Project-W3-3.git
        }
        return tokens;
	}
}