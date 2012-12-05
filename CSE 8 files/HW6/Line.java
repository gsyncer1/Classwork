/**
 * Name: 	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 6 - Line
 * Date: 	May 16, 2011
 *
 * File:	Line.java
 *
 * Sources of Help: None
 *
 * A java file to describe a line with a start and end point.
 */

import java.awt.*;

/**
 * class Line
 *	Defines a line object with a start and end point.
 *	Contains methods that move and draw the line as well as the overriding
 *	methods toString() and equals(). Extends abstract class shape to give 
 *	line its shape name.
 */

public class Line extends Shape
{
   // Fields
   private Point start;
   private Point end;

   // Constructors
   public Line()
   {
      super("Line");
      this.setStart(new Point(0,0));
      this.setEnd(new Point (0,0));
   }

   public Line( Point start, Point end )
   {
      super("Line");
      this.setStart( new Point (start) );
      this.setEnd( new Point (end) );
   }

   public Line( Line line )
   {
      super("Line");
      this.setStart( new Point(line.getStart()) );
      this.setEnd( new Point(line.getEnd()) );
   }

   // Methods
   
   /* move()
    * 	Moves the start and end points left or right xDelta pixels
    *   and up or down yDelta pixels.
    * 	Parameters: int xDelta - to move start and end points left or right
    *		    int yDelta - to move start and end point up or down
    * 	Return value: void
    */
   public void move( int xDelta, int yDelta )
   {
      this.getStart().move(xDelta, yDelta);
      this.getEnd().move(xDelta, yDelta);
   }

   /* toString()
    * 	Overrides the superclass's toString() method to show the shape's name
    * 	and its start and end points.
    * 	Parameters: None
    * 	Return value: String - description of line
    */
   public String toString()
   {
      return "Line: " + start.toString() + " to " + end.toString();
   }

   /* equals()
    * 	Determines whether the object passed in as a parameter is the equal
    * 	to this line object by comparing its start and end points. Equal if
    *	object isn't a null reference, the same class, and has the same start
    *	and end points.
    *	Parameters: Object o - Object to be compared.
    * 	Return value: boolean - to indicate whether they are equal
    */
   public boolean equals( Object o)
   {
      if( o == null)
	 return false;

      if( this.getClass() != o.getClass() )
	 return false;

      if(( (Line) o).getStart().equals(this.getStart()) && 
	 ( (Line) o).getEnd().equals(this.getEnd()) )
	 return true;

      return false;
   }

   /* draw()
    * 	Draws the line.
    *	Parameters: Graphics g - to draw line
    * 		    Color c - to set the color of the line
    *		    boolean fill - not used in this draw method
    *	Return value: void
    */
   public void draw( Graphics g, Color c, boolean fill )
   {
      if( c == null) g.setColor(Color.BLACK);
      else g.setColor(c);

      g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
   }

   // Accessor methods

   /* getStart()
    *	Returns the start point object of this line.
    * 	Parameters: None
    */
   public Point getStart()
   {
      return this.start;
   }

   /* getEnd()
    * 	Returns the end point object of this line.
    * 	Parameters: None
    */
   public Point getEnd()
   {
      return this.end;
   }

   // Mutator methods

   /* setStart()
    * 	Sets the start point of the line to the point object passed
    * 	in as an argument. Return value: void
    */
   private void setStart( Point p )
   {
      this.start = p;
   }

   /* setEnd()
    * 	Sets the end point of the line to the point object passed
    *	in as an argument. Return value: void
    */
   private void setEnd( Point p )
   {
      this.end = p;
   }
}
