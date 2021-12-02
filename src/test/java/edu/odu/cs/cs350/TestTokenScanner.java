package edu.odu.cs.cs350;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTokenScanner {

	@BeforeAll
    public static void setUp() throws Exception {
    }

	@Test
    public final void testScanner() {
		ArrayList<Token> toks = new ArrayList<Token>();
		SourceCodeFile s = new SourceCodeFile("src/test/data/test1.cpp");
		toks = s.getTokens();
        
        assertEquals (70, s.calculateTotalTokens());
        
        Token t = toks.get(0);
        assertEquals (TokenKinds.PREPROCESSOR, t.getTokenType());
        assertEquals (1, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = toks.get(4);
        assertEquals (TokenKinds.USING, t.getTokenType());
        assertEquals (3, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = toks.get(8);
        assertEquals (TokenKinds.INT, t.getTokenType());
        assertEquals (7, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = toks.get(18);
        assertEquals ("a", t.getLexeme());
        assertEquals (TokenKinds.IDENTIFIER, t.getTokenType());
        
        t = toks.get(20);
        assertEquals ("4", t.getLexeme());
        assertEquals (TokenKinds.INTEGER_LITERAL, t.getTokenType());
        
        t = toks.get(69);
        assertEquals (TokenKinds.RBRACE, t.getTokenType());
        assertEquals (26, t.getLine());
        assertEquals (1, t.getColumn()); 
       
	}

}
