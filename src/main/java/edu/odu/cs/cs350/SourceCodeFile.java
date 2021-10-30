package edu.odu.cs.cs350;

import java.io.File;

/**
 * 
 * @author cs_vdulc001
 *
 */
public class SourceCodeFile {
	
	private File scf;
	
	/**
	 * Initializes source code file using its absolute path
	 * @param path
	 */
	public SourceCodeFile(String path)
	{
		scf = new File(path);
		isCppFile();
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
	 * @return absolute path of source code file
	 */
	public String getPath()
	{
		return scf.getAbsolutePath();
	}
	
	public Boolean isCppFile()
	{
		// needs to handle directory
		String str = scf.getPath().substring(scf.getPath().length()-3, scf.getPath().length());
		if(str.equals("cpp"))
			return true;
		else 
			return false;
	}
	
	/**
	 * Returns the total number of tokens in a file
	 * @return total number of tokens in a file
	 */
	public int tokenize() {return 0;}
	
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
		String output = "";
		if(scf.isDirectory())
		{
			File[] files = scf.listFiles();
			for(File file : files)
				output += file.getAbsolutePath() + ", " + tokenize() + "\n";
		}
		else
			output += getPath() + ", " + tokenize();
		return output;
	}
}
