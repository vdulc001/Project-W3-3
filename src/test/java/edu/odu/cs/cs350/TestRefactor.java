package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;

public class TestRefactor {

    SourceCodeFile scf1 = new SourceCodeFile("src/test/data/test1.cpp");
    SourceCodeFile scf2 = new SourceCodeFile("src/test/data/test1.h");
    SourceCodeFile scf3 = new SourceCodeFile("src/test/data/test2.cpp");
    ArrayList<SourceCodeFile> listOfFiles = new ArrayList<SourceCodeFile>();
	private static ArrayList<Token> testSequence = new ArrayList<Token>();

    @Test
    void testMutators(){
        Token tok1 = new Token(TokenKinds.INT, 10, 5);
        Token tok2 = new Token(TokenKinds.IDENTIFIER, 10, 9);
        Token tok3 = new Token(TokenKinds.OPERATOR, 10, 11);
        Token tok4 = new Token(TokenKinds.INTEGER_LITERAL, 10, 13);
        Token tok5 = new Token(TokenKinds.SEMICOLON, 10, 14);
        LinkedList<Token> tokenSequence = new LinkedList<Token>(Arrays.asList(tok1, tok2, tok3, tok4, tok5));
        LinkedList<String> refactoredTokens = new LinkedList<String>();
        listOfFiles.add(scf3);

        //Refactoring refactor = new Refactoring(0, listOfFiles, tokenSequence);

        //assertEquals(refactor.getTokenSequence(), tokenSequence);

        //refactor.setRefactoredTokens(refactoredTokens);
        //assertEquals(refactor.getRefactoredTokens(), refactoredTokens);

        //assertEquals(refactor.getNumRefactors(), 0);
        //assertEquals(refactor.getSourceCodeFiles(), listOfFiles);


        //refactor.addFiles(scf2);
        listOfFiles.add(scf2);
        //assertEquals(refactor.getSourceCodeFiles(), listOfFiles);

        //refactor.setNumRefactors(5);
        //assertEquals(refactor.getNumRefactors(), 5);
    }

    @Test
    void testSingleRefactoringFound(){
        listOfFiles.add(scf3);
        Token tok1 = new Token(TokenKinds.INT, 10, 5);
        Token tok2 = new Token(TokenKinds.IDENTIFIER, 10, 9);
        Token tok3 = new Token(TokenKinds.OPERATOR, 10, 11);
        Token tok4 = new Token(TokenKinds.INTEGER_LITERAL, 10, 13);
        Token tok5 = new Token(TokenKinds.SEMICOLON, 10, 14);
        LinkedList<Token> tokenSequence = new LinkedList<Token>(Arrays.asList(tok1, tok2, tok3, tok4, tok5));
        /*Refactoring refactor = new Refactoring(10, listOfFiles, tokenSequence);

        assertEquals(refactor.getTokenSequence(), tokenSequence);

        assertEquals(refactor.printRefactoredToString(),
                        "Opportunity 24, 8 tokens\n" +
                        scf1.getPath() + ":" + tok1.getLine() + ":" + tok1.getColumn() + "\na 4\n" +
                        scf1.getPath() + ":" + tok2.getLine() + ":" + tok2.getColumn() + "\nb 5\n" +
                        scf1.getPath() + ":" + tok3.getLine() + ":" + tok3.getColumn() + "\nc 3\n" +
                        scf1.getPath() + ":" + tok4.getLine() + ":" + tok4.getColumn() + "\nd 8\n");*/
    }
    
    @Test
    void testOutput(){
        Refactoring refactor = new Refactoring();

        Token tok1 = new Token(TokenKinds.INT, 10, 5);
        Token tok2 = new Token(TokenKinds.IDENTIFIER, 10, 9);
        Token tok3 = new Token(TokenKinds.OPERATOR, 10, 11);
        Token tok4 = new Token(TokenKinds.INTEGER_LITERAL, 10, 13);

        Token tok6 = new Token(TokenKinds.SEMICOLON, 10, 14);
        Token tok7 = new Token(TokenKinds.SEMICOLON, 10, 14);

        assertEquals(refactor.refactoringOutputToString(testSequence, scf3),
                        "Opportunity 24, 8 tokens\n" +
                        scf3.getPath() + ":" + tok1.getLine() + ":" + tok1.getColumn() + "\na 4\n" +
                        scf3.getPath() + ":" + tok2.getLine() + ":" + tok2.getColumn() + "\nb 5\n" +
                        scf3.getPath() + ":" + tok3.getLine() + ":" + tok3.getColumn() + "\nc 3\n" +
                        scf3.getPath() + ":" + tok4.getLine() + ":" + tok4.getColumn() + "\nd 8\n");

        assertEquals(refactor.refactoringOutputToString(testSequence, scf1),
                        "Opportunity 12, 6 tokens\n" +
                        scf1.getPath() + ":" + tok6.getLine() + ":" + tok6.getColumn() + "\nx a b\n" +
                        scf1.getPath() + ":" + tok7.getLine() + ":" + tok7.getColumn() + "\ny c d\n");
    }
    
    @Test
    void testOpportunityForImprovement()
    {
    	SourceCodeFile scf = new SourceCodeFile("src/test/data/test3.cpp");
    	CommandLineProcessor clp = new CommandLineProcessor();
    	CommandLineProcessor.createTestSequence(scf);
    	
    	Refactoring r = new Refactoring();
    	r.findDupSequences(clp.getTestSequence(), scf);
    	
    	assertEquals(r.getOpportunityForImprovement(clp.getTestSequence()), 20);
    }

    SourceCodeFile scf = new SourceCodeFile ("/storage/emulated/0");
    //Refactoring rf = new Refactoring (8, scf);

    @Test public void findRefactored (){
        //rf.findRefactored ();
        //LinkedList < Token > rop = rf.getRefactoredOpportunities ();
        //assertEquals (false, rop.isEmpty ());
    }
    
    @Test public void testDupFinder (){
        List < String > list = new ArrayList < String > ();
        List < String > duplicates = new ArrayList < String > ();
        File directory = new File ("/");
        //rf.Dup_finder (list, duplicates, directory);
    
        assertEquals (true, duplicates.isEmpty ());
    }
}

