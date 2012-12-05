/*
 * Test program for classes Point and Circle for Shapes inheritance
 *
 * Program draws a Mickey Mouse figure.
 */

import java.awt.*;

public class TestMickey
{
  private DrawingPanel canvas = new DrawingPanel( 500, 500 );
  private Graphics g = canvas.getGraphics();

  public static void main( String[] args )
  {
    new TestMickey().makeMickey();
  }

  public void makeMickey()
  {
    Shape c1, c2, c3;  // these are generic Shapes
    Circle c4;
    Point p1, p2, p3;

    p1 = new Point( canvas.getWidth()/2, canvas.getHeight()/2 );
    c1 = new Circle( p1, 100 );

    p2 = new Point( p1 );	// test Point copy ctor
    p2.move( -100, -100 );	// test Point move()
    c2 = new Circle( p2, 50 );

    p3 = new Point ( p2 );	// test Point copy ctor

    if ( p2.equals( p3 ) )	// test Point equals()
    {
      c3 = new Circle( p3, 50 );
      c3.move( 200, 0 );	// test Circle move()
    }
    else
    {
      c3 = c2;
    }

    if ( c1 instanceof Circle )
    {
      c4 = new Circle( (Circle) c1 );	// test Circle copy ctor

      if ( c1.equals( c4 ) )	// test Circle equals()
      {
        c1.draw( g, Color.BLACK, true );	// black and filled
        c2.draw( g, Color.BLACK, true );
        c3.draw( g, Color.BLACK, true );
      }

      // test Circle toString(), getCenter(), getRadius(), and
      // Point getX()/getY()

      String s = c4.toString();

      // offset to center text under circle
      int xOffset = g.getFontMetrics().stringWidth( s ) / 2; 

      g.drawString( s, c4.getCenter().getX() - xOffset,
                       c4.getCenter().getY() + c4.getRadius() + 20 );
    }

    if ( c2 instanceof Circle )
    {
      c4 = (Circle) c2;

      String s = c4.toString();

      // offset to center text over circle
      int xOffset = g.getFontMetrics().stringWidth( s ) / 2; 

      g.drawString( s, c4.getCenter().getX() - xOffset,
                       c4.getCenter().getY() - c4.getRadius() - 40 );
    }

    if ( c3 instanceof Circle )
    {
      c4 = (Circle) c3;

      String s = c4.toString();

      // offset to center text under circle
      int xOffset = g.getFontMetrics().stringWidth( s ) / 2; 

      g.drawString( s, c4.getCenter().getX() - xOffset,
                       c4.getCenter().getY() - c4.getRadius() - 20 );
    }
  }  // End of makeMickey()

} // End of class 
