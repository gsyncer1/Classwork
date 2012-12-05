/*
 * Lab 1
 * Winter 2011
 */

public class Lab1
{

  public static void main( String[] args )
  {
    World w = new World();

    // Creates a turtle in World w at (x,y) (100,50)
    Turtle maria = new Turtle( 100, 50, w );  

    // Make a U shape
    maria.turn(180); //Face down
    maria.forward( 55 );
    maria.turn( -90 );
    maria.forward( 30 );
    maria.turn( -90 );
    maria.forward( 55 );
  }

} // end class Lab1

