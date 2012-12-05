import java.util.List;
import java.util.ArrayList;

/**
 * Times how long it takes to add elements to linked lists and
 * <code>ArrayList</code>s at the front or the back of the list.
 * 
 * @author Glenn Briones cs12faq
 */

public class TimeList
{
   /**
    * A <code>List12</code> object to be used for time testing.
    */
   static List<String> theL = new List12<String>();
   /**
    * An <code>ArrayList</code> object to be used for time testing.
    */
   static ArrayList<String> theA = new ArrayList<String>();


   public static void main(String[] args)
   {
      double average = 0.0;
      double stdDev = 0.0;
      double[] timeData; //array to store time data on adding elements to a list
      
      
      if(args[0].equals("linked"))
      {
	 if(args[1].equals("front"))
	 {
	    //Test adding to front of linked list
	    for(int N = 2000; N <= 50000; N += 1000)
	    {
	       int R = 100000/N; //The number of runs to make
	       timeData = timeAddToFrontList(N, R);
	       average = computeAverage(timeData);
	       stdDev = computeStdDev(average, timeData);
	       printResult(N, average, stdDev);
	    }
	 }
	 else if (args[1].equals("back"))
	 {
	    //Test adding to back of linked list
	    for(int N = 2000; N <= 50000; N += 1000)
	    {
	       int R = 100000/N; //the number of runs to make
	       timeData = timeAddToBackList(N,R);
	       average = computeAverage(timeData);
	       stdDev = computeStdDev(average, timeData);
	       printResult(N, average, stdDev);
	    }
	 }
	 else System.out.println("2nd argument must be 'front' or 'back'");
      }

      else if (args[0].equals("array"))
      {
	 if(args[1].equals("front"))
	 {
	    //Test adding to front of arrayList
	    for(int N = 2000; N <= 50000; N += 1000)
	    {
	       int R = 100000/N; //the number of runs to make
	       timeData = timeAddToFrontArray(N, R);
	       average = computeAverage(timeData);
	       stdDev = computeStdDev(average, timeData);
	       printResult(N, average, stdDev);
	    }
	 }
	 else if(args[1].equals("back"))
	 {
	    //Test adding to back of arrayList
	    for(int N = 2000; N <= 50000; N += 1000)
	    {
	       int R = 100000/N;
	       timeData = timeAddToBackArray(N, R);
	       average = computeAverage(timeData);
	       stdDev = computeStdDev(average, timeData);
	       printResult(N, average, stdDev);
	    }
	 }
	 else System.out.println("2nd argument must be 'front' or 'back'");
      }

      else System.out.println("1st argument must be 'linked' or 'array'");
   }

   /**
    * Times how long it takes to add N elements to the front of a singly-linked 
    * list and stores the data from each run in an array.
    *
    * @param N the number of elements to add
    * @param R the number of runs to make
    * @return an array of <tt>double</tt>s that contains the times for each run 
    */
   private static double[] timeAddToFrontList(int N, int R)
   {
      double[] timeData = new double[R];

      //Controls the number of runs
      for(int i=0; i<R; i++)
      {
	 System.gc();

	 long start = System.nanoTime(); 
	 //Controls the number of elements to add
	 for(int j=0; j<N; j++)
	 {
	    theL.add(0, null); //Add to front
	 }
	 long end = System.nanoTime();
	 theL.clear(); //Clear the ilst for the next run

	 //Add the time in seconds to timeData
	 timeData[i] = (end - start) / 1.0e9;
      }

      return timeData;
   }

   /**
    * Times how long it takes to add N elements to the back of a singly-linked
    * list and stores the data from each run in an array.
    * 
    * @param N the number of elements to add
    * @param R the number of runs to make
    * @return an array of <tt>double</tt>s that contains the times for each run
    */
   private static double[] timeAddToBackList(int N, int R)
   {
      double[] timeData = new double[R];

      for(int i=0; i<R; i++)
      {
	 System.gc();

	 long start = System.nanoTime();
	 for(int j=0; j<N; j++)
	 {
	    theL.add(j, null); //Add to back
	 }
	 long end = System.nanoTime();
	 theL.clear();

	 timeData[i] = (end - start) / 1.0e9;
      }

      return timeData;
   }

   /**
    * Times how long it takes to add N elements to the front of an
    * <code>ArrayList</code> and stores the data from each run in an array.
    * 
    * @param N the number of elements to add
    * @param R the number of runs to make
    * @return an array of <tt>double</tt>s that contains the times for each run
    */
   private static double[] timeAddToFrontArray(int N, int R)
   {
      double[] timeData = new double[R];

      for(int i=0; i<R; i++)
      {
	 System.gc();

	 long start = System.nanoTime();
	 for(int j=0; j<N; j++)
	 {
	    theA.add(0, null);
	 }
	 long end = System.nanoTime();
	 theA.clear();

	 timeData[i] = (end - start) / 1.0e9;
      }

      return timeData;
   }

   /**
    * Times how long it takes to add N elements to the back of an 
    * <code> ArrayList</code> and stores the data from each run in an array.
    *
    * @param N the number of elements to add
    * @param R the number of runs to make
    * @return an array of <tt>double</tt>s that contains the times for each run
    */
   private static double[] timeAddToBackArray(int N, int R)
   {
      double[] timeData = new double[R];

      for(int i=0; i<R; i++)
      {
	 System.gc();

	 long start = System.nanoTime();
	 for(int j=0; j<N; j++)
	 {
	    theA.add(j, null);
	 }
	 long end = System.nanoTime();
	 theA.clear();

	 timeData[i] = (end - start) / 1.0e9;
      }

      return timeData;
   }

   /**
    * Computes the average of the times in the <code>timeData</code>
    * array and returns the average.
    *
    * @param timeData the array of times from which to calculate the average
    * @return the average of the times in the array of times
    */
   private static double computeAverage(double[] timeData)
   {
      double sum = 0.0;

      for(int i=0; i<timeData.length; i++) sum += timeData[i];

      return sum / timeData.length;
   }

   /**
    * Computes the standard deviation of the times in the specified array
    * of time data.
    *
    * @param average the average of the times in the data array
    * @param timeData the array of data to calculate the sum/average of the
    *                 squares to be used in the standard deviation calculation
    * @return the standard deviation of the times
    */
   private static double computeStdDev(double average, double[] timeData)
   {
      double sumSquaredTime = 0.0;
      for(int i=0; i<timeData.length; i++)
	 sumSquaredTime += timeData[i]*timeData[i];
      
      double avgSquaredTime = sumSquaredTime / timeData.length;

      return Math.sqrt(avgSquaredTime - average*average);
   }

   /**
    * Prints N the number of elements added to the list, the average
    * of the times it took to add N elements to the list, and the standard
    * deviation of the times it took to add N elements to the list.
    *
    * @param N the number of elements added to the list
    * @param average the average of the times it took to add N elements
    * @param stdDev the standard deviation of the times it took to add N
    *               elements
    */
   private static void printResult(int N, double average, double stdDev)
   {
      System.out.printf("%d\t%.6f\t%.6f\n", N, average, stdDev);
   }
}
