package edu.odu.cs.cs350;

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
	       
	      if ( tobechecked.isDirectory() == true )
	        
	        { 
                //remove from file ArrayList
	    	    File.remove(i);
	        }
	       
	      
	      }
        
    
   

    }

	public static void main(String[] args) {

		try{
			numRefactors = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e){
			System.out.println("First parameter must be an integer representing the number of refactors.");
		}

		for(int i = 1; i < args.length; i++){
			//Finds the source code files 
		}

		CommandLineProcessor clp = new CommandLineProcessor(numRefactors, fileList);

	}
	
}
