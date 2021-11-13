package edu.odu.cs.cs350;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTokenScanner {

	@BeforeAll
    public static void setUp() throws Exception {
    }

	/*@Test
    public final void testScanner() {
        String inputString = "123\tident1 \nCASE     42\n";
        Reader input = new StringReader(inputString);
        TokenStream tokenstream = new TokenStream(input);
        ArrayList<Token> tokens = new ArrayList<Token>();
        for (Token tok: tokenstream) {
            tokens.add(tok);
        }
        assertEquals (4, tokens.size());
        
        Token t = tokens.get(0);
        assertEquals (TokenKinds.INTEGERLITERAL, t.getTokenType());
        assertEquals ("123", t.getLexeme());
        assertEquals (1, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = tokens.get(1);
        assertEquals (TokenKinds.IDENTIFIER, t.getTokenType());
        assertEquals ("ident1", t.getLexeme());
        assertEquals (1, t.getLine());
        assertEquals (5, t.getColumn());
        
        t = tokens.get(2);
        assertEquals (TokenKinds.CASE, t.getTokenType());
        assertEquals (2, t.getLine());
        assertEquals (1, t.getColumn());
        
        t = tokens.get(3);
        assertEquals (TokenKinds.INTEGERLITERAL, t.getTokenType());
        assertEquals ("42", t.getLexeme());
        assertEquals (2, t.getLine());
        assertEquals (13, t.getColumn());
	}*/
}
