/*
 * Lab 3 Part B: The application to test out simpleGrayscaleVersion2
 * Date: Winter 2011
 */
public class Lab3B
{
  public static void main( String[] args )
  {
     Picture myPic = new Picture( FileChooser.pickAFile() );
     myPic.show();
     Picture grayPic = new Picture( myPic );
     grayPic.simpleGrayscaleVersion2();
     grayPic.show();
  }
}

