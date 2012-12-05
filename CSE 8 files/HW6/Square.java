/*
 * Name: 	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 6 - Square
 * Date:	May 18, 2011
 *
 * File:	Square.java
 *
 * Sources of Help: None
 *
 * A java file to describe a square with a side length.
 */

import java.awt.*;

/**
 * class Square
 *	A class describes a square (with equal length sides, hence only
 * 	one int instance variable side) with which inherits the upper
 *	left corner instance variable from ARectangle.
 */

public class Square extends ARectangle
{
   // Fields
   private int side;

   // Constructors
   public Square()
   {
      super("Square", 0, 0);
      this.setSide(0);
   }

   public Square( int x, int y, int side )
   {
      super("Square", x, y);
      this.setSide(side);
   }

   public Square( Point upperLeft, int side )
   {
      super("Square", new Point(upperLeft) );
      this.setSide(side);
   }

   public Square( Square r )
   {
      super("Square", new Point(r.getUpperLeft()));
      this.setSide(r.getSide());
   }

   // Methods

   /* toString()
    * 	Overrides the superclass's toString method to show the shape's name,
    *	the coordinates of the upper left corner, and the side length.
    *	Parameters: none
    *	Return value: String - to describe the square
    */
   public String toString()
   {
      return this.getName() + ": Upper Left Corner: " + this.getUpperLeft() +
      	"; Sides: " + this.getSide();
   }

   /* equals()
    * 	Determines if the object passed in as a parameter is the same as this
    *	square object. The are equal if the object isn't null, is the same
    *	class, has an upperleft corner that coincides with this square object,
    *	and has the same side length.
    *	Parameters: Object o - to be compared
    *	Return value: boolean - to indicate if they are equal
    */
   public boolean equals( Object o )
   {
      if( o == null ) return false;

      if( o.getClass() != this.getClass() ) return false;

      if( this.getUpperLeft().equals(( (Square) o).getUpperLeft()) &&
	  this.getSide() == ( (Square) o).getSide() )
	 return true;

      return false;
   }

   /* draw()
    * 	Draws the square.
    *	Parameters: Graphics g - to draw the square
    *		    Color c - to set the color of the square
    *		    boolean fill - to determine if the square is filled
    *	Return value: void
    */
   public void draw( Graphics g, Color c, boolean fill )
   {
      if( c == null ) g.setColor(Color.BLACK);
      else g.setColor(c);

      if(fill)
      {
	 g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(),
	 		this.getSide(), this.getSide());
      }
      else
      {
	 g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(),
	 		this.getSide(), this.getSide());
      }
   }

   // Accessors
   /* getSide()
    * 	Returns the integer length of the square's side.
    *	Parameters: none
    */
   public int getSide()
   {
      return this.side;
   }

   // Mutators
   /* setSide()
    * 	Sets the side length of the square to the integer passed in as an
    * 	argument. Return value: void
    */
   private void setSide( int s )
   {
      this.side = s;
   }
}
