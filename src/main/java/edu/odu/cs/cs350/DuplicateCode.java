package edu.odu.cs.cs350;
import java.io.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;




public class DuplicateCode{

	
private String fileoutput = "filename";
private int line = 0;
private int column = 0;

public int getLine() { return line; }
//public int setLine(int L) { line = L; }


public int getColumn() {return column;}
public void setColumn(int z) {  column = z; }

public String getFilename() {return fileoutput;}
public void setFilename(String name2output) { fileoutput = name2output;}

public void findneardups() {
 //make copy of array list of files//
  //  ArrayList<SourceCodeFile> Test = CommandLineProcessor.getFileList();
 //Tokenize the file//
    
	
}


public void outputND(String[] args) {
	System.out.print(fileoutput +":" + line +":" + column);
}








	
	
}