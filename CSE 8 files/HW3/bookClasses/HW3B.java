/*
* Filename: HW3B.java
* Name: Your name and your partner?s name
* Login: Your cs8wxx account and your partner?s cs8wxx account
* Date: Month, Day, Year
* File: Name of this file
* Sources of Help: ... (for example: names of people, books, websites, etc.)
*
* Describe what the code does here.
*/
public class HW3B
{
//The line below is magic, you don't have to understand it yet.
public static void main (String[] args)
  
{Picture original = new Picture(FileChooser.pickAFile());
    Picture copy = new Picture(original);
    Pixel[] pixelArray = copy.getPixels();
    original.explore();
    copy.negative(0, pixelArray.length /3);
    copy.grayscale(pixelArray.length/3, pixelArray.length *2/3);
    copy.myFilter(pixelArray.length * 2 / 3, pixelArray.length);
    copy.explore();  
}
}