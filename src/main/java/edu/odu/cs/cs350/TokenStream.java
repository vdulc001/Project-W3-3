package edu.odu.cs.cs350;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author zeil
 *
 */
public class TokenStream implements Iterable<Token> {
    
    /**
     * The list of tokens obtained from the actual scanner.
     */
    private List<Token> tokens;
    
   /**
    * Create a TokenStream from an input source.
    * @param input input source for this stream
    */
    public TokenStream(final Reader input) {
        tokens = new LinkedList<Token>();
        GeneratedScanner scanner = new GeneratedScanner (input);
        try {
            Token token = scanner.yylex();
            while (token != null && token.getTokenType() != TokenKinds.EOF) {
                tokens.add (token);
                token = scanner.yylex();
            }
        } catch (IOException ex) {
            // Not necessarily a problem, depending on the input source
        }
    }

    /**
     * Return an iterator over the list of tokens.
     * @see java.lang.Iterable#iterator()
     * @return iterator
     */
    @Override
    public final Iterator<Token> iterator() {
        return tokens.iterator();
    }

    
}
