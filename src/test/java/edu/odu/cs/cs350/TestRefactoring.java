package edu.odu.cs.cs350;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;

public class TestRefactoring {

    @Test
    void testRefactor(){
        int numRefactors = 10;
        SourceCodeFile s1 = new SourceCodeFile("src/test/resources/test1.cpp");
        SourceCodeFile s2 = new SourceCodeFile("src/test/resources/test1.h");
        ArrayList<SourceCodeFile> list = new ArrayList<SourceCodeFile>();

        Refactoring emptyRefactor = new Refactoring();
        Refactoring refactor = new Refactoring(numRefactors, list);

        assertEquals(emptyRefactor.getNumRefactors(), 0);
        assertEquals(emptyRefactor.getFileList(), new ArrayList<SourceCodeFile>());

        list.add(s1);

        assertEquals(refactor.getNumRefactors(), 10);
        assertEquals(refactor.getFileList(), list);

        list.add(s2);
        refactor.setFileList(list);
        assertEquals(refactor.getFileList(), list);

        refactor.setNumRefactors(15);
        assertEquals(refactor.getNumRefactors(), 15);
    }
    
    @Test
    void testOutput(){
        int numRefactors = 10;
        SourceCodeFile s1 = new SourceCodeFile("src/test/resources/test1.cpp");
        SourceCodeFile s2 = new SourceCodeFile("src/test/resources/test1.h");
        ArrayList<SourceCodeFile> list = new ArrayList<SourceCodeFile>();
        list.add(s1);
        list.add(s2);

        Refactoring refactor = new Refactoring(numRefactors, list);

        assertEquals(refactor.printRefactoredtoString(), "Files scanned: " + s1.toString() + "5\n" + s2.toString() + "5\n");
    }
}
