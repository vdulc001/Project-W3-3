package edu.odu.cs.cs350;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author cs_cdiaz014
 * @author cs_cjack
 * @author cs_vdulc001
 * 
 */
public class CommandLineProcessor {

    private static int nSuggestions;
    private static ArrayList<SourceCodeFile> filesList = new ArrayList<SourceCodeFile>();
	private static ArrayList<SourceCodeFile> directoriesList = (ArrayList)filesList.clone();

	/**
	 * Construct a CLP object with number of refactoring suggestions and list of source code files
	 * @param num - number of refactoring suggestions
	 * @param list - list of source code files
	 */
	public CommandLineProcessor(int num, ArrayList<SourceCodeFile> list){
		nSuggestions = num;
		filesList = list;
	}
	
	public void setnSuggestions(int num){
		nSuggestions = num;
	}

	/**
	 * @return number of refactoring suggestions the user desires
	 */
	public int getnSuggestions(){
		return nSuggestions;
	}

	/**
	 * @return the list of C++ files found by the program;
	 * 			includes files inputted by the user in the CLI
	 * 			and files found in subdirectories by the program
	 */
	public ArrayList<SourceCodeFile> getFileList(){
		return filesList;
	}

    /**
	 * TODO Finds C++ files in every directory and subdirectory
	 */
    public void findCppFiles() {}

	public static void main(String[] args) {
		
		nSuggestions = Integer.parseInt(args[0]);
		readInSourceCodeFiles(args);
		findFilesInNestedDirectories();
		printListOfSourceCodeFiles();
		
	}
	
	public static void readInSourceCodeFiles(String[] args)
	{
		for(String path : args)
		{
			SourceCodeFile scf = new SourceCodeFile(path);
			if(scf.getFile().exists())
			{
				if(scf.getFile().isDirectory())
					directoriesList.add(scf);
				else
					filesList.add(scf);
			}
		}
	}
	
	public static void findFilesInNestedDirectories()
	{
		ArrayList<String> pathsToDirectories = new ArrayList<String>();
		for(SourceCodeFile dir : directoriesList)
		{
			searchForDirectories(dir.getFile().listFiles(), 0, pathsToDirectories);
			for(String path : pathsToDirectories)
				filesList.add(new SourceCodeFile(path));
		}
	}
	
	public static void searchForDirectories(File[] files, int index, ArrayList<String> pathsToDirectories)
	{
		if(index == files.length)
			return ;
		
		if(files[index].isFile())
			pathsToDirectories.add(files[index].getAbsolutePath());
		else if(files[index].isDirectory())
			searchForDirectories(files[index].listFiles(), 0, pathsToDirectories);
		
		searchForDirectories(files,++index, pathsToDirectories);
	}
	

	public static void printListOfSourceCodeFiles()
	{
		System.out.println("Files Scanned: ");
		Collections.sort(filesList, Comparator.comparing(SourceCodeFile::getPath));
		for(SourceCodeFile scf : filesList)
			System.out.println(scf.getPath() + ", " + scf.calculateTotalTokens());
	}

}