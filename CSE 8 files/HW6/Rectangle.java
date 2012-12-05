/*
 * Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 6 - Rectangle
 * Date: 	May 18, 2011
 *
 * File;	Rectangle.java
 *
 * Sources of Help: None
 *
 * Describes a rectangle with a width and height and upper left corner at
 * a point.
 */

import java.awt.*;

/**
 * Class Rectangle
 * 	This class extends ARectangle with an upper left corner and has
 * 	a width and a height. Extends abstract class ARectangle to 
 *	put the upper left corner at a point.
 */

public class Rectangle extends ARectangle
{
   // Fields
   private int width;
   private int height;

   // Constructors
   public Rectangle()
   {
      super("Rectangle", 0, 0);
      this.setWidth(0);
      this.setHeight(0);
   }

   public Rectangle(int x, int y, int width, int height)
   {
      super("Rectangle", x, y);
      this.setWidth(width);
      this.setHeight(height);
   }

   public Rectangle(Point upperLeft, int width, int height)
   {
      super("Rectangle", new Point(upperLeft));
      this.setWidth(width);
      this.setHeight(height);
   }

   public Rectangle(Rectangle r)
   {
      super("Rectangle", new Point(r.getUpperLeft()) );
      this.setWidth(r.getWidth());
      this.setHeight(r.getHeight());
   }

   //Methods
   /* toString()
    * 	Overrides the superclass's toString method to give display the shape
    * 	name,the coordinates of the upper left corner, and its dimensions.
    * 	Parameters: none
    *	Return value: String - to describe Rectangle
    */
   public String toString()
   {
      return this.getName() + ": Upper Left Corner: " + this.getUpperLeft() +
      	"; Width: " + this.getWidth() + "; Height: " + this.getHeight();
   }

   /* equals()
    * 	Determines whether the object passed in as a parameter is the same as
    * 	this rectangle object. They are equal if the Object isn't null, is the
    *	same object, the points of the upper left corners coincide, have the
    * 	same width, and have the same height.
    *	Parameters: Object o - to be compared
    *	Return value: boolean - to indicate of they are equal
    */
   public boolean equals(Object o)
   {
      if( o == null ) return false;

      if( o.getClass() != this.getClass() ) return false;

      if(this.getUpperLeft().equals(( (Rectangle) o).getUpperLeft()) &&
	 this.getWidth() == ((Rectangle) o).getWidth() &&
	 this.getHeight() == ((Rectangle) o).getHeight() )
	 return true;

      return false;
   }

   /* draw()
    * 	Draws the Rectangle
    * 	Parameters: Graphics g - to draw the Rectangle
    *		    Color c - to set the color of the rectangle
    * 		    boolean - to indicate if the rectangle is filled
    */
   public void draw( Graphics g, Color c, boolean fill )
   {
      if( c == null ) g.setColor(Color.BLACK);
      else g.setColor(c);

      if(fill)
      {
	 g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(),
	 		this.getWidth(), this.getHeight() );
      }
      else
      {
	 g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(),
	 		this.getWidth(), this.getHeight() );
      }
   }

   // Accessors
   /* getWidth()
    * 	Returns the integer width of the rectangle object.
    *	Parameters: none
    */
   public int getWidth()
   {
      return this.width;
   }

   /* getHeight()
    * 	Returns the integer height of the rectangle object.
    * 	Parameters: none
    */
   public int getHeight()
   {
      return this.height;
   }

   // Mutators
   /* setWidth()
    * 	Sets the width of the rectangle to the integer passed in as an
    * 	argument. Return value: void
    */
   private void setWidth( int w )
   {
      this.width = w;
   }

   /* setHeight()
    * 	Sets the Height of the rectangle to the integer passed in as an
    * 	argument. Return value: void
    */
   private void setHeight( int h )
   {
      this.height = h;
   }
}
