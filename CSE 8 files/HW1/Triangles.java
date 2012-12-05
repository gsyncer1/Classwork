/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 1 - Triangles
 * Date:	April 5, 2011
 * 
 * File:	Triangles.java
 * 
 * Sources of Help: None
 *
 * The program prints four triangles of a size inputted by the user.
 */

 import java.util.*;

/**
 * class Triangles
 * The class contains a program that prints four triangles of a
 * size defined by the user.
 */

public class Triangles
{
   
   public static final int MIN_SIZE = 2;

   /**
    * main() is the driver of this application.
    * 
    * The method scans for an integer that defines the
    * size of the triangles. It keeps asking until it gets
    * a valid size (no less than MIN_SIZE).
    * It then prints four differently oriented triangles
    * with their sizes the length of what the user inputted.
    *
    * Params:	String[] args - Not used.
    * Return Value: 	None
    */

    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
	int triangleSize, i;

	System.out.print("Enter the size of the triangles to display: ");
	triangleSize = input.nextInt();
	/* Check if input is a valid triangle size
	 * Keep asking if not valid
	 */
	while(triangleSize < MIN_SIZE)
	{
	    System.out.println("\nTriangle size must be > 1. Try again.\n");
	    System.out.print("Enter the size of the triangles to display: ");
	    triangleSize = input.nextInt();
	}

	//Print the four triangles
	for(int line = 0; line < triangleSize; line++)
	{
	    //First triangle
	    for(i = 0; i < triangleSize; i++)
	    {
		if(i <= line) System.out.print('*');
		else System.out.print(' ');
	    }
	    System.out.print(' ');
	    //Second triangle
	    for(i = triangleSize; i >= 0; i--)
	    {
		if(i > line) System.out.print('*');
		else System.out.print(' ');
	    }
	    System.out.print(' ');
	    //Third triangle
	    for(i = 0; i < triangleSize; i++)
	    {
		if(i < line) System.out.print(' ');
		else System.out.print('*');
	    }
	    System.out.print(' ');
	    //Fourth triangle
	    for(i = triangleSize; i >= 0; i--)
	    {
		if(i > line) System.out.print(' ');
		else System.out.print('*');
	    }
	    System.out.println();
	}
    } /* end of main() */
} /* end of class Triangle */
