/*
* Filename: Participant.java
* Name: Glenn Briones
* Login: cs8wfs
* Date: March 9, 2011
* Sources of Help: None
*/
public class Participant
{
  
  ///// fields /////
  private String name;
  private int weight;
  private double height;
  
  
  
  ///// constructors /////
  public Participant()
  {
    this.name = "Joe Bob";
    this.weight = 1;
    this.height = 1.0;
  }
  
  public Participant(String name)
  {
    this.name = name;
    this.weight = 1;
    this.height = 1.0;
  }
  
  public Participant(String name, int weight, double height)
  {
    this.name = name;
    
    if( weight <= 0 )
    {
      System.out.println("Incorrect weight, weight must be positive. Weight will not be updated.");
      this.weight = 1;
    }
    else
    {
      this.weight = weight;
    }
    
    if( height <= 0.0 )
    {
      System.out.println("Incorrect height, height must be positive. Height will not be updated.");
      this.height = 1.0;
    }
    else
    {
      this.height = height;
    }
  }
  
  
  
  ///// methods /////
  public String getName()
  {
    return this.name;
  }
  
  
  public void setName( String name)
  {
    if( name == null )
      System.out.println("The String parameter name is null. Name will not be updated.");
    else
      this.name = name;
  }
  
  public int getWeight()
  {
    return this.weight;
  }
  
  
  public void setWeight(int weight)
  {
    if( weight <= 0 )
      System.out.println("Incorrect weight, weight must be positive. Weight will not be updated.");
    else
      this.weight = weight;
  }
  
  
  public double getHeight()
  {
    return this.height;
  }
  
  
  public void setHeight(double height)
  {
    if (height <= 0.0)
      System.out.println("Incorrect height, height must be positive. Height will not be updated.");
    else
      this.height = height;
  }
  
  
  public String toString()
  {
    String s = "Participant:\n"
             + "Name: " + this.name + "\n"
             + "Weight: " + this.weight + "\n"
             + "Height: " + this.height + "\n";
    
    return s;
  }
  
  
  public double getBMI()
  {
    double BMI = this.weight*703/(this.height*this.height);
    
    return BMI;
  }



}