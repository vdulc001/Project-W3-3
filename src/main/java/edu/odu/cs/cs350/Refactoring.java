package edu.odu.cs.cs350;

import java.util.ArrayList;

public class Refactoring {

    private int numRefactors;
    private static ArrayList<SourceCodeFile> fileList = new ArrayList<SourceCodeFile>();

    public Refactoring(){
        numRefactors = 0;
    }

    public Refactoring(int num, ArrayList<SourceCodeFile> list){
        fileList = list;
        numRefactors = num;
    }

    public ArrayList<SourceCodeFile> getFileList(){
        return fileList;
    }

    public void printRefactored(){
        System.out.println("Files scanned:");
        for(int i = 0; i < numRefactors; i++){
            System.out.println(fileList.get(0).toString() + "5");
        }
    }
}
