/*
 * Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 6 - Point
 * Date:	May 18, 2011
 *
 * File:	Point.java
 *
 * Sources of Help: None
 *
 * A java file to describe a point with an x and y coordinate.
 * This is used by other shape java classes to determine the position
 * of the shapes.
 */


/**
 * class Point
 *	Represents a point with an x- and y-coordinate.
 */
public class Point
{
   // Fields
   private int x;
   private int y;

   // Constructors
   public Point()
   {
      this(0,0);
   }

   public Point( int x, int y )
   {
      this.setX(x);
      this.setY(y);
   }

   public Point( Point point )
   {
      this.setX(point.getX()); // Problem with references?
      this.setY(point.getY());
   }

   // Accessors
   /* getX()
    * 	Returns the x coordinate of the point.
    * 	Parameters: None
    */
   public int getX()
   {
      return this.x;
   }

   /* getY()
    * 	Returns the y coordinate of the point.
    * 	Parameters: None
    */
   public int getY()
   {
      return this.y;
   }

   // Mutators
   /* setX()
    * Sets the x coordinate of the point to the integer passed in
    * as an argument.
    * Return value: void
    */
   private void setX( int x ) // Private: Points are immutable
   {
      this.x = x;
   }

   /* setY()
    * 	Sets the y coordinate of the point to the integer passed in
    * 	as an argument.
    * 	Return value: void
    */
   private void setY( int y ) // Private: Points are immutable
   {
      this.y = y;
   }

   // Methods
   /* move()
    * 	Moves the point left or right xDelta pixels and moves the point
    * 	up or down yDelta pixels.
    * 	Parameters: int xDelta - to move point left or right
    * 		    int yDelta - to move point up or down
    * 	Return value: void
    */
   public void move( int xDelta, int yDelta )
   {
      this.setX(this.getX() + xDelta);
      this.setY(this.getY() + yDelta);
   }

   /* toString()
    * 	Overrides the superclass's toString method to show the x and y
    * 	coordinates of the point
    *	Parameters: None
    *	Return value: String - to display the x and y coordinates of the point
    */
   public String toString()
   {
      return "Point: (" + getX() + "," + getY() + ")";
   }

   /* equals()
    * 	Determines whether the object passed in as a parameter is the same as
    *	this point object. They are equal if the object isn't null, is the same
    *	class and has the same x and y coordinate.
    *	Parameters: Object o - Object to be compared
    *	Return value: boolean - to indicate whether the objects are equal.
    */
   public boolean equals( Object o )
   {
      if( o == null )
      {
	 return false;
      }

      if( this.getClass() != o.getClass() )
      {
	 return false;
      }

      if( this.getX() == ( (Point) o ).getX() && 
	  this.getY() == ( (Point) o ).getY() )
	 return true;

      return false;
   }
}
