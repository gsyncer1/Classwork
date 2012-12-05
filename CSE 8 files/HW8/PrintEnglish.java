/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 8 - PrintEnglish.java
 * Date:	June 2, 2011
 *
 * File:	PrintEnglish.java
 *
 * Sources of Help: None
 *
 * A java application that reads two integers (a number vaue and a base value)
 * from the user and prints the English words for each digit in the number
 * to the base separated by a space. Uses recursion.
 *
 */

 import java.util.*;

 /**
  * class PrintEnglish
  * 	Contains a main method that drives the application, and the method
  * 	printEnglishNumToBase that handles printing the numbers in the
  *	user specified base using English words
  */

  public class PrintEnglish
  {
     /**
      * main() is the driver for this application.
      *
      * The main method asks for a number and a valid base with which to print
      * the numbers. It then calls printEnglishNumToBase to print the English
      * words of the number in the user-specified base.
      *
      * Params: String[] args - not used
      * Return Value: void
      */

      public static void main( String[] args )
      {
	Scanner console = new Scanner(System.in);
	int number, base;

	System.out.print("Please enter a number (EOF to quit): ");
	while(console.hasNext())
	{
	  if(console.hasNextInt())
	  {
	    number = console.nextInt();
	    System.out.print("Please enter a base for the number: ");
	    base = console.nextInt();
	    while(base<2 || base>36) //Base must be between 2 and 36
	    {
	      System.out.print("Base value needs to be between 2 and 36.");
	      System.out.println(" Try again: ");
	      System.out.print("Please enter a base for the number: ");
	      base = console.nextInt();
	    }

	    //Print the English words for each digit
	    System.out.print(number + " base " + base + " is ");
	    if(number<0) //print a minus if the number is negative
	    {
	      System.out.print("minus ");
	      number = -number;
	    }

	    if(number == 0) //print zero of number is 0
	    {
	      System.out.println("zero");
	    }
	    else
	    {
	      printEnglishNumToBase(number, base);
	    }
	  }
	  else console.next(); //clear input

	  System.out.print("\n\nPlease enter a number (EOF to quit): ");
	}
	System.out.println();
      } // end main()

      /**
       * printEnglishNumToBase().
       * 	Prints the digits of the number in the specified base using
       *	English words and letters.
       * Params: int number, int base - The number and the base in which
       *	 it is to be printed
       * Return value: void
       */
      public static void printEnglishNumToBase(int number, int base)
      {
	//Array of strings to be used to print the English words and letters
	String[] digits = {"zero", "one", "two", "three", "four", "five",
		"six", "seven", "eight", "nine", "A", "B", "C", "D", "E",
		"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
		"R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	int digit = number % base; //Find the digit according to the base
	
	if(number == 0); //Do nothing
	else
	{
	  printEnglishNumToBase(number / base, base);
	  System.out.print(digits[digit] + " ");
	}
      }
  } // end class PrintEnglish
