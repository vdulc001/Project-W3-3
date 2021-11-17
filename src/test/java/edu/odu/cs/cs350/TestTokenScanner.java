package edu.odu.cs.cs350;

import java.io.Reader;
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
		Reader input = s.getInput("src/test/data/test1.cpp");
        LinkedList<Token> tokens = new LinkedList<Token>();
        s.tokenize(/*input, tokens*/);
        assertEquals (21, tokens.size());
        
        Token t = tokens.get(4);
        assertEquals (TokenKinds.USING, t.getTokenType());
        //assertEquals ("using", t.getLexeme());
        assertEquals (3, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = tokens.get(8);
        assertEquals (TokenKinds.INT, t.getTokenType());
        //assertEquals ("int", t.getLexeme()); //fix getLexeme();
        assertEquals (7, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = tokens.get(1);
        assertEquals (TokenKinds.LT, t.getTokenType());
        //assertEquals ("<", t.getLexeme());
        assertEquals (1, t.getLine());
        assertEquals (10, t.getColumn());
       
	}

}
