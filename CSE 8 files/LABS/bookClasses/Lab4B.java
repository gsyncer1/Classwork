/*
 * Lab 4B: A collage with off by one errors and simple if statements
 */

public class Lab4B
{
  public static void main(String[] args)
  {
    FileChooser.setMediaPath("/home/linux/ieng6/cs8w/cs8wfs/Desktop/mediasources/");
    Picture collage = new Picture("7inX95in.jpg");
    Picture input1 = new Picture("bird1.jpg");
    Picture input2 = new Picture("bird2.jpg");
    
    collage.createForLab4B(input1, input2);
    collage.show();
  }
}

