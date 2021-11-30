package edu.odu.cs.cs350;

/*import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayList;
import javax.xml.transform.Source;
import java.io.Reader;*/

public class Refactoring {

	public Refactoring () {}
	
	public int findOpportunityForImprovement () {return 0;} // suggested refactorings are sorted high to low
															// # of replacements * # of tokens in sequence
	
	public String refactoringOutput(SourceCodeFile scf)
	{
		String output = "Opportunity 0, 0 tokens\n";	// # tokens saved, # tokens in sequence
		output += scf.getPath() + ": 0, 0\n";			// line & column number most likely accessed through token object
		output += "x y z";								// lexemes also accessed through token objects, identifiers & numeric literals should be printed
		return output;
	}
	
	public void findDupSequences()
	{
		// create a sequence
		// compare to rest of code, finding matching sequences (tokenType)
		// for each match, print path of file, line #, and column # where it's found
		// for each match, print the lexemes of the tokens that can be replaced
		// repeat with new sequences until end of file
	}
}
