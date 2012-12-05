/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 8 - ReverseRecurse
 * Date:	June 2, 2011
 *
 * File:	ReverseRecurse.java
 *
 * Sources of Help: None
 *
 * An application that reads integer values from the keyboard into an array
 * whose size is specified by the user, and reverses the elements in the array
 * via two different recursive methods.
 */

import java.util.*;

/**
 * class ReverseRecurse.
 * 	A class that contains all the methods that creates and populates the
 *	integer arrays, prints the arrays, and reverses the arrays.
 *	Contains no constructor (no-arg ctor inserted by compiler).
 */

public class ReverseRecurse
{
  /**
   * initArray().
   *	This method handles the creation and population of the elements
   *	of the integer array.
   *	Parameters: none
   *	Return value: int[] - initialized array
   */
  public int[] initArray()
  {
    Scanner console = new Scanner(System.in);
    int maxInt = 0, i;
    boolean success = false; //to indicate receipt of valid maxInt

    System.out.print("Maximum number of integers wish to enter? ");
    while(console.hasNextInt())
    {
      maxInt = console.nextInt();
      if(maxInt > 0) //maxInt is valid, break the loop
      {
	success = true; //Indicate success of valid maxInt
	break;
      }
      else
      {
	//prompt user that maxInt must be > 0
	System.out.println("You must enter a value > 0; Try again.\n");
	System.out.print("Maximum number of integers wish to enter? ");
      }
    }

    //Exit java application if no valid maxInt was entered.
    if(!success)
    {
      System.exit(1);
    }

    int[] initArr = new int[maxInt];

    System.out.printf("\nEnter up to %d integers:\n", maxInt);
    //Populate array with integers from user input
    for(i=0; i < maxInt && console.hasNextInt(); i++)
    {
      initArr[i] = console.nextInt();
    }

    if(i == 0) //initArr created, but no integers were entered.
    {
      System.out.println("No elements put in");
      int[] emptyArr = new int[0];
      return emptyArr;
    }
    else if(i == maxInt) //all elements of array were filled
    {
      return initArr;
    }
    else //not all elements of array were filled, return a resized array
    {
      int[] newArr = new int[i];
      System.arraycopy(initArr, 0, newArr, 0, i);
      return newArr;
    }
  }

  /**
   * printArray().
   * 	Prints the elements of the passed-in array.
   *	(Prints "empty array" if the array contains no elements.)
   *	Parameters: int[] array - Array whose elements will be printed
   * 	Return value: void
   */
  public void printArray(int[] array)
  {
    //check if array has no elements --> 0 length
    if(array.length == 0 || array == null)
    {
      System.out.println("Empty array");
    }
    else
    {
      for(int i=0; i<array.length; i++)
      {
	System.out.print(array[i] + " ");
      }
      System.out.println("\n");
    }
  }

  /**
   * reverse().
   *	Directly reverses the passed-in array by exchanging the high and low
   *	index values and recursing on the middle elements.
   *	Parameters: int[] originalArray - array to be reversed
   *		    int low - index of low index
   *		    int high - index of high index
   *	Return: void
   */
  public void reverse(int[] originalArray, int low, int high)
  {
    int temp;

    //Recursive case
    if(low <= high)
    {
      //Exchange the elements of the low and high index
      temp = originalArray[low];
      originalArray[low] = originalArray[high];
      originalArray[high] = temp;
      //Recurse on middle elements
      reverse(originalArray, low+1, high-1);
    }

    //Base case: low > high
    //Nothing happens
  }

  /**
   * reverse().
   * 	Returns a reversed array by building a new array with all of the
   *	elements of the original array reversed.
   *	Parameters: int[] originalArray - array to be reversed
   *	Return value: int[] - the reversed array
   */
  public int[] reverse(int[] originalArray)
  {
    int[] arrCopy = new int[originalArray.length]; //create a copy of the array

    //Base cases
    if(arrCopy.length==0) //Array is empty, return the empty array
    {
      return arrCopy;
    }
    else if(arrCopy.length==1) //Copy the element and return the array
    {
      arrCopy[0] = originalArray[0];
      return arrCopy;
    }
    else if(arrCopy.length==2) //Copy two elements in reverse order, return
    {
      arrCopy[0] = originalArray[1];
      arrCopy[1] = originalArray[0];
      return arrCopy;
    }
    //Recursive case
    else
    {
      //Create an array for the middle elements of the passed-in array
      int[] midArr = new int[originalArray.length-2];
      
      //Switch the elements of the edges of the array
      arrCopy[0] = originalArray[originalArray.length-1];
      arrCopy[arrCopy.length-1] = originalArray[0];

      //Copy the middle elements of the original Array to the midArr
      System.arraycopy(originalArray, 1, midArr, 0, midArr.length);
      //Reverse the midArr
      midArr = this.reverse(midArr);
      //Copy the midARr back into the array copy
      System.arraycopy(midArr, 0, arrCopy, 1, midArr.length);
      //Return the Array copy, now reversed
      return arrCopy;
    }
  }

} // end class ReverseRecurse
