/*
 * Lab 3 Part A: The application to test out simpleGrayscale
 * Date: Winter 2011
 */

public class Lab3A
{
  public static void main( String[] args )
  {
     Picture pic = new Picture( FileChooser.pickAFile() );
     pic.simpleGrayscale();
     pic.show();
  }
}

