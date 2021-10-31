package edu.odu.cs.cs350;


import java.io.File;
import java.util.ArrayList;
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

	/**
	 * Construct a CLP object with number of refactors and list of source code files
	 * @param num - number of refactors
	 * @param list - list of source code files
	 */
	public CommandLineProcessor(int num, ArrayList<SourceCodeFile> list){
		numRefactors = num;
		fileList = list;
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

    }
    
    /**
     * Checks to Ensure All Inputted Files and Directories Exist
     *
     */
    public void CheckFileExists() {
    	//Source: https://chortle.ccsu.edu/java5/Notes/chap87/ch87_4.html//
    	   boolean fileexists;
    	    String temp;
    	    ArrayList<SourceCodeFile> TempArray = new ArrayList<SourceCodeFile>();
    	   	
    	    //Create Temp Array clone of fileList//
    	   	TempArray = (ArrayList)fileList.clone();
    	        
    	   	int numoffiles =  fileList.size();
    	    
    	    for (int i = 0; i < fileList.size(); i++)
    	      {
    	    	//Change Object into String//
    	        temp = TempArray.get(i).toString();
    	       
    	       //Check if file exists//
    	       File tobechecked = new File(temp);
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
    	//CheckFileExists();
    	String TempName;
    	//Clone ArrayList to keep track of Files vs Directories//
    	ArrayList<SourceCodeFile> File = (ArrayList)fileList.clone();
    	ArrayList<SourceCodeFile> Directories = (ArrayList)fileList.clone();
        
    	int numoffiles = fileList.size();
        boolean isdirectory;
        boolean isfolder;
        
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
	       
	       else  if ( tobechecked.isDirectory() == true )
	        
	        { 
                //remove from file ArrayList
	    	    File.remove(i);
	        }
	       
	      
	   
	      
	  }
        
    
   

    }

	public static void main(String[] args) {
		String firstFile = args[1];
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

		CommandLineProcessor clp = new CommandLineProcessor(numRefactors, fileList);

	}
	
}
