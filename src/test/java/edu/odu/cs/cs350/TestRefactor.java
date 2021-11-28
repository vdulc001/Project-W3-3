package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;

public class TestRefactor {

    @Test
    void testMutators(){
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

    }

    @Test
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
    }
    
    @Test
    void testMultipleRefactoringsFound(){

    }
}
