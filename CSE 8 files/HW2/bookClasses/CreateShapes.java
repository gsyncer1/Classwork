/*
* Filename: CreateShapes.java
* Name: Glenn Briones, Kelly Lim
* Login: cs8wfs, cs8wfb
* Date: January, 17 2011
* File: createShapes.java
* Sources of Help: None
*
* Creates new World world1, and four turtles. Turtles draw 4 hexagons nested within each other.
*/

public class CreateShapes
{
 /*
  * Name: main
  * Purpose: 4 turtles create 4 hexagons nested within each other
  * Parameters: None
  * Return: void
  */
  
  public static void main (String[] args)
  {
    World world1 = new World();
    Turtle turtle1 = new Turtle(215,273,world1);
    Turtle turtle2 = new Turtle(210,282,world1);
    Turtle turtle3 = new Turtle(205,291,world1);
    Turtle turtle4 = new Turtle(200,300,world1);
    
    
    //draw shape int value = side length of hexagon
    turtle1.drawShape(10);
    turtle2.drawShape(20);
    turtle3.drawShape(30);
    turtle4.drawShape(40);
  }
}