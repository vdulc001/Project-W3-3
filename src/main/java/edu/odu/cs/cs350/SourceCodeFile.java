package edu.odu.cs.cs350;

public class SourceCodeFile {
	
	/**
	 * The path to a file or directory containing C++ source code
	 */
	private String path;
	
	/**
	 * Create a source code file
	 * @param path
	 */
	public SourceCodeFile(String path)
	{
		this.path = path;
	}
	
	/**
	 * Returns the path of the file or directory
	 * @return the path of the file or directory
	 */
	public String getPath()
	{
		return path;
	}
	
	/**
	 * Changes path to path of new file or directory
	 * @param path
	 */
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public boolean equals(SourceCodeFile other)
	{
		if(path.equals(other.path))
			return true;
		else
			return false;
	}
	
	/**
	 * Returns formatted path to file or directory
	 */
	public String toString()
	{
		return "Path to file/directory: " + path;
	}
	
}
