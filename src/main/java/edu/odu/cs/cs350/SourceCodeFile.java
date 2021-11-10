package edu.odu.cs.cs350;

import java.io.File;

/**
 * 
 * @author cs_vdulc001
 *
 */
public class SourceCodeFile {
	
	private File scf;
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
		return numberOfTokens; 
	}
	
	
	/**
	 * Calulates total number of tokens in a source code file
	 * @return total number of tokens
	 */
	public int calculateTotalTokens() { return 0; };
	
	/**
	 * Converts code into sequence of tokens?
	 */
	public void tokenize() {}
	
	
	
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
