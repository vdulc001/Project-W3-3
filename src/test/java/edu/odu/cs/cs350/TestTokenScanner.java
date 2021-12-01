package edu.odu.cs.cs350;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTokenScanner {

	@BeforeAll
    public static void setUp() throws Exception {
    }

	@Test
    public final void testScanner() throws Exception{
		SourceCodeFile s = new SourceCodeFile("src/test/data/test1.cpp");
        LinkedList<Token> tokens = s.getTokens();
        LinkedList<Token> testTokens = new LinkedList<Token>();
        for (Token tok: tokens) {
        	testTokens.add(tok);
        }
        
        assertEquals (72, s.calculateTotalTokens());
        
        Token t = tokens.get(1);
        assertEquals (TokenKinds.PREPROCESSOR, t.getTokenType());
        assertEquals ("#include", t.getLexeme());
        assertEquals (1, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = tokens.get(5);
        assertEquals (TokenKinds.USING, t.getTokenType());
        assertEquals ("using", t.getLexeme());
        assertEquals (3, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = tokens.get(9);
        assertEquals (TokenKinds.INT, t.getTokenType());
        assertEquals ("int", t.getLexeme()); //fix getLexeme();
        assertEquals (7, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = tokens.get(72);
        assertEquals (TokenKinds.RBRACE, t.getTokenType());
        assertEquals ("}", t.getLexeme());
        assertEquals (26, t.getLine());
        assertEquals (1, t.getColumn()); 
       
	}

}
