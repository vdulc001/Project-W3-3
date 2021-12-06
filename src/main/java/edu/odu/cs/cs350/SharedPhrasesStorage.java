/**
 * 
 */
package edu.odu.cs.cs350.sharedphrases;

import java.util.Set;

/**
 * Storage for phrases found in submissions from different sources.
 * 
 * A sentence (a complete file) is passed as a character string. The
 * character codes are presumed to represent integer-valued token kinds.
 * 
 * @see TokenStream#toString()
 * 
 * @author zeil
 *
 */
public interface SharedPhraseStorage {
	
	

	/**
	 * Adds all phrases within sentence to the store, associating a sourceID value
	 * with each one. After multiple invocations of this function, a given
	 * phrase may have multiple sourceID values associated with it.
	 * 
	 * @param sentence an encoded series of tokens
	 * @param sourceID an identifier indicating the source of this sentence
	 */
	void addSentence (final String sentence, final String sourceID);
	
	/**
	 * Returns a value that can be iterated to obtain all phrases in the store:
	 *    for (String s: phrases.allPhrases() {
	 *       System.out.println (s + " is a phrase");
	 *    }
	 *    
	 * @return access to all phrases
	 */
	Iterable<CharSequence> allPhrases();
		
	
	/**
	 * Return the set of sourceIDs associated with a given phrase
	 * @param phrase phrase to search for
	 * @return a set of sourceIDs
	 */
	Set<String> sourcesOf (final String phrase);
	
}
