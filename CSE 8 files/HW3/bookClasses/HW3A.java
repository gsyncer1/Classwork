/*
* Filename: HW3A.java
* Name: Glenn Briones, Kelly Lim
* Login: cs8wfs, cs8wfb
* Date: January 26, 2011
* File: HW3A.java
* Sources of Help: Textbook
*
* Takes a picture, makes a copy, and subtracts the RGB values from the copy.
* 
*/
public class HW3A
{
//The line below is magic, you don't have to understand it yet.
  public static void main (String[] args)
  {
    Picture original = new Picture(FileChooser.pickAFile());
    Picture copy = new Picture(original);
    original.explore();
    copy.subtractColor(30,50,-255);
    copy.explore();

  }
}