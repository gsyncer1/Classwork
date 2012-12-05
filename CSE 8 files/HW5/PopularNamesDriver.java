/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 5 - PopularNamesDriver
 * Date:	May 11, 2011
 *
 * File:	PopularNamesDriver.java
 *
 * Sources of Help: None
 *
 * This java application displays statistical and graphical information
 * about to the popularity of names in previous years.
 */

import java.util.*;
import java.awt.*;
import java.io.*;

/**
 * class PopularNamesDriver
 * 	This class contains two methods, main() and getInt().
 *	main() drives the application to display statistical and graphical
 *	information about a name the user enters.
 *	getInt() is used by main() to get a valid integer from the user.
 */

public class PopularNamesDriver
{
   public static final int START_YEAR = 1880, END_YEAR = 2009;
   public static final int MARGIN = 100;

   /**
    * main() is the driver for this popular names application.
    *
    * First, main creates an array of files which contains the
    * name popularity data.
    * It then prompts the user if he/she wants to view statistics of
    * a name. If so, it asks for a name, start year, and end year for
    * which to display statistics and graphical information. It then
    * displays this information for the user. It keeps asking and displaying
    * information as long as the user wants to see information.
    * 
    * Params: None
    * Return Value: void
    */

   public static void main( String[] args ) throws FileNotFoundException
   {
      Scanner input = new Scanner(System.in);
      File[] yobFile = new File[END_YEAR - START_YEAR + 1];

      //Populate File Array
      for(int i = 0; i<yobFile.length; i++)
      {
	 int year = i + START_YEAR;
	 yobFile[i] = new File("yob" + year + ".txt");
      }

      System.out.print("Would you like to view statistics of a name " +
	    "(EOF to quit)? ");
      while(input.hasNext()) //keep looping while user wants stats
      {
	 input.next(); //clear input
	 //Get baby name
	 System.out.print("\nPlease enter the baby name for which data is "
	       + "to be displayed: ");
	 String babyName = input.next();
	 /* Get VALID start year - between START_YEAR and END_YEAR
	  * (Note: startYear is different from the constant START_YEAR)
	  */
	 int startYear = getInt(input, "Enter start year of birth: ");
	 while((startYear < START_YEAR) || (startYear > END_YEAR))
	 {
	    System.out.println("Start year should be between " + START_YEAR +
	    			" and " + END_YEAR + " (inclusive)");
	    startYear = getInt(input, "Enter start year of birth: ");
	 }
	 /* Get VALID end year - between startYear and END_YEAR
	  * (Note: endYear is different from the constant END_YEAR)
	  */
	 int endYear = getInt(input, "Enter end year of birth: ");
	 while((endYear < startYear) || (endYear > END_YEAR))
	 {
	    System.out.println("End year should be between " + startYear +
	    			" and " + END_YEAR + " (inclusive)");
	    endYear = getInt(input, "Enter end year of birth: ");
	 }

	 //Create PopularName object based on user input
	 PopularName nameQuery = new PopularName(babyName, yobFile,
	       startYear, endYear);

	 nameQuery.printStatistics();

	 // Create drawing panel, increasing width if necessary
	 int panelWidth = 550 + 2*MARGIN, panelHeight = 550 + 2*MARGIN;
	 if( ((endYear - startYear)*15 + 2*MARGIN) > panelWidth )
	 {
	    panelWidth = (endYear - startYear)*15 + 2*MARGIN;
	 }
	 DrawingPanel panel = new DrawingPanel(panelWidth, panelHeight);
	 Graphics g = panel.getGraphics();

	 //Draw lines and legend
	 for(int i=0; i<=1000; i+=100)
	 {
	    g.drawLine(0, MARGIN + i/2, panelWidth, MARGIN + i/2);
	    g.drawString("Rank " + i, 0, MARGIN + i/2);
	 }

	 //Print Title
	 g.drawString("Displaying graph for " + nameQuery.getName(),
	 				MARGIN, MARGIN/4);
	 g.drawString("Years " + startYear + " to " + endYear,
	 				MARGIN, MARGIN/2);

	 //Draw the graphical information of the name
	 nameQuery.plotFemaleGraph(g);
	 nameQuery.plotMaleGraph(g);
	 nameQuery.drawFemaleGraph(g);
	 nameQuery.drawMaleGraph(g);

	 //Re-prompt user
	 System.out.print("Continue (EOF to quit)? ");
      }
      System.out.println();


   } //end of main()
   
   
   /**
    * getInt() handles the input of integers by the user, checking for
    * valid integers and reprompting for a valid integer if invalid.
    * Params: Scanner console - to handle input
    *	      String prompt - the relevant prompt requiring an integer input
    *				to be printed
    * Return Value: int
    */
   public static int getInt(Scanner console, String prompt)
   {

      //Print the prompt passed in as a parameter.
      System.out.print(prompt);

      //Check for invalid input
      while(!(console.hasNextInt()))
      {
	 console.next(); //Clear invalid input
	 System.out.print("Not an integer. Try again: \n" + prompt);
      }

      return console.nextInt(); //Return the valid integer
   } //end of getInt()

} // end class PopularNamesDriver
