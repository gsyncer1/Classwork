/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 5 - PopularName
 * Date:	May 11, 2011
 *
 * File:	PopularName.java
 *
 * Sources of Help: None
 *
 * This java application works with PopularNamesDriver to display
 * graphical information about the popularity of names in past
 * years by handling the creation and drawing of information of
 * a name that the user requests.
 *
 */

import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * class PopularName
 * 	This class contains the overloaded constructors to handle the creation
 *	of PopularName objects and the methods populateRankArrays(), getName(),
 *	printStatistics(), plotFemaleGraph(), plotMaleGraph(),
 *	drawFemaleGraph(), and drawMaleGraph(). These work together to handle
 *	the display of statistical and graphical information about the
 *	popularity of the names that a user enters.
 */

public class PopularName
{
   public static final int MARGIN = PopularNamesDriver.MARGIN, 
			START_YEAR = PopularNamesDriver.START_YEAR, 
			END_YEAR = PopularNamesDriver.END_YEAR;

   private String name;
   int startYear;
   int endYear;
   int[] femaleRank;
   int[] maleRank;


   //No-arg ctor, initializes name to empty string.
   public PopularName()
   {
      this.name = "";
   }

   public PopularName(String name, File[] yobFiles, int startYear, int endYear)
      throws FileNotFoundException
      {
	 this.name = name;
	 this.startYear = startYear;
	 this.endYear = endYear;
	 this.femaleRank = new int[endYear-startYear+1];
	 this.maleRank = new int[endYear-startYear+1];
	 populateRankArrays(name, startYear, endYear, yobFiles, femaleRank,
	       maleRank);
      }

   /**
    * populateRankArrays() processes the data from the yobFiles array
    * and populates the male and female rank arrays with the rankings for
    * each year in the range that the user inputted.
    * Parameters: String name - the name the user queried
    *		  int startYear - the starting year of the statistics
    *		  int endYear - ending year of statistics
    * 		  File[] yobFiles - array of files containing name data
    * 		  int[] femaleRank - female rank array to be populated
    * 		  int[] maleRank - male rank array to be populated
    * Return: void
    */
   public static void populateRankArrays(String name, int startYear, 
	 int endYear, File[] yobFiles, int[] femaleRank,
	 int[] maleRank) throws FileNotFoundException
   {
      int fileStartIndex = startYear - START_YEAR;
      int fileArrSearchLength = endYear - startYear + 1;
      
      //Initialize elements of rank arrays to 1001 (default rank)
      for(int i=0; i < femaleRank.length; i++) femaleRank[i] = 1001;
      for(int i=0; i < maleRank.length; i++) maleRank[i] = 1001;

      for(int i=0; i < fileArrSearchLength; i++)
      {
	 Scanner line_input = new Scanner(yobFiles[i+fileStartIndex]);
	 String line, pName, gender, number;
	 int firstComma, secondComma, total, prevTotal = 0;
	 int fCount = 0, fCurrRank = 0;
	 int mCount = 0, mCurrRank = 0;


	 while(line_input.hasNextLine())
	 {
	    //Parse each line
	    line = line_input.nextLine();
	    firstComma = line.indexOf(",");
	    pName = line.substring(0, firstComma); //get parsed name
	    line = line.substring(firstComma+1);
	    secondComma = line.indexOf(",");
	    gender = line.substring(0, secondComma); //get gender
	    number = line.substring(secondComma+1); //get number (string)

	    //convert number string into an integer
	    total = Integer.parseInt(number);
	    if(gender.equals("F"))
	    {
	       fCount++; //keep track of number of female names
	       /* if the total is not the same as the previous total scanned
		* the rank is the current female count
		*/
	       if(total != prevTotal) fCurrRank = fCount;
	       if(pName.equals(name))
	       {
		  femaleRank[i] = fCurrRank;
	       }

	       prevTotal = total;
	    }
	    if(gender.equals("M"))
	    {
	       mCount++; //keep track of number of male names
	       /* if total is not the same as previous total,
		* the rank is at the current count
		*/
	       if(total != prevTotal) mCurrRank = mCount;
	       if(pName.equals(name)) maleRank[i] = mCurrRank;

	       prevTotal = total;
	    }
	 }
      }
   } // end of populateRankArrays()


   /**
    * Accessor method getName() returns the this object's name.
    */
   public String getName()
   {
      return this.name;
   } // end of getName()

   
   /**
    * printStatistics() prints the male and female rankings for a name that
    * the user enters in the range of years that the user inputted.
    * Parameters: None
    * Return: void
    */
   public void printStatistics()
   {
      System.out.println("Statistics for baby name \'" + this.name +
	    "\' from " + this.startYear + " to " + this.endYear + ":");
      System.out.printf("%-10s    %-10s\n", "Female", "Male");
      System.out.println("Year  Rank    Year  Rank");
      for(int i=0; i < this.endYear - this.startYear + 1; i++)
      {
	 System.out.printf("%4d%6d%8d%6d\n", this.startYear + i, femaleRank[i],
	       this.startYear + i, maleRank[i]);
      }
   } // end of printStatistics()

   
   /**
    * plotFemaleGraph plots the points on the (female) rank vs year graph.
    * Parameters: Graphics g - to draw the points on the graph.
    * Return: void
    */
   public void plotFemaleGraph(Graphics g)
   {
      g.setColor(Color.PINK); // pink color for female
      g.setFont(new Font("SansSerif", Font.PLAIN, 8));
      for(int i=0; i<femaleRank.length; i++)
      {
	 g.fillOval(MARGIN + i*15 -2,((femaleRank[i]+1)/2 + MARGIN)-2, 4, 4);
	 // Print the corresponding year for every five points.
	 if(i%5==0) g.drawString("" + (this.startYear + i), MARGIN + i*15 -2,
	       (femaleRank[i]+1)/2 + MARGIN - 2);
      }
   } // end of plotFemaleGraph()

   
   /**
    * plotMaleGraph plots the points on the (male) rank vs year graph.
    * Parameters: Graphics g - to draw points on the graph.
    * Return: void
    */
   public void plotMaleGraph(Graphics g)
   {
      g.setColor(Color.BLUE); // blue color for male
      g.setFont(new Font("SansSerif", Font.PLAIN, 8));
      for(int i=0; i<maleRank.length; i++)
      {
	 g.fillOval(MARGIN + i*15 -2,((maleRank[i]+1)/2 + MARGIN)-2, 4, 4);
	 // Print the corresponding year for every five points.
	 if(i%5==0) g.drawString("" + (this.startYear + i), MARGIN + i*15-2,
	       (maleRank[i]+1)/2 + MARGIN -2);
      }
   } // end of plotMaleGraph()

   
   /**
    * drawFemaleGraph draws the lines connecting the points corresponding to
    * female data.
    * Parameters: Graphics g  - to draw lines on graph.
    * Return: void
    */
   public void drawFemaleGraph(Graphics g)
   {
      g.setColor(Color.PINK); // Color pink for female data
      for(int i=0; i<femaleRank.length-1; i++)
      {
	 g.drawLine(MARGIN + i*15, (femaleRank[i]+1)/2 + MARGIN, 
	       MARGIN + (i+1)*15, (femaleRank[i+1]+1)/2 + MARGIN);
      }
   } // end of drawFemaleGraph()


   /**
    * drawMaleGraph draws the lines connecting the points corresponding to
    * male data.
    * Parameters: Graphics g - to draw lines on graph.
    * Return void
    */
   public void drawMaleGraph(Graphics g)
   {
      g.setColor(Color.BLUE); // Color blue for male data
      for(int i=0; i<maleRank.length-1; i++)
      {
	 g.drawLine(MARGIN + i*15, (maleRank[i]+1)/2 + MARGIN, 
	       MARGIN + (i+1)*15, (maleRank[i+1]+1)/2 + MARGIN);
      }
   } // end of drawMaleGraph()

} // end class PopularName
