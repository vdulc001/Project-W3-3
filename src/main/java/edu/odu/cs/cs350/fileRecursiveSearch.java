package edu.odu.cs.cs350;

import java.io.File;

/**
 * 
 * @author cs_sdean008
 * 
 */

 //Code References -
 // https://stackoverflow.com/questions/15624226/java-search-for-files-in-a-directory
 // https://www.geeksforgeeks.org/recursive-c-program-linearly-search-element-given-array/
 // https://stackoverflow.com/questions/10780747/recursively-search-for-a-directory-in-java

public class fileRecursiveSearch {

    static void fileSearch(File[] array, int index, int list) {
        // End fileSearch when no files are left to be found
        if (index == array.length)
            return;

        // Spacing
        for (int n = 0; n < list; n++)
            System.out.print("\t");

        // List file Name
        if (array[index].isFile())
            System.out.println(array[index].getName());

        // List Sub-directories
        else if (array[index].isDirectory()) {
            System.out.println("[" + array[index].getName() + "]");

            // Recursion search through sub-directories
            fileSearch(array[index].listFiles(), 0, list + 1);
        }

        // Begin a recursive search through the head directory
        fileSearch(array, ++index, list);
    }

    // Setup Listing
    public static void main(String[] args) {

        // Starting Directory Path & Temp File Path (Change Accordingly)
        String headDirectory = "/home/cs_sdean008/projectDir";

        // Construct new file to hold headDirectory
        File headDir = new File(headDirectory);

        if (headDir.exists() && headDir.isDirectory()) {

            // Array to hold listed directories/subdirectories
            File array[] = headDir.listFiles();

            // Listing format
            System.out.println("-----+-----");
            System.out.println("Files under the Head Directory " + headDir);
            System.out.println("-----+-----");

            // Recursion Call
            fileSearch(array, 0, 0);
        }
    }
}
