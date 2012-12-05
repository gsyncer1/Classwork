/*
 * Lab5A: Changing the color of a bird
 */

public class Lab5A
{
  public static void main( String[] args )
  {
    FileChooser.setMediaPath("/home/linux/ieng6/cs8w/cs8wfs/Desktop/mediasources/" );

    Picture input1 = new Picture( "bird1.jpg" );
    input1.explore();

    Picture redBird = input1.greenToRed();
    redBird.show();
  }
}
