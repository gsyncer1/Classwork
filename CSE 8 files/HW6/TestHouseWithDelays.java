/**
 * Program to test various Shapes per CSE 8B - Winter 2011 Inheritance
 * homework.
 *
 * Inherits from DrawingPanel to provide animation with delays
 * between drawing different parts of a house as a self-contained program.
 *
 */

import javax.swing.*;
import java.awt.*;

public class TestHouseWithDelays extends DrawingPanel
{
  private static final int DELAY = 500;

  private Graphics g;

  /**
   * main() driver
   */
  public static void main( String[] args )
  {
    DrawingPanel theHouse = new TestHouseWithDelays( 600, 600 );
    theHouse.run();		// Start the animation
  }

  /**
   * ctor to initialize ourself as a DrawingPanel
   */
  public TestHouseWithDelays( int width, int height )
  {
    super( width, height );	 // DrawingPanel ctor
    this.g = this.getGraphics(); // Graphics context for objects to draw
  }

  /**
   * The single animation thread.
   */
  public void run()
  {
    int xCenter = this.getWidth() / 2;
    int yCenter = this.getHeight() / 2;

    String s;
    int xOffset;
    int yOffset;

    Rectangle house = new Rectangle( xCenter - 100, yCenter, 200, 100 );

    Point p1 = new Point( xCenter - 100, yCenter );
    Point p2 = new Point( xCenter + 100, yCenter );
    Point p3 = new Point( xCenter, yCenter - 100 );

    Triangle roof = new Triangle( p1, p2, p3 );

    Rectangle chimney = new Rectangle( xCenter + 50, yCenter - 75, 25, 75 );

    Square window = new Square( xCenter - 75, yCenter + 25, 30 );
    Line pane1 =
        new Line( new Point( xCenter - 60, yCenter + 25 ),
                        new Point( xCenter -60, yCenter + 55 ) );
    Line pane2 =
        new Line( new Point( xCenter - 75, yCenter + 40 ),
                        new Point( xCenter - 45, yCenter + 40 ) );

    Rectangle door =
        new Rectangle( new Point( xCenter -20, yCenter + 20 ), 40, 70 );

    Circle doorknob = new Circle( new Point( xCenter -10, yCenter + 55 ), 3 );


    /*
     * Start drawing these objects along with their toString() implementations.
     */

    yOffset = yCenter + 120;

    /* Draw the main house structure */
    s = "Drawing the house - " + house;		// house.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.drawString( s, xCenter - xOffset, yOffset );
    sleep( DELAY );

    house.draw( g, Color.GREEN, true );		// filled, green
    sleep( DELAY );

    house.draw( g, null, false );		// not filled, black outline
    sleep( DELAY );


    /* Draw the chimney */
    s = "Drawing the chimney - " + chimney;	// chimney.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    chimney.draw( g, Color.RED, true );		// red chimney
    sleep( DELAY );

    chimney.draw( g, Color.BLACK, false );	// black outline
    sleep( DELAY );


    /* Draw the roof frame */
    s = "Drawing the roof frame - " + roof;	// roof.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    roof.draw( g, null, true );			// black outline of roof
    sleep( DELAY );


    /* Draw the left window */
    s = "Drawing the left window - " + window;
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    window.draw( g, Color.WHITE, true );	// white window
    sleep( DELAY );

    window.draw( g, Color.BLUE, false );	// blue trim
    sleep( DELAY );


    /* Draw 1st window pane */
    s = "Drawing 1st window pane - " + pane1;	// panel1.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.setColor( Color.BLACK );
    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    pane1.draw( g, Color.BLUE, false );		// blue window panes
    sleep( DELAY );


    /* Draw 2nd window pane */
    s = "Drawing 2nd window pane - " + pane2;	// panel2.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.setColor( Color.BLACK );
    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    pane2.draw( g, Color.BLUE, false );		// blue window panes
    sleep( DELAY );


    /*
     * Draw and move the right window and panes via a generic Shape
     * reference - real polymorphism.
     */

    Shape newWindow = new Square( window );	// Square's copy ctor
    newWindow.move( 115, 0 );			// Square's move()

    /* Draw right window */
    s = "Drawing the right window - " + newWindow;   // newWindow.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.setColor( Color.BLACK );
    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    newWindow.draw( g, Color.WHITE, true );	// white window
    sleep( DELAY );

    newWindow.draw( g, Color.BLUE, false );	// blue trim
    sleep( DELAY );

    // Don't bother printing the next two pane's String representation

    Shape newPane1 = new Line( pane1 );	// Line's copy ctor
    newPane1.move( 115, 0 );			// Line's move()
    newPane1.draw( g, Color.BLUE, false );
    sleep( DELAY );

    Shape newPane2 = new Line( pane2 );	// Line's copy ctor
    newPane2.move( 115, 0 );			// Line's move()
    newPane2.draw( g, Color.BLUE, false );
    sleep( DELAY );


    /* Draw the door */
    s = "Drawing the door - " + door;		// door.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.setColor( Color.BLACK );
    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    door.draw( g, Color.ORANGE, true );		// orange door
    sleep( DELAY );

    door.draw( g, Color.RED, false );		// with a red trim
    sleep( DELAY );


    /* Draw the door knob */
    s = "Drawing the door knob - " + doorknob;	// doorknob.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.setColor( Color.BLACK );
    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    doorknob.draw( g, Color.RED, false );	// red doorknob
    sleep( DELAY );


    /* Draw the door knob */
    s = "Filling in the roof - " + roof;	// roof.toString()
    xOffset = g.getFontMetrics().stringWidth( s ) / 2;

    g.setColor( Color.BLACK );
    g.drawString( s, xCenter - xOffset, yOffset += 15 );
    sleep( DELAY );

    roof.draw( g, null, true );

    /*
     * Some fun drawing a solid roof 
     */

    while ( p3.getY() != p1.getY() )
    {
      Triangle roofFill;
      p3 = new Point( p3.getX(), p3.getY() + 1 );

      roofFill = new Triangle( p1, p2, p3 );
      roofFill.draw( g, Color.GREEN, true );
      sleep( DELAY/10 );
    
      s = "Filling in the roof - " + roofFill;	// roofFill.toString()
      xOffset = g.getFontMetrics().stringWidth( s ) / 2;

      g.setColor( Color.WHITE );
      g.fillRect( xCenter - xOffset, yOffset - g.getFontMetrics().getHeight()+3,
                   xOffset * 2,
		   g.getFontMetrics().getHeight() );
      g.setColor( Color.BLACK );
      g.drawString( s, xCenter - xOffset, yOffset );
    }

    roof.draw( g, null, true );	// draw the black roof outline

    /*
     * NOTE: This Is Not Extra Credit.
     * Possible other things to add to test the shapes classes:
     * Add a sun with rays coming out.
     * Add a garage.
     * Add a walkway to the front door.
     * Add a driveway. 
     *
     * Spell out "CSE 8B" using Line objects.
     */
  }

} // End of class 
