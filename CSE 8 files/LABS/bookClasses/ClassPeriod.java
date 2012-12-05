import java.util.*;
import java.io.*;

/**
 * ClassPeriod represents a class period which has a teacher, 
 * a period number, and an array of students (max 35)
 */
public class ClassPeriod
{
  //////////////// fields /////////////////////////
  private String teacherName;
  private int periodNumber;
  private Student[] students = new Student[35];
  
  ///////////////// constructors //////////////////
  /**
   * No-argument constructor.  Leaves field values
   * alone
   */
  public ClassPeriod() {}
  
  /**
   * Constructor that takes just the teacher's name
   * @param name the name for the teacher
   */
  public ClassPeriod(String name) 
  {  this.teacherName = name; }
  
  /**
   * Constructor that takes the teacher's name and period number
   * @param name the name for the teacher
   * @param num the period number
   */
  public ClassPeriod(String name, int num) 
  {
    this.teacherName = name;
    this.periodNumber = num;
  }
  
  /////////////////////////// methods ///////////////////////////
  
  /**
   * Method to get the teacher's name
   * @return the name of the teacher, or null if none yet
   */
  public String getTeacherName() { return this.teacherName; }
  
  /**
   * Method to get the period number
   * @return the number for this period
   */
  public int getPeriodNumber() { return this.periodNumber; }
  
  /**
   * Method to get a student based on the index
   * @return the student at this index
   */
  public Student getStudent(int index) 
  { 
    return this.students[index];
  }
  
  /**
   * Method to set the teacher's name
   * @param name the name to use
   */
  public void setTeacherName(String name) 
  { 
    this.teacherName = name; 
  }
  
  /**
   * Method to set the period number (if it hasn't been set)
   * @param num the number to use
   * @return flag to say if set worked
   */
  public boolean setPeriodNumber(int num)
  {
    if (this.periodNumber == 0)
    {
      this.periodNumber = num;
      return true;
    }
    else
      return false;
  }
  
  /**
   * Method to set the student at an index
   * @param studentObj the student object to use
   * @param index the index to set the student at
   */
  public void setStudent(Student studentObj, int index)
  {
    this.students[index] = studentObj;
  }
  
  /**
   * Method to return the number of students in the period
   * @return the number of students in the period
   */
  public int getNumStudents() 
  {
    int total = 0;
    for (int i = 0; i < this.students.length; i++)
    {
      if (this.students[i] != null)
        total++;
    }
    return total;
  }
  
  /**
   * Method to return a string of information about this class
   * period
   * @return information about the class period
   */
  public String toString() 
  { 
    return "Class Period " + this.periodNumber + 
      " taught by " + this.teacherName + " with " +
      this.getNumStudents() + " students";
  }
  

  
  /**
   * Main method
   * @param args the arguments to execution
   */
  public static void main(String[] args)
  {
    ClassPeriod period = new ClassPeriod("Ms. Ace",7);
    period.setStudent(new Student("Barb Ericson"),0);
    period.setStudent(new Student("Wanda Dann"),1);
    period.setStudent(new Student("Steve Cooper"),2);
    System.out.println(period);
   
  }
 
}