/*
 * Name: 	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 6 - Triangle
 * Date: 	May 18, 2011
 *
 * File:	Triangle.java
 *
 * Sources of Help: None
 *
 * A java file that describes a triangular shape.
 */

import java.awt.*;

/**
 * class Triangle
 * 	A class that describes a triangle with 3 points connected by
 * 	3 lines. Extends shape to give triangle its shape name.
 */

public class Triangle extends Shape
{
   // Fields
   private Point p1;
   private Point p2;
   private Point p3;

   // Constructors
   public Triangle()
   {
      super("Triangle");
      this.setP1( new Point (0,0) );
      this.setP2( new Point (0,0) );
      this.setP3( new Point (0,0) );
   }

   public Triangle( Point p1, Point p2, Point p3 )
   {
      super("Triangle");
      this.setP1( new Point(p1) );
      this.setP2( new Point(p2) );
      this.setP3( new Point(p3) );
   }

   public Triangle( Triangle tri )
   {
      super("Triangle");
      this.setP1( new Point(tri.getP1()) );
      this.setP2( new Point(tri.getP2()) );
      this.setP3( new Point(tri.getP3()) );
   }

   // Methods

   /* move()
    * 	Moves each of the three points of the triangle up or down yDelta
    *	pixels and left or right xDelta pixels.
    *	Parameters - int xDelta - to move points left or right
    * 		     int yDelta - to move points up or down
    * 	Return value: void
    */
   public void move( int xDelta, int yDelta )
   {
      this.getP1().move(xDelta, yDelta);
      this.getP2().move(xDelta, yDelta);
      this.getP3().move(xDelta, yDelta);
   }

   /* toString()
    *	Overrides the superclass's toString method to display the name of the
    * 	shape and to show the coordinates of the triangle's three points.
    *	Parameters: none
    *	Return value: String - Description of triangle
    */
   public String toString()
   {
      return this.getName() + ": " + this.getP1() + ", " + this.getP2() + ", " 
      	+ this.getP3();
   }

   /* equals()
    * 	Determines whether the object passed in as a parameter is the same
    *   as this triangle. If the object passed in is a triangle, it compares
    *	each of their three points.
    *	Parameters: Object o - object to be compared
    * 	Return value: boolean - to indicate whether the two objects are equal
    */
   public boolean equals( Object o )
   {
      if( o == null ) return false;
      
      if( o.getClass() != this.getClass() ) return false;

      if( this.getP1().equals(( (Triangle) o).getP1()) &&
	  this.getP2().equals(( (Triangle) o).getP2()) &&
	  this.getP3().equals(( (Triangle) o).getP3()) )
	 return true;

      return false;
   }

   /* draw()
    * 	Draws the triangle by connecting the three points with lines.
    * 	Parameters: Graphics g - to draw the sides of the triangle.
    * 		    Color c - to set the color of the triangle
    * 		    boolean fill - not used for this shape
    *	Return value: void
    */
   public void draw( Graphics g, Color c, boolean fill )
   {
      if(c == null) g.setColor(Color.BLACK);
      else g.setColor(c);

      //p1 to p2
      g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
      //p2 to p3
      g.drawLine(p2.getX(), p2.getY(), p3.getX(), p3.getY());
      //p3 to p1
      g.drawLine(p3.getX(), p3.getY(), p1.getX(), p1.getY());
   }

   // Accessors
   /* getP1()
    * 	Returns the point object P1 of the triangle object
    *	Parameters: None
    */
   public Point getP1()
   {
      return this.p1;
   }

   /* getP2()
    * 	Returns the point object p2 of the triangle object
    * 	Parameters: None
    */
   public Point getP2()
   {
      return this.p2;
   }

   /* getP3()
    * 	Returns the point object p3 of the triangle object
    * 	Parameters: None
    */
   public Point getP3()
   {
      return this.p3;
   }

   // Mutators
   /* setP1()
    * 	Sets the point p1 of the triangle object to the point passed in as
    * 	an argument. Return value: void
    */
   private void setP1( Point p1 )
   {
      this.p1 = p1;
   }

   /* setP2()
    * 	Sets the point p2 of the triangle object to the point passed in as
    * 	an argument. Return value: void
    */
   private void setP2( Point p2 )
   {
      this.p2 = p2;
   }

   /* setP3()
    * 	Sets the point p3 of the triangle object to the point passed in as
    * 	an argument. Return value: void
    */
   private void setP3( Point p3 )
   {
      this.p3 = p3;
   }
}
