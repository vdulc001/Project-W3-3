package edu.odu.cs.cs350;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestRefactoring {
    
    @Test
    void testOutput(){
        SourceCodeFile s1 = new SourceCodeFile("src/test/resources/test1.txt");
        SourceCodeFile s2 = new SourceCodeFile("src/test/resources/test2.txt");

        ArrayList<SourceCodeFile> list = new ArrayList<SourceCodeFile>();
        list.add(s1);
        list.add(s2);

        int numRefactors = 5;

        Refactoring refactor = new Refactoring(10, list);

        assertNotNull(refactor.getFileList());

        //assertThat(refactor.printRefactored(), is(s1.toString() + "5\n" + s2.toString() + "5\n"));
    }
}
