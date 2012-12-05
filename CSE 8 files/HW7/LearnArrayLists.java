/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 7 - LearnArrayLists
 * Date:	May 23, 2011
 *
 * File:	LearnArrayLists.java
 *
 * Sources of Help: List people/references you used for this HW.
 *
 * This java application performs various manipulations of text from a file
 * including removing shorter string in a pair of strings, removing strings
 * that alphabetically fall in the alphabetical range of two strings,
 * interleaving text with text from a second file, reversing the order of
 * every n words, and reversing the entire content of a file.
 */

import java.util.*;
import java.io.*;

/**
 * class LearnArrayLists
 * 	The class contains a main method that calls several other methods
 *	that manipulate text in a file in various ways and outputs the result
 *	to the user.
 */

public class LearnArrayLists
{
  /**
   * main() is the driver for this application.
   *
   * Main asks if the user wants to play a game. If so, it prompts the user
   * for a name of a file that contains text to manipulate. Main puts the
   * tokens of the file into an ArrayList of strings.
   * Main then calls printMenu to print the list of options that the user
   * may want to do with the words. When the user enters a number, main
   * calls the corresponding method to manipulate the strings. (Defined by
   * the methods below.
   *
   * Params: None
   * Return Value: void
   */

  public static void main( String[] args ) throws FileNotFoundException
  {
    Scanner console = new Scanner(System.in);
    String fileName;
    int n; //for reverseN int parameter

    System.out.print("Would you like to play a game (EOF to quit)? ");

    while(console.hasNext())
    {
      console.next(); //Clear the input
      System.out.print("Enter the filename (including extension) " +
	  "for data: ");
      //Take in a file name, create scanner object to process file
      fileName = console.next();
      Scanner input = new Scanner(new File(fileName));

      //Create ArrayList of strings to be populated by file
      ArrayList<String> list = new ArrayList<String>();

      //Populate ArrayList with string token froms file.
      while(input.hasNext())
      {
	list.add(input.next());
      }

      //Switch statement to control which methods are called to manipulate text 
      switch(printMenu(console))
      {
	case 1:
	  System.out.print("\n" + removeShorterStrings(list));
	  break;
	case 2:
	  System.out.print("\n" + removeInRange(list, console));
	  break;
	case 3:
	  System.out.print("\n" + interleave(list, console));
	  break;
	case 4:
	  //Ask for how many strings to reverse per sequence
	  System.out.print("Enter a number to reverse each successive" +
	      " sequence of values: ");
	  n = console.nextInt();
	  System.out.print("\n" + reverseN(list, n));
	  break;
	case 5:
	  System.out.print("\n" + reverseFile(fileName));
	  break;
	default:
	  System.out.println("Not a valid selection");
      }
      //Reprompt the user if the user wants to play again
      System.out.print("\nContinue (EOF to quit)? ");
    }
    System.out.println();
  } // end main()

  
  /**
   * printMenu() prints the menu for the user.
   *
   * Prints out the list of options then returns the user's integer input.
   * Parameter: Scanner console, to get user input
   * Return value: int
   */
  public static int printMenu(Scanner console)
  {
    System.out.println("\nWould you like to:\n" +
	" 1. Remove shorter strings from each contiguous pair of words\n" +
	" 2. Remove words in certain range\n" +
	" 3. Interleave words from two files\n" +
	" 4. Reverse each set of n contiguous words\n" +
	" 5. Reverse contents of a file (line by line & words per line)");
    System.out.print("Please make a selection: ");

    //Return user's selection (to switch statement in main)
    return console.nextInt();
  } // end printMenu()



  /**
   * removeShorterStrings() removes the shorter string in each string pair
   * 	from the String ArrayList passed in.
   * 
   * The method creates an output ArrayList of strings that contains all the
   * strings that were larger in each pair (thereby removing all the shorter
   * strings in each pair that was analyzed). The method loops through the
   * ArrayList passed in, adding to the output list the larger string of each 
   * pair of strings in the passed in list.
   *
   * Parameters: ArrayList<String> - to be analyzed for larger strings
   * Return Value: ArrayList<String> - resultant ArrayList from the analysis
   */
  public static ArrayList<String> removeShorterStrings(ArrayList<String> list)
  {
    //Create output Array List
    ArrayList<String> output = new ArrayList<String>();

    for(int i=0; i<list.size(); i+=2)
    {
      if((i+1)==list.size()) //Add any remaining terms if length is odd
	output.add(list.get(i));
      //First token has length less than or equal to other token
      else if(list.get(i).length() <= list.get(i+1).length())
	output.add(list.get(i+1));
      //First token is greater in length than second token
      else
	output.add(list.get(i));
    }

    return output; //List with removed short strings
  } // end of removeShorterStrings()


  /**
   * removeInRange() removes words that alphanumerically fall within the range
   * 	of two words that the user enters.
   * The method creates an output ArrayList and asks for a start and ending
   * string. It then loops through the ArrayList passed in and adds to the
   * output list the words that do not fall within the range of the start
   * and end strings, thereby removing those within the range.
   * Parameters: ArrayList<String> list - list to be analyzed
   *		 Scanner console - to get user input for start and end strings
   * Return Value: ArrayList<String>
   */
  public static ArrayList<String> removeInRange(ArrayList<String> list,
      Scanner console)
  {
    ArrayList<String> output = new ArrayList<String>();
    String start, end;

    //prompt user for start and end strings
    System.out.print("Enter beginning string: ");
    start = console.next();
    System.out.print("Enter ending string: ");
    end = console.next();

    //Compare each of the elements of the ArrayList with the start and end
    //words.Add those not in the range.
    for(int i=0; i<list.size(); i++)
    {
      if(list.get(i).compareTo(start) < 0 ||
	  list.get(i).compareTo(end) > 0 )
	output.add(list.get(i));
    }

    return output;
  } // end of removeInRange()


  /**
   * interleave() combines the text from two files by alternating adding
   * words from each file. The method prompts the user for a second file
   * with which to interleave text. It then creates an output list with 
   * the interleaved text. Any remaining text from either of the files
   * is added to the list non-interleaved.
   * Parameters - ArrayList<String> list - list to be interleaved
   * 		  Scanner console - to get name of other file
   * Return value: ArrayList<String> - list with interleaved words
   */
  public static ArrayList<String> interleave(ArrayList<String> list, 
      Scanner console)
    throws FileNotFoundException
    {
      ArrayList<String> newList = new ArrayList<String>();
      ArrayList<String> output = new ArrayList<String>();

      //Prompt user for second file name
      System.out.print("Enter the second filename (including extension) " +
      	"to interleave data: ");
      //Create new scanner for second file
      Scanner input2 = new Scanner(new File(console.next()));

      //Populate the new Array list with string tokens from second file
      while(input2.hasNext()) newList.add(input2.next());

      int length = Math.min(list.size(), newList.size());
      for(int i=0; i < length; i++)
      {
	output.add(list.get(i));
	output.add(newList.get(i));
      }

      //List is larger than newList, add the remaining elements of list
      if(list.size() > newList.size())
      {
	for(int j=length; j<list.size(); j++)
	  output.add(list.get(j));
      }
      //newList is larger than list, add the remaining elements of newList
      else if(newList.size() > list.size())
      {
	for(int j = length; j<newList.size(); j++)
	  output.add(newList.get(j));
      }

      return output;
    } // end of interleave()

  /**
   * reverseN() reverses each successive sequence of n elements in the list
   * 	passed in and returns the resulting list from this process.
   * Parameters: ArrayList<String> list - the source string list
   * 		 int n - the number of elements to reverse
   * Return: ArrayList<String> - the resulting list from the reversing process
   */
  public static ArrayList<String> reverseN(ArrayList<String> list, int n)
  {
    ArrayList<String> output = new ArrayList<String>();
    
    // Treat an integer input of less than 1 as 1
    if(n<1) n=1;

    //Add to output ArrayList each sequence of n elements in reverse
    for(int i=n-1; i<list.size(); i+=n)
    {
      for(int j=0; j<n; j++)
      {
	output.add(list.get(i-j));
      }
    }
    // Add the remaining elements to the output list, if any
    int length = list.size();
    for(int i=length-length%n; i<list.size(); i++)
    {
      output.add(list.get(i));
    }

    return output;
  } // end of reverseN()

  
  /**
   * reverseFile() reverses the contents of each file, line by line and word
   * 	word and returns a string that preserves the newline characters of the
   *	file.
   * Parameters: String fileName - the name of the file to be reversed
   * Return Value: String - the reversed contents of the file.
   */
  public static String reverseFile(String fileName) 
  throws FileNotFoundException
  {
    ArrayList<ArrayList<String>> lineList = new ArrayList<ArrayList<String>>();
    String output = "Contents of file reversed:\n";

    Scanner input = new Scanner(new File(fileName));

    //Create array list (of array lists)
    while(input.hasNextLine())
    {
      Scanner lineInput = new Scanner(input.nextLine());
      ArrayList<String> lineWords = new ArrayList<String>();
      while(lineInput.hasNext())
      {
	lineWords.add(lineInput.next());
      }
      lineList.add(lineWords);
    }

    //Reverse contents of file line by line, word by word
    for(int i = lineList.size()-1; i>=0; i--)
    {
      for(int j = lineList.get(i).size()-1; j>=0; j--)
      {
	output = output + lineList.get(i).get(j) + " ";
      }
      output = output + "\n"; //Add newline character after each line
    }

    return output;
  } // end of reverseFile()
} // end class LearnArrayLists
