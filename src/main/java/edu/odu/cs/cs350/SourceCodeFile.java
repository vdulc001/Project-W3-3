package edu.odu.cs.cs350;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.StringReader;



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
		tokens = new ArrayList<Token>();
		try {
            tokens = tokenize();
            }
        catch (Exception ex) {
            // Not necessarily a problem, depending on the input source
        }
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
	
	/*public void printNumTokens(LinkedList<Token> toks){
        System.out.println("This file has: " + toks.size() + " tokens.");
    }*/
	
	/**
	 * Converts the string content of the file to Reader
	 * @return Reader input
	 */
	public Reader getInput (String path) throws Exception{
		String content = Files.readString(Paths.get(path));
		Reader input = new StringReader(content);
		return input;
	}
	
	/**
	 * Create a list of tokens from the scanner
	 */
	public ArrayList<Token> tokenize() throws Exception{
		String content = Files.readString(Paths.get(getPath()));
		Reader input = new StringReader(content);
		TokenStream tokenstream = new TokenStream(input);
        for (Token tok: tokenstream) {
            tokens.add(tok);
        }
        return tokens;
	}
}