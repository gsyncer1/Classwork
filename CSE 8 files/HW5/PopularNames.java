/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 4 - PopularNames
 * Date:	April 28, 2011
 *
 * File:	PopularNames.java
 *
 * Sources of Help: None
 *
 * This Java application displays data about a baby name that a user enters.
 * The data includes, for every ten years from 1880 to 2010, how many babies
 * had the name and what rank that baby name had for both male and female
 * names.
 */

import java.util.*;
import java.io.*;

/**
 * class PopularNames
 * 	The class Popular names contains a main method that prompts the user
 *	if the user wants to display statistics for a certain baby name and
 *	displays the statistics for the baby name if desired by calling
 *	the method printStatistics.
 *	The method printStatistics searches through files that contain data
 *	about baby names for the every ten years 1880-2010. Using this data,
 *	it processes the information and displays the statistics.
 */

public class PopularNames
{
   /**
    * main() is the driver for this application
    *
    * The main method creates and array of files to be scanned.
    * It prompts the user if he/she wants to view the statistics of a baby
    * name. If so, it asks for a baby name and calls printStatistics to
    * display the statistics for the baby name.
    * It continually asks if statistics want to be viewed for baby names
    * until the user enters EOF.
    *
    * Params: None
    * Return Value: void
    */

   public static final int START_YEAR = 1880;
   public static final int END_YEAR = 2010;

   public static void main( String[] args ) throws FileNotFoundException
   {
      Scanner input = new Scanner(System.in);
      File[] yobFile = new File[(END_YEAR - START_YEAR)/10 + 1];

      //create the array of files (which contain the baby name data)
      for(int i=0; i<yobFile.length ; i++)
      {
	 int year = (i*10 + START_YEAR);
	 yobFile[i] = new File("yob" + year + ".txt");
      }

      System.out.print("Would you like to view statistics of a name " +
	    "(EOF to quit)? ");
      while(input.hasNext()) //keep looping while user wants stats
      {
	 input.next(); //clear input
	 System.out.print("Please enter the baby-name for which data is " +
	       "to be displayed: ");
	 String babyName = input.next(); //get desired baby name for stats
	 printStatistics(babyName,yobFile);
	 System.out.print("Continue (EOF to quit)? "); //re-prompt
      }
   } // end main()





   /**
    * The method printStatistics displays the male and female statistics for a
    * baby name that the user enters. The statistics that are displayed for
    * every ten years from the START_YEAR to the END_YEAR are the number
    * of babies given that name and the rank of how popular that name was.
    *
    * Params: String name (to be searche for in the files),
    *	      File[] yobFile (the array of files to be searched).
    * Return Value: void
    */
   public static void printStatistics( String name, File[] yobFile)
      throws FileNotFoundException
      {
	 // Print table headers
	 System.out.println("Year  Gender  Total   Rank");
	 // Loop through file Array to display statistics for each year
	 for(int i=0; i<yobFile.length; i++)
	 {
	    Scanner line_input = new Scanner(yobFile[i]);
	    // pName is the name found in the parsed line in the file.
	    String line, pName, gender, number;
	    // fNameMatch and mNameMatch determine whether matches were found
	    boolean fNameMatch = false, mNameMatch = false;
	    int firstComma, secondComma, total, prevTotal=0;
	    int fTotal = 0, mTotal = 0; //saved totals for male and female
	    int fCount = 0, fCurrRank = 0, fRank = 0; //fRank is the saved rank 
	    int mCount = 0, mCurrRank = 0, mRank = 0; //mRank is the saved rank

	    while(line_input.hasNextLine())
	    {
	       //Parse each line
	       line = line_input.nextLine();
	       firstComma = line.indexOf(",");
	       pName = line.substring(0,firstComma); //get parsed name
	       line = line.substring(firstComma+1);
	       secondComma = line.indexOf(",");
	       gender = line.substring(0, secondComma); //get gender
	       number = line.substring(secondComma+1); //get number

	       // convert the number string into an integer
	       total = Integer.parseInt(number);
	       if(gender.equals("F"))
	       {
		  fCount++; //keep track of number of female names
		  /* if the total is not the same as previous total scanned
		   * the rank is the current female count
		   */
		  if(total != prevTotal) fCurrRank = fCount;
		  if(pName.equals(name))
		  {
		     //Indicate name found. Save rank and total.
		     fNameMatch = true;
		     fRank = fCurrRank;
		     fTotal = total;
		  }
	       }
	       if(gender.equals("M"))
	       {
		  mCount++; //keep track of number of male names
		  /* if total is not the same as previous total,
		   * the rank is at the current count
		   */
		  if(total != prevTotal) mCurrRank = mCount;
		  if(pName.equals(name))
		  {
		     //Indicate name found, save rank and total
		     mNameMatch = true;
		     mRank = mCurrRank;
		     mTotal = total;
		  }
	       }

	       prevTotal = total; //make the total the previous total
	    }


	    //Print the table
	    //Print female statistics
	    System.out.printf("%4d    F   ", START_YEAR + i*10); //Year and gender
	    System.out.printf("  %5d   ", fTotal); //Female total
	    if(fNameMatch) System.out.printf("%4d\n", fRank); //Female rank
	    else System.out.println("   -"); //printed if no names this year

	    //Print male statistics
	    System.out.printf("        M     %5d   ", mTotal);//Gender,Total
	    if(mNameMatch) System.out.printf("%4d\n", mRank); //Male rank
	    else System.out.println("   -"); //printed if no names this year

	 }

      } // end printStatistics()
} // end class HWTemplate
