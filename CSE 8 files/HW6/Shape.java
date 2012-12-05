/*
 * Name:	Glenn Briones
 * Account: 	cs8wfs
 * HW:		Homework 6 - Shape
 * Date:	May 18, 2011
 *
 * File:	Shape.java
 *
 * Sources of Help: None
 *
 * Describes an abstract shape of some name.
 */

import java.awt.*;

/**
 * class Shape
 *	Abstract class that describes the type of shape and contains abstract
 * 	methods that Shape subclasses will implement.
 */

public abstract class Shape
{
   // Fields
   private String name;

   // Constructors
   public Shape()
   {
      this("Shape");
   }

   public Shape( String name )
   {
      this.setName(name);
   }

   /* Accessor Method
    * getName()
    * 	Parameters: None
    *	Return:	String - name of shape
    */
   public String getName()
   {
      return this.name;
   }

   /* Mutator Method
    * setName()
    *	Parameters: String name - to set the name of the shape
    * 	Return: void
    */
   private void setName( String name )
   {
      this.name = name;
   }

   // Abstract methods - implemented by shape subclasses
   public abstract void move ( int xDelta, int yDelta );

   public abstract void draw ( Graphics g, Color c, boolean fill );
}
