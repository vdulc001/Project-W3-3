package edu.odu.cs.cs350;

import edu.odu.cs.cs350.*;


import java.io.File;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import java.io.*;



public class DuplicateCode{

File currentFile;
ArrayList<Token> Test

public void SetCurrentfile()
{
	SourceCodeFile.getFile();
}



public void SetArray()
{
  Test = SourceCodeFile.getTokens();
}

public DetectSimilarTokens() {
  SharedPhrases phrases = new SharedPhrases();
 String filename =  file(currentfile).getname;
  //Loop through List//
 for(i = 0; i < Test.size(); i++)
 {
	 Token = Test.(i);
	//Build Suffix Tree//
	phrases.addSentence(Token, filename); 
 }
 for (Token p: Tokens.Test()) {
	   System.out.print (p + ":");
	   for (String source: tokens.sourcesOf(p)) {
	       System.out.print (" " + source);
	   } 
	   System.out.println();
	}

  
}






	
	
}