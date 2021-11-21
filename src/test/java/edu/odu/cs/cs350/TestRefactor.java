package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;

public class TestRefactor {

    @Test
    void testMutators(){
        SourceCodeFile scf1 = new SourceCodeFile("test1.cpp");
        SourceCodeFile scf2 = new SourceCodeFile("test1.h");
        ArrayList<SourceCodeFile> listOfFiles = new ArrayList<SourceCodeFile>();

        listOfFiles.add(scf1);
        Refactoring refactor = new Refactoring(0, listOfFiles);

        assertNotNull(refactor.getFiles());
        assertEquals(refactor.getFiles(), listOfFiles);

        listOfFiles.add(scf2);
        refactor.addFile(scf2);
        assertNotNull(refactor.getFiles());
        assertEquals(refactor.getFiles(), listOfFiles);


        assertEquals(refactor.getnSuggestions(), 0);

        refactor.setnSuggestions(5);
        assertEquals(refactor.getnSuggestions(), 5);
    }

    /*
    @Test
    void testDuplicateCodefound() throws Exception{
        ArrayList<SourceCodeFile> listOfFiles = new ArrayList<SourceCodeFile>();
        SourceCodeFile scf = new SourceCodeFile("src/test/data/test1.cpp");
        listOfFiles.add(scf);
        Refactoring refactor = new Refactoring(0, listOfFiles);

        assertEquals(refactor.getNumRefactors(), 0);

        refactor.findRefactored();
        assertNotEquals(refactor.getNumRefactors(), 0);

        LinkedList<Token> duplicateCode = new LinkedList<Token>();
        Token tok1 = new Token(TokenKinds.INT, 11, 5);
        Token tok2 = new Token(TokenKinds.IDENTIFIER, 11, 9);
        Token tok3 = new Token(TokenKinds.OPERATOR, 11, 11);
        Token tok4 = new Token(TokenKinds.INTEGER_LITERAL, 11, 13);
        duplicateCode.add(tok1);
        duplicateCode.add(tok2);
        duplicateCode.add(tok3);
        duplicateCode.add(tok4);

        assertEquals(refactor.getRefactoredOpportunities(), duplicateCode);
    }
    */
    
}
