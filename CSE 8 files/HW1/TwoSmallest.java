/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 1 - TwoSmallest
 * Date:	April 5, 2011
 * 
 * File:	TwoSmallest.java
 * 
 * Sources of Help: None
 *
 * Java application to determine the two smallest distinct integers
 * from a set of integers that the user inputs.
 */

 import java.util.*;

/**
 * class TwoSmallest
 *
 * The class TwoSmallest contains a program that will find the
 * two lowest distinct integers in a set of integers that the user
 * enters.
 */

public class TwoSmallest
{
   /**
    * main() is the driver for this application
    * 
    * Get a set of integers from the user via a scanner.
    * Determine the two lowest distinct integers from the
    * integers the user entered.
    * Also deals with special cases of only 1 distinct integer entered
    * or no integers entered.
    *
    * Params:	String[] args - Not used.
    * Return Value: 	None
    */

    public static void main( String[] args )
    {
        Scanner input = new Scanner (System.in);
	int number, smallest, nextSmallest;

	//Prompt user to enter a series of integers
	System.out.println("Enter a series of integers; EOF to Quit.\n");
	
	if(input.hasNextInt())
	{
	    smallest = input.nextInt();

	    //Scan for the next distinct integer, if any.
	    if(input.hasNextInt())
	    {
		number = input.nextInt();
		//If number is the same as smallest, find the next distinct integer, if any.
		while(number == smallest && input.hasNextInt()) number = input.nextInt();
		if(number == smallest)
		{
		    /* Enter body of this if statement if all numbers after 1st number
		     * are equal to first number.
		     */
		    System.out.println("\nSmallest distinct number entered was " + smallest);
		}
		else
		{
		    //At this point, at least 2 distinct integers were found
		    if(number < smallest)
		    {
			nextSmallest = smallest; //Smallest integer is now the next smallest
			smallest = number;
		    } else nextSmallest = number;

		    //Scan for any more integers, if any.
		    while(input.hasNextInt())
		    {
			number = input.nextInt();
			if( number < smallest )
			{
			    nextSmallest = smallest; //Smallest int is now next smallest
			    smallest = number;
			} else if( number < nextSmallest && number != smallest)
			{
			    nextSmallest = number;
			}
		    }

		    System.out.println("\nSmallest distinct number entered was " + smallest);
		    System.out.println("Second smallest distinct number enetered was " 
		                       + nextSmallest);

		}
	    } 
	    else //Only one number was entered.
		System.out.println("\nSmallest distinct number entered was " + smallest);  
	}
	else //No numbers were entered
	{
	    System.out.println("\nNo numbers entered.");
	}

    } /* End of main() */
} /* End of class TwoSmallest */

