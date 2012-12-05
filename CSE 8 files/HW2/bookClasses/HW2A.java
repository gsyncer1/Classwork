/* Filename: HW2A.java
* Name: Glenn Briones and Kelly Lim
* Login: cs8wfs and cs8wfb
* Date: January 18th, 2011
* File: HW2A.java
* Sources of Help: Yelly
*
* Creates two pictures, one with a solid color and one with a patterened black and colored image. 
*/
public class HW2A
{
/*
 * Name: main
 * Purpose: Creates two pictures, one with a solid color and one with a patterened black and colored image.
 * Parameters: none
 * Return: void
 */
  
  public static void main (String[] args)
  {
    Picture pict1 = new Picture(FileChooser.pickAFile());
    pict1.createSolid(255,0,150);
    pict1.show();
  
    Picture pict2 = new Picture(FileChooser.pickAFile());
    pict2.createPattern(255,0,150);
    pict2.show();
  
  }
}