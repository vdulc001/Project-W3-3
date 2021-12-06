/**
 * 
 */
package edu.odu.cs.cs350.sharedphrases;

import static edu.odu.cs.cs350.sharedphrases.UnicodeConstants.PRIVATE_USE_AREA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;


import edu.odu.cs.cs350.sharedphrases.iterators.OmitPrivateCodesIterator;
import edu.odu.cs.cs350.sharedphrases.iterators.StringContainsIterator;
import edu.odu.cs.cs350.sharedphrases.iterators.TreeIterator;
import edu.odu.cs.cs350.sharedphrases.suffixtrees.ConcurrentSuffixTree;

/**
 * Storage for phrases found in submissions from different students.
 * 
 * A sentence (a complete file) is passed as a character string. The
 * character codes are presumed to represent integer-valued token kinds.
 * 
 * Typical usage:
 * 
 *   SharedPhrases phrases = new SharedPhrases(); 
 *   phrases.addSentence ("abc", "jones"); // Jones has written abc
 *   phrases.addSentence ("ab", "smith"); // Smith has written ab
 *   phrases.addSentence ("ac", "doe"); // Doe has written ac
 *   for (String p: phrases.allPhrases()) {
 *      System.out.print (p + ":");
 *      for (String source: phrases.sourcesOf(p)) {
 *          System.out.print (" " + source);
 *      } 
 *      System.out.println();
 *   }
 * 
 * The output would be something like:
 *    a: jones smith doe
 *    ab: jones smith
 *    ac: jones doe
 *    abc: jones
 *    b: jones smith
 *    bc: jones
 *    c: jones doe
 * 
 * though the order of the lines and the order of source names within each line
 * may vary.
 * 
 * 
 * To see how many times a given phrase occurs you can do
 * 
 *     Iterable<CharSequence> setOfSuffixes = phrases.getMaximalSuffixesOf("ab");
 *     int counter = 0;
 *     for (CharSequence suffix: setOfSuffixes) {
 *         counter += phrases.getSourcesOf(suffix).size();
 *     }
 * 
 * 
 * 
 * @see TokenStream#toString()
 * 
 * @author zeil
 *
 */
public class SharedPhrases implements SharedPhraseStorage {
	
	
	/**
	 * Ordered list of all known sources, indexed by 
	 *   (character code - UnicodePrivateUseArea).  
	 */
	private final List<String> allSources;
	
	/**
	 * Map of known sources onto character codes
	 */
	private final Map<String,Character> allSourceCodes;
	
	/**
	 * Suffix tree - holds all suffixes of the sentences added to this
	 * structure.
	 */
	private final ConcurrentSuffixTree<String> suffixTree;

	
	/**
	 * Get a character that can be used to uniquely identify a source.
	 * 
	 * @param source a string identifier for a sentence source. A new code is
	 *     allocated if this source is unknown.
	 *               
	 * @return character code for this source.
	 */
	private char getCodeFor (final String source)
	{
		Character chr = allSourceCodes.get(source);
		if (chr == null) {
			chr = (char)(PRIVATE_USE_AREA + allSources.size());
			allSourceCodes.put(source, chr);
			allSources.add(source);
		}
		return chr;
	}
	
		

	/**
	 * Create an empty collection of phrases.
	 */
	public SharedPhrases() {
		suffixTree = new ConcurrentSuffixTree<String>(new DefaultCharArrayNodeFactory());
		allSourceCodes = new HashMap<>();
		allSources = new ArrayList<>();
	}

	/**
	 * Adds all phrases within sentence to the store, associating a sourceID value
	 * with each one. After multiple invocations of this function, a given
	 * phrase may have multiple sourceID values associated with it.
	 * 
	 * @param sentence an encoded series of tokens
	 * @param sourceID an identifier indicating the source of this sentence
	 */
	public void addSentence (final String sentence, final String sourceID)
	{
		suffixTree.put(sentence + getCodeFor(sourceID), sourceID);
	}
	
	/**
	 * Returns a value that can be iterated to obtain all phrases in the store:
	 *    for (String s: phrases.allPhrases() {
	 *       System.out.println (s + " is a phrase");
	 *    }
	 *    
	 * @return access to all phrases
	 */
	public Iterable<CharSequence> allPhrases()
	{
		return new SharedPhrasesIterable("");
	}
	
	/**
	 * Returns a value that can be iterated to obtain all phrases in the store
	 * that contain a given short phrase.
	 *    
	 * @param phrase a phrase to search for
	 * @return access to all phrases containing phrase
	 */
	public Iterable<CharSequence> phrasesContaining(final String phrase)
	{
		return new SharedPhrasesIterable(phrase);
	}
	
	
	/**
	 * Return the set of sourceIDs associated with a given phrase
	 * @param phrase phrase to search for
	 * @return a set of sourceIDs
	 */
	public Set<String> sourcesOf (final String phrase) { // NOPMD by zeil on 8/26/15 3:10 PM
		final Set<String> results = new TreeSet<String>();
		for (final String s: suffixTree.getValuesForKeysContaining(phrase)) {
			results.add(s);
		}
		return results;
	}

	/**
	 * Return a set of all substrings of a sentence that begin with a phrase
	 * and continue to the end of the sentence.
	 * 
	 * Note that these substrings will all include a special end-of-sentence termination
	 * character, which will normally need to be stripped away to use the substring,
	 * except when searching a SharedPhrases object for additional information about
	 * that string (e.g., getSourcesOf).
	 * 
	 * @param phrase a phrase to search for within the various sentences
	 * @return a set of sentence suffixes
	 */		
	public Iterable<CharSequence> phrasesCompleting(String phrase) {
        return suffixTree.getMaximalSuffixesOf(phrase);
    }

	
	/**
	 * String representation of an entire tree, for debugging purposes.
	 */
	public String toString() {
		return suffixTree.toString();
	}
	
	
	/**
	 * Implementation of Iterable for suffixes
	 * 
	 * @author zeil
	 *
	 */
	private class SharedPhrasesIterable implements Iterable<CharSequence> {

		/**
		 * A target string that must be contained within all strings
		 * being visited during an iteration. 
		 */
		String target;
		
		/**
		 * Create an iterable object that visits all suffixes that
		 * contain a target string.
		 * 
		 * @param target A string that must be contained in all strings to be
		 *     visited.
		 */
		public SharedPhrasesIterable (final String target)
		{
			this.target = target;
		}
		
		/**
		 * Returns an iterator that visits each suffix of all
		 * sentences added to this collection.
		 */
		@Override
		public Iterator<CharSequence> iterator() {
			if (target.length() > 0) {
				return  new StringContainsIterator(
						         new OmitPrivateCodesIterator (
								   new TreeIterator(suffixTree.getNode())),
						                target);
			} else {
				return new OmitPrivateCodesIterator (
						        new TreeIterator(suffixTree.getNode()));
			}
		}
	}


	
	
}
