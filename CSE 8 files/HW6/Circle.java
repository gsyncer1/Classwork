/*
 * Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 6 - Circle
 * Date:	May 17, 2011
 *
 * File:	Circle.java
 *
 * Sources of Help: None
 *
 * A java file to describe a circle shape with a center point and
 * a radius.
 */

import java.awt.*;

/**
 * class Circle
 * 	Describes a Circle object with a center point and a radius.
 *	Extends abstract class shape to give circle its shape name.
 */

public class Circle extends Shape
{
   // Fields
   private Point center;
   private int radius;

   //Constructors
   public Circle()
   {
      super("Circle");
      this.setCenter( new Point (0,0) );
      this.setRadius(0);
   }

   public Circle( Point center, int radius )
   {
      super("Circle");
      this.setCenter(center);
      this.setRadius(radius);
   }

   public Circle( Circle c )
   {
      super("Circle");
      this.setCenter( new Point(c.getCenter()) );
      this.setRadius( c.getRadius() );
   }

   // Methods

   /* move()
    * Moves the center of the circle left or right by xDelta pixels
    * and up or down yDelta pixels.
    * Parameters: xDelta - To move center left or right.
    *		  yDelta - To move center up or down.
    * Return value: void
    */
   public void move( int xDelta, int yDelta )
   {
      this.getCenter().move(xDelta, yDelta);
   }

   /* toString()
    * Overrides the superclass's toString() method to show that the shape
    * is a circle, its center point, and radius.
    * Parameters: none
    * Return value: String - Description of circle
    */
   public String toString()
   {
      return this.getName() + ": Center: " + this.getCenter().toString()
      		+ "; Radius: " + this.getRadius();
   }

   /* equals()
    * Determines whether the object passed in as a parameters is equal
    * to this circle by comparing the center and radius.
    * Return value: boolean - to indicate whether they are the same
    */
   public boolean equals( Object o )
   {
      if( o == null ) return false;

      if( o.getClass() != this.getClass() ) return false;

      if( ((Circle) o).getCenter().equals(this.getCenter()) && 
	 ((Circle) o).getRadius() == this.getRadius() )
	 return true;

      return false;
   }

   /* draw()
    * 	Draws the circle according to the circle object's center point
    *	and radius.
    *	Parameters: Graphics g  - to draw the object
    *		    Color c - to set color of graphics object
    *		    boolean fill - to determine whether the circle is
    *				 filled in
    *	Return value: void
    */
   public void draw( Graphics g, Color c, boolean fill )
   {
      if( c == null ) g.setColor(Color.BLACK);
      else g.setColor(c);
      
      if(fill)
      {
	 g.fillOval(this.getCenter().getX() - this.getRadius(),
	 		this.getCenter().getY() - this.getRadius(),
			this.getRadius()*2, this.getRadius()*2);
      }
      else
      {
	 g.drawOval(this.getCenter().getX() - this.getRadius(),
	 		this.getCenter().getY() - this.getRadius(),
			this.getRadius()*2, this.getRadius()*2);
      }
   }

   // Accessors
   /* getCenter()
    * 	Returns the center point of the circle.
    *	Parameters: none
    */
   public Point getCenter()
   {
      return this.center;
   }

   /* getRadius()
    * 	Returns the radius of the circle.
    *	Parameters: None
    */
   public int getRadius()
   {
      return this.radius;
   }

   // Mutators
   /* setCenter()
    * 	Sets the center point of the circle to the point passed in as 
    * 	an argument. Return value: void
    */
   private void setCenter( Point center )
   {
      this.center = center;
   }

   /* setRadius
    * 	Sets the radius of the circle to the integer passed in as a 
    * 	parameter. Return value: void
    */
   private void setRadius( int radius )
   {
      this.radius = radius;
   }
}
