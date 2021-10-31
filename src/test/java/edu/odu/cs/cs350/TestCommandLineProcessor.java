package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;

public class TestCommandLineProcessor {

    @Test
    void testConstructor(){
        SourceCodeFile file1 = new SourceCodeFile("foo.cpp");
        SourceCodeFile file2 = new SourceCodeFile("foo.h");
        SourceCodeFile file3 = new SourceCodeFile("bar.cpp");
        SourceCodeFile file4 = new SourceCodeFile("main.cpp");


        /* to be implemented
            TestCommandLineProcessor.main(new String[]{4, file1, file2, file3, file4});
        */
    }
    
    
}
