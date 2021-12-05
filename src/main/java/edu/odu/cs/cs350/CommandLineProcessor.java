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
	private static ArrayList<Token> testSequence = new ArrayList<Token>();

	public CommandLineProcessor(int num, ArrayList<SourceCodeFile> list){
		nSuggestions = num;
		filesList = list;
	}
	
	public void setnSuggestions(int num){
		nSuggestions = num;
	}

	public int getnSuggestions(){
		return nSuggestions;
	}

	public ArrayList<SourceCodeFile> getFileList(){
		return filesList;
	}

    public void findCppFiles() {}

	public static void main(String[] args) {
		
		nSuggestions = Integer.parseInt(args[0]);
		readInSourceCodeFiles(args);
		findFilesInNestedDirectories();
		printListOfSourceCodeFiles();
		
		System.out.println();
		
		// for visible output comment out if needed
		Refactoring refactoring = new Refactoring();
		int i;
		for(i = 0; i < nSuggestions && i < filesList.size(); i++)
		{
			//if(filesList.get(i).getFile().length() != 0) // make sure files are not empty
				//System.out.println(refactoring.refactoringOutput(filesList.get(i)));
		}
		
		System.out.println("Printed " + i + " of " + filesList.size() + " suggestions.");
		
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
			System.out.println(scf.getPath() + ", " + scf.getTotalTokens());
	}
	
	public static void createTestSequence(SourceCodeFile file)
	{
		for(int i = 0; i < file.getTotalTokens(); i++)
		{
			if(file.getTokens().get(i).getTokenType() == TokenKinds.SEMICOLON)
			{
				testSequence.add(file.getTokens().get(i));
				break;
			}
			else
				testSequence.add(file.getTokens().get(i));
		}
	}
	
	public static void refactor(Refactoring r) 
	{
		int i;
		for(i = 0; i < nSuggestions && i < filesList.size(); i++)
		{
			r.findDupSequences(testSequence, filesList.get(i));
			r.refactoringOutput(testSequence, filesList.get(i));
			r.getSuggestions().clear();
			System.out.println();
		}
		System.out.println("Printed " + i + " of " + nSuggestions + " suggestions");
	}
}