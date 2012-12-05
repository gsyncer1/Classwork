/*
 * Name: 	Glenn Briones
 * Account:	cs8wfs
 * HW: 		Homework 6 - ARectangle
 * Date:	May 18, 2011
 *
 * File: 	ARectangle.java
 *
 * Sources of Help: None
 *
 * Describes a rectangular shape with an upper left point.
 */

 /**
  * class ARectangle
  * 	An abstract class to describe a rectangular shape with an
  *	upper-left point. 
  *	Extends abstract class Shape give Rectangular shapes a name.
  */

public abstract class ARectangle extends Shape
{
   // Fields
   private Point upperLeft;

   // Constructors
   public ARectangle()
   {
      super("ARectangle");
      this.setUpperLeft( new Point(0,0) );
   }

   public ARectangle( String name, int x, int y )
   {
      super(name);
      this.setUpperLeft( new Point(x,y) );
   }

   public ARectangle( String name, Point upperLeft )
   {
      super(name);
      this.setUpperLeft( new Point(upperLeft) );
   }

   public ARectangle( ARectangle r )
   {
      super( new String(r.getName()) );
      this.setUpperLeft( new Point(r.getUpperLeft()) );
   }

   // Methods

   /* move()
    * 	Moves the upper left corner of the rectanglular shape xDelta left
    * 	or right and yDelta pixels up or down.
    *	Parameters: int xDelta to move point left and right
    *		    int yDelta to move point up and down
    *	Return: void
    */
   public void move( int xDelta, int yDelta )
   {
      this.getUpperLeft().move(xDelta, yDelta);
   }

   /* toString()
    *	Overrides superclass's toString() method to show the coordinates
    *	of the upper left corner of the rectangular shape.
    *		Parameters: none
    *		Return: String - Description of rectangular object.
    */
   public String toString()
   {
      return this.getName() + ": Upper-left Corner: " + this.getUpperLeft();
   }

   /* equals()
    *	Determines whether the object passed in has the same upper-left corner
    *	as this object.
    *		Parameters: Object o - to be determined if equal
    *		Return: boolean - to determine if they are equal.
    */
   public boolean equals( Object o )
   {
      if( o == null ) return false;
      
      if( o.getClass() != this.getClass() ) return false;

      if(( (Rectangle) o).getUpperLeft().equals(this.getUpperLeft()) ) 
	 return true;

      return false;
   }

   // Accessor Method
   /* getUpperLeft()
    * 	Returns the upper left Point of the rectangular shape.
    *	Takes no parameters.
    */
   public Point getUpperLeft()
   {
      return this.upperLeft;
   }

   // Mutator method
   /* setUpperLeft()
    * 	Sets the upper left corner of the rectangular object to the point
    * 	passed in as a parameter.
    *	Return value: void
    */
   private void setUpperLeft( Point p )
   {
      this.upperLeft = p;
   }
}
