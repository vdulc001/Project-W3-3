package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;

public class TestRefactor {

    @Test
    void testMutators(){
<<<<<<< HEAD
        SourceCodeFile scf1 = new SourceCodeFile("src/test/data/test1.cpp");
        SourceCodeFile scf2 = new SourceCodeFile("src/test/data/test1.h");
        Token tok1 = new Token(TokenKinds.INT, 10, 5);
        Token tok2 = new Token(TokenKinds.IDENTIFIER, 10, 9);
        Token tok3 = new Token(TokenKinds.OPERATOR, 10, 11);
        Token tok4 = new Token(TokenKinds.INTEGER_LITERAL, 10, 13);
        Token tok5 = new Token(TokenKinds.SEMICOLON, 10, 14);
        LinkedList<Token> refactoredTokens = new LinkedList<Token>(Arrays.asList(tok1, tok2, tok3, tok4, tok5));
        ArrayList<SourceCodeFile> listOfFiles = new ArrayList<SourceCodeFile>(Arrays.asList(scf1));

        Refactoring refactor = new Refactoring(0, listOfFiles);

        refactor.setRefactoredTokens(refactoredTokens);
        assertEquals(refactor.getRefactoredTokens(), refactoredTokens);

        assertEquals(refactor.getNumRefactors(), 0);
        assertEquals(refactor.getSourceCodeFiles(), listOfFiles);

        refactor.addFiles(scf2);
        listOfFiles.add(scf2);
        assertEquals(refactor, listOfFiles);

        refactor.setNumRefactors(5);
        assertEquals(refactor.getNumRefactors(), 5);

=======
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
>>>>>>> e117d9b3b9e7e48b6b813c869f6c144fc61c8bcd
    }

    /*
    @Test
<<<<<<< HEAD
    void testSingleRefactoringFound(){
        SourceCodeFile scf1 = new SourceCodeFile("src/test/data/test2.cpp");
        ArrayList<SourceCodeFile> listOfFiles = new ArrayList<SourceCodeFile>();
        Refactoring refactor = new Refactoring(10, listOfFiles);

        Token tok1 = new Token(TokenKinds.INT, 10, 5);
        Token tok2 = new Token(TokenKinds.IDENTIFIER, 10, 9);
        Token tok3 = new Token(TokenKinds.OPERATOR, 10, 11);
        Token tok4 = new Token(TokenKinds.INTEGER_LITERAL, 10, 13);
        Token tok5 = new Token(TokenKinds.SEMICOLON, 10, 14);
        LinkedList<Token> refactoredTokens = new LinkedList<Token>(Arrays.asList(tok1, tok2, tok3, tok4, tok5));

        refactor.setRefactoredTokens(refactoredTokens);

        assertEquals(refactor.printRefactoredToString(),
                        "Opportunity 24, 8 tokens\n" +
                        scf1.getPath() + ":" + tok1.getLine() + ":" + tok1.getColumn() + "\na 4\n" +
                        scf1.getPath() + ":" + tok2.getLine() + ":" + tok2.getColumn() + "\nb 5\n" +
                        scf1.getPath() + ":" + tok3.getLine() + ":" + tok3.getColumn() + "\nc 3\n" +
                        scf1.getPath() + ":" + tok4.getLine() + ":" + tok4.getColumn() + "\nd 8\n");
=======
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
>>>>>>> e117d9b3b9e7e48b6b813c869f6c144fc61c8bcd
    }
    */
    
    @Test
    void testMultipleRefactoringsFound(){

    }
}
