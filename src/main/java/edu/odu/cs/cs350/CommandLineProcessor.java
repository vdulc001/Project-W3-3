package edu.odu.cs.cs350;

public class CommandLineProcessor {

	public static void main(String[] args) {
		
		SourceCodeFile scf = new SourceCodeFile(args[0]);
		System.out.println("Files scanned:\n" + scf);

	}	
}
