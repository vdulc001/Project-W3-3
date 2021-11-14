package edu.odu.cs.cs350;
import java.io.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;




public class DuplicateCode{

	
private String filename = "filename";
private String FilePath = "testpath";
private int line = 0;
private int column = 0;


//Creates a new object of dup code to hold variables)
public void CreateDupCode(int L, int C, String filename) {
	line = L;
	column = C;
	filename = filename;
	FilePath = "testPath";
}



//Changes the file name into path//
public void filenameintopath() {
	File file = new File(filename);
	String filepath = file.getAbsolutePath();
	FilePath = filepath;
	
}

public String getfilepath() {return FilePath;}


public int getLine() { return line; }
public void setLine(int L) { line = L; }


public int getColumn() {return column;}
public void setColumn(int z) {  column = z; }

public String getFilename() {return filename;}
public void setFilename(String name2output) { filename = name2output;}

public void findneardups() {
 //make copy of array list of files//
  //  ArrayList<SourceCodeFile> Test = CommandLineProcessor.getFileList();
 //Tokenize the file//
    
	
}

public void outputND(String[] args) {
	System.out.print(FilePath +":" + line +":" + column);
}








	
	
}