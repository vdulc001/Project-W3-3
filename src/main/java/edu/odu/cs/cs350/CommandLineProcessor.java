package edu.odu.cs.cs350;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

/**
 * 
 * @author cs_cdiaz014
 * @author cs_cjack
 * 
 */
public class CommandLineProcessor {

    private static int numRefactors;
    private static ArrayList<SourceCodeFile> fileList = new ArrayList<SourceCodeFile>();
	private static ArrayList<SourceCodeFile> Directories = (ArrayList)fileList.clone();

	/**
	 * Construct a CLP object with number of refactors and list of source code files
	 * @param num - number of refactors
	 * @param list - list of source code files
	 */
	public CommandLineProcessor(int num, ArrayList<SourceCodeFile> list){
		numRefactors = num;
		fileList = list;
	}
	
	public void setNumRefactors(int num){
		numRefactors = num;
	}

	/**
	 * @return number of refactors the user desires
	 */
	public int getNumRefactors(){
		return numRefactors;
	}

	/**
	 * @return the list of C++ files found by the program;
	 * 			includes files inputted by the user in the CLI
	 * 			and files found in subdirectors by the program
	 */
	public ArrayList<SourceCodeFile> getFileList(){
		return fileList;
	}

    /**
	 * Finds C++ files through every directory/subdirectory
	 * to be implemented later
	 */
    public void findCppFiles(){
    	//Which File Names to look for, for now until we properties set up//
    	
    	
    	
    	
    	for (int i = 0; i < fileList.size(); i++)
    	 {
    		//needs ini file to know which c++ types to look for and get// 
    	 }
    	
    	
    	

    }
    
    /**
     * Checks to Ensure All Inputted Files and Directories Exist
     *
     */
    public void CheckFileExists() {
    	//Source: https://chortle.ccsu.edu/java5/Notes/chap87/ch87_4.html//
    	   boolean fileexists;
    	    String tempFilePath;
    	    ArrayList<SourceCodeFile> TempArray = new ArrayList<SourceCodeFile>();
    	   	
    	    //Create Temp Array clone of fileList//
    	   	TempArray = (ArrayList)fileList.clone();
    	        
    	   	int numoffiles =  fileList.size();
    	    
    	    for (int i = 0; i < fileList.size(); i++)
    	      {
    	    	//Change Object into String//
    	        tempFilePath = TempArray.get(i).toString();
    	       
    	       //Check if file exists//
    	       File tobechecked = new File(tempFilePath);
    	     if ( tobechecked.exists() == true )
    	     {
    	    	  //File Exists Continue//
    	    	 continue;
    	     }
    	    else {
    	    	   //if file does not exists - remove file//
    	    	  fileList.remove(i);
    	         } 
    	     
    	       }    	
    	
    }

    /**
	 * Finds input files provided by the user in the CLI
	 * story card 5
	 */
    public void findInputFiles(){
    	//Check if files even exists//
    	CheckFileExists();
    	String TempName;
    	
    	//Clone ArrayList to keep track of Files vs Directories//
    	ArrayList<SourceCodeFile> File = (ArrayList)fileList.clone();
    	ArrayList<SourceCodeFile> Temp = new ArrayList<SourceCodeFile>();
    	
        boolean isdirectory;
        boolean isfolder;
        //paths to files containing C++ source code or directories containing C++ source code//
        //Is file a directory or a folder 
        for (int i = 0; i < fileList.size(); i++)
	      {
        	//get fileList Object and turn into string// 
	       TempName = fileList.get(i).toString();
	       
	       //turn into file//
	       File tobechecked = new File(TempName);
	     
	       if ( tobechecked.isFile() == true )
	      {
	    	  //remove from directory ArrayList
	    	   Directories.remove(i);
	       }
	       
	       else if ( tobechecked.isDirectory() == true )
	        
	        { 
                //remove from file ArrayList
	    	    File.remove(i);   
	        }
	       
	      
	      }//Loop End//
          
        //Find Files in File Array and change Paths to files//
       String pathname;
    
         for (int i = 0; i < File.size(); i++) 
         {
        	pathname = File.get(i).toString();
        	
        	//Create file using SourceCode//
        	 SourceCodeFile tobeadded = new SourceCodeFile(pathname);
        	 
        	 //to SourceFile to Temp Array of Source Files//
        	 Temp.add(tobeadded);
        	 
        	 
         }
        	         
       //Find Files in Directories Array and change Search Recursively to find to files//
       //Find Cpp file must be implemented to properly search directories//	  
    
   

    }

	public static void main(String[] args) {
		// for visible output
		ArrayList<SourceCodeFile> fileList = new ArrayList<SourceCodeFile>();
		for(String filePath : args)
		{
			File file = new File(filePath);
			if(file.exists())
				if(file.isDirectory())
				{
					ArrayList<String> pathsToDirectories = new ArrayList<String>();
					searchForDirectories(file.listFiles(), 0, pathsToDirectories);
					for(String name : pathsToDirectories)
						fileList.add(new SourceCodeFile(name));
				}
				else
					fileList.add(new SourceCodeFile(file.getAbsolutePath()));
		}
		
		System.out.println("Files Scanned: ");
		Collections.sort(fileList, Comparator.comparing(SourceCodeFile::getPath));
		for(SourceCodeFile scf : fileList)
			System.out.println(scf.getPath() + ", " + scf.calculateTotalTokens());

		/*String firstFile = args[1];
		int startFileParameters = 1;

		try{
			numRefactors = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e){
			System.out.println("First parameter must be an integer representing the number of refactors.");
		}
		
		//Find if there is a .ini file or not
		if(firstFile.substring(firstFile.length() - 4) == ".ini"){
			startFileParameters = 2;
		}

		//To be implemented
		for(int i = startFileParameters; i < args.length; i++){
		}

		CommandLineProcessor clp = new CommandLineProcessor(numRefactors, fileList);*/
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
}
