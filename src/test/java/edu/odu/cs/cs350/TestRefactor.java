package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedList;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;

public class TestRefactor {

    @Test
    void testMutators(){
        SourceCodeFile scf1 = new SourceCodeFile("test1.cpp");
        SourceCodeFile scf2 = new SourceCodeFile("test1.h");
        Refactoring refactor = new Refactoring(0, scf1);

        assertNotNull(refactor.getFile());
        assertEquals(refactor.getFile(), scf1);

        refactor.setFile(scf2);
        assertNotNull(refactor.getFile());
        assertEquals(refactor.getFile(), scf2);


        assertEquals(refactor.getMaxNumRefactors(), 0);

        refactor.setMaxNumRefactors(5);
        assertEquals(refactor.getMaxNumRefactors(), 5);
    }

    @Test
    void testDuplicateCodefound() throws Exception{
        SourceCodeFile scf = new SourceCodeFile("src/test/data/test1.cpp");
        Refactoring refactor = new Refactoring(0, scf);

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
    
}
