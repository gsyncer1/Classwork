/*
 *  Lab 5B -- exploring if - else if - else with grade assignment
 */

import java.io.*;

public class Lab5B
{
  public static void main (String[] args) throws IOException
  {

    // Get the student grade from the user
    System.out.println("Please enter the student score as a percent (e.g. .89)");

    /* The following two lines you don't have to understand,
       but they read in a value from the keyboard of double type
       (e.g. has a decimal point somewhere in it).
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double x = (new Double(br.readLine())).doubleValue();

    // Calculate whether the student passed or failed and print a message
    /*if (x >= .70)
      System.out.println("Message A: Congratulations, you earned a pass");
    else
    {
      System.out.println("Message B: I am sorry, you did not earn a passing grade");
      System.out.println("Please work harder next time");
    }
    
    */
    
    char grade;

    if ( x >= .90)
      grade = 'A';
    else if (x >= .80)
      grade = 'B';
    else if (x >= .70)
      grade = 'C';
    else if (x >= .60)
      grade = 'D';
    else
      grade = 'F';

    System.out.println("The grade you earned was a " + grade);

   }
}
