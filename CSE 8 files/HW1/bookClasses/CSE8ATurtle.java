/*
 * Name: Glenn brioens
 * Login: cs8wfs
 * Date: January 12, 2011
 * File: CSE8ATurtle.java
 * Sources of Help: Java API for SimpleTurtle
 *
 * Uses turtle to draw characters to create text:
 * CS8WFS
 * WINTER
 * 2011
 */

import java.awt.Color;

public class CSE8ATurtle extends Turtle
{
   private final static int CHAR_WIDTH = 40;
   private final static int LINE_WIDTH = 80;
   private final static int LINE_SPACE = LINE_WIDTH + 40;
   private final static int CHAR_SPACE = CHAR_WIDTH + 40;
   
   private final static int WORLD_WIDTH = 600;
   private final static int WORLD_HEIGHT = 400;
   
   public CSE8ATurtle()
   {
      super(new World(WORLD_WIDTH, WORLD_HEIGHT)); // Creates WORLD_WIDTH by WORLD_HEIGHT world.
   }
   
   private void drawC(int x, int y) // Draws letter C
   {
      penUp(); moveTo(x,y);
      turnToFace(getXPos()+1,getYPos()); // Face east
      penDown();
      forward(40);
      penUp();
      backward(40);
      turnRight();
      penDown();
      forward(80);
      turnLeft();
      forward(40);
   }
   
   private void drawS(int x, int y) // Draws letter S
   {
      penUp(); moveTo(x,y);
      turnToFace(getXPos()+1,getYPos()); // Face east
      penDown();
      forward(40);
      penUp();
      backward(40);
      turnRight();
      penDown();
      forward(40);
      turnLeft();
      forward(40);
      turnRight();
      forward(40);
      turnRight();
      forward(40);
   }
   
   private void draw8(int x, int y) // Draws number 8
   {
      penUp(); moveTo(x,y);
      turnToFace(getXPos()+1,getYPos()); // Face east
      penDown();
      forward(40);
      turnRight();
      forward(80);
      turnRight();
      forward (40);
      turnRight();
      forward(80);
      penUp();
      backward(40);
      turnRight();
      penDown();
      forward(40);
   }
   
   private void drawW(int x, int y) // Draws letter W
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos(),getYPos()+1); // Face south
     penDown();
     forward(80);
     turn(-135);
     forward (28);
     turn(90);
     forward(28);
     turn(-135);
     forward(80);
   }
   
   private void drawF(int x, int y) // Draws letter F
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos()+1,getYPos()); // Face east
     penDown();
     forward(40);
     penUp();
     backward(40);
     turnRight();
     penDown();
     forward(80);
     penUp();
     backward(40);
     turnLeft();
     penDown();
     forward(20);
   }
   
   private void drawI(int x, int y) // Draws letter I
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos()+1,getYPos()); // Face east
     penDown();
     forward(40);
     penUp();
     backward(20);
     turnRight();
     penDown();
     forward(80);
     penUp();
     turnLeft();
     backward(20);
     penDown();
     forward(40);
   }
     
   private void drawN(int x, int y) // Draws letter N
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos(),getYPos()+1); // Face south
     penDown();
     forward(80);
     penUp();
     backward(80);
     penDown();
     moveTo(getXPos()+40,getYPos()+80); //Draws slanted part of N
     turn(180);
     forward(80);
   }
   
   // Draws letter T
   private void drawT(int x, int y)
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos()+1,getYPos()); // Face east
     penDown();
     forward(40);
     penUp();
     backward(20);
     turnRight();
     penDown();
     forward(80);
   }
   
   // Draws letter E
   private void drawE(int x, int y)
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos()+1, getYPos()); // Face east
     
     /* The letter E will be drawn like the number 8 (draw8)
      * except that the pen is up while turtle moves
      * along right side of character.
      */
     penDown();
     forward(40);
     penUp();
     turnRight();
     forward(80);
     turnRight();
     penDown();
     forward(40);
     turnRight();
     forward(80);
     penUp();
     backward(40);
     turnRight();
     penDown();
     forward(20);
   }

   // Draws letter R
   private void drawR(int x, int y)
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos(), getYPos()+1); // Face south
     penDown();
     forward(80);
     penUp();
     backward(80);
     turnLeft();
     penDown();
     forward(40);
     turnRight();
     forward(40);
     turnRight();
     forward(40);
     moveTo(getXPos()+40,getYPos()+40); //Draws slanted part of R
   }
   
   // Draws number 2
   private void draw2(int x, int y)
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos()+1, getYPos()); // Face east
     penDown();
     forward(40);
     turnRight();
     forward(40);
     turnRight();
     forward(40);
     turnLeft();
     forward(40);
     turnLeft();
     forward(40);
   }
   
   // Draws number 0
   private void draw0(int x, int y)
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos()+1, getYPos()); // Face east
     penDown();
     forward(40);
     turnRight();
     forward(80);
     turnRight();
     forward(40);
     turnRight();
     forward(80);
   }
   
   //Draws number 1
   private void draw1(int x, int y)
   {
     /* Moves turtle to bottom left corner
      * of character */
     penUp(); moveTo(x,y+80);
     
     turnToFace(getXPos()+1,getYPos()); // Face east
     penDown();
     forward(40);
     penUp();
     backward(20);
     turnLeft();
     penDown();
     forward(80);
     turn(-135);
     forward(20);
   }
 
   //Draws red border around entire text
   private void drawBorder(int x, int y)
   {
     penUp(); moveTo(x,y);
     turnToFace(getXPos()+1, getYPos());
     
     //Setting pen color and width
     setPenWidth(8);
     setPenColor(Color.RED);
     
     penDown();
     forward(480);
     turnRight();
     forward(360);
     turnRight();
     forward(480);
     turnRight();
     forward(360);
   }
   
   
   
   
   /*
    * Name: CSE8ATurtle
    * Purpose: Uses previously defined functions to create
    *   CS8WFS
    *   WINTER
    *    2011
    * Parameters: None
    * Return: void
    */
   
   public static void main(String [] args) //Main function is here
   {
     CSE8ATurtle myTurtle = new CSE8ATurtle();
     
     int startX1 = 80, // Centers first line
         startX2 = 80, // Centers second line
         startX3 = 160; // Centers third line
     int startY = 40; // Centers text vertically
     
     int x,y;
     
     myTurtle.setPenWidth(10);
     myTurtle.setPenColor(Color.BLUE);
     
     
     // 1st line of text
     myTurtle.drawC(x = startX1, y = startY);
     myTurtle.drawS(x += CHAR_SPACE, y);
     myTurtle.draw8(x += CHAR_SPACE, y);
     myTurtle.drawW(x += CHAR_SPACE, y);
     myTurtle.drawF(x += CHAR_SPACE, y);
     myTurtle.drawS(x += CHAR_SPACE, y);
     
     // 2nd line of text
     myTurtle.drawW(x = startX2, y += LINE_SPACE);
     myTurtle.drawI(x += CHAR_SPACE, y);
     myTurtle.drawN(x += CHAR_SPACE, y);
     myTurtle.drawT(x += CHAR_SPACE, y);
     myTurtle.drawE(x += CHAR_SPACE, y);
     myTurtle.drawR(x += CHAR_SPACE, y);
     
     // 3rd line of text
     myTurtle.draw2(x = startX3, y += LINE_SPACE);
     myTurtle.draw0(x += CHAR_SPACE, y);
     myTurtle.draw1(x += CHAR_SPACE, y);
     myTurtle.draw1(x += CHAR_SPACE, y);
     
     // Draws border
     myTurtle.drawBorder(x = startX1-20, y = startY-20);
   }
   
} // End of public class CSE8ATurtle extends Turtle