/*
 * Lab 2A
 */

public class Lab2a
{
  public static void main(String [] args)
  {
    World w = new World(1000, 1000);
    Turtle t1 = new Turtle(250, 250, w);
    Turtle t2 = new Turtle(250, 250, w);
    Turtle t3 = new Turtle(500, 500, w);
    Turtle t4 = new Turtle(250, 500, w);
    Turtle t5 = new Turtle(500, 500, w);
      
    t1.turn(180);
    t1.forward(250);
    t2.turnLeft();
    t2.backward(250);
    t3.forward(250);
    t4.turn(45);
    t4.forward(350);
    t5.turnLeft();
    t5.forward(250);
    t2.forward(250);
    t2.turn(-315);
    t2.backward(350);
  }
}

