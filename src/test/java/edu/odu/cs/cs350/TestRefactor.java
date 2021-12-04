package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;

public class TestRefactor {

    SourceCodeFile scf1 = new SourceCodeFile("src/test/data/test1.cpp");
    SourceCodeFile scf2 = new SourceCodeFile("src/test/data/test1.h");
    SourceCodeFile scf3 = new SourceCodeFile("src/test/data/test2.cpp");
    ArrayList<SourceCodeFile> listOfFiles = new ArrayList<SourceCodeFile>();

    @Test
    void testMutators(){
        listOfFiles.add(scf3);

        Refactoring refactor = new Refactoring(0, listOfFiles);

        assertEquals(refactor.getNumRefactors(), 0);
        assertEquals(refactor.getSourceCodeFiles(), listOfFiles);


        refactor.addFiles(scf2);
        listOfFiles.add(scf2);
        assertEquals(refactor.getSourceCodeFiles(), listOfFiles);

        refactor.setNumRefactors(5);
        assertEquals(refactor.getNumRefactors(), 5);
    }

    @Test
    void testSingleRefactoringFound(){
        listOfFiles.add(scf3);
        Refactoring refactor = new Refactoring(10, listOfFiles);


        /*
        assertEquals(refactor.printRefactoredToString(),
                        "Opportunity 24, 8 tokens\n" +
                        scf1.getPath() + ":" + tok1.getLine() + ":" + tok1.getColumn() + "\na 4\n" +
                        scf1.getPath() + ":" + tok2.getLine() + ":" + tok2.getColumn() + "\nb 5\n" +
                        scf1.getPath() + ":" + tok3.getLine() + ":" + tok3.getColumn() + "\nc 3\n" +
                        scf1.getPath() + ":" + tok4.getLine() + ":" + tok4.getColumn() + "\nd 8\n");
                        */
    }
    
    /*
    @Test
    void testMultipleRefactoringsFound(){

    }

    
    SourceCodeFile scf = new SourceCodeFile ("/storage/emulated/0");
    Refactoring rf = new Refactoring (8, scf);

    @Test public void findRefactored (){
        rf.findRefactored ();
        LinkedList < Token > rop = rf.getRefactoredOpportunities ();
        assertEquals (false, rop.isEmpty ());
    }
    
        @Test public void testDupFinder ()
    {
        List < String > list = new ArrayList < String > ();
        List < String > duplicates = new ArrayList < String > ();
        File directory = new File ("/");
        rf.Dup_finder (list, duplicates, directory);
    
        assertEquals (true, duplicates.isEmpty ());
    }
    */
}

