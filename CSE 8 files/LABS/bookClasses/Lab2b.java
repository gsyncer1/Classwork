/* 
 * Lab 2b: The application to test out makeRed
 */

public class Lab2b
{
  public static void main (String[] args)
  {
    Picture original = new Picture(FileChooser.pickAFile());
    Picture copy = new Picture(original); // Make a copy of the original picture
    original.show();
    copy.makeRed();
    copy.show();
  }
}
