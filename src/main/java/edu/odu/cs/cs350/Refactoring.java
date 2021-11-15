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

    public void setFileList(ArrayList<SourceCodeFile> list){
        fileList = list;
    }

    public ArrayList<SourceCodeFile> getFileList(){
        return fileList;
    }

    public void setNumRefactors(int num){
        numRefactors = num;
    }

    public int getNumRefactors(){
        return numRefactors;
    }

    public String printRefactoredtoString(){
        String output;
        output = "Files scanned: ";

        for(int i = 0; i < fileList.size(); i++){
            //5 is just an arbitrary number as placeholder for num refactors actually found
            output = output + fileList.get(i).getPath() + ", 5\n";
        }

        return output;
    }

    public void printRefactored(){
        System.out.println("Files scanned: ");
        for(int i = 0; i < fileList.size(); i++){
            //5 is just an arbitrary number as placeholder for num refactors actually found
            System.out.println(fileList.get(i).getPath() + ", 5");
        }
    }
}
