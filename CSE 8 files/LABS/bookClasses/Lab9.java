public class Lab9
{
  public static void main(String [] args)
  {

/**** PART A ****

    Student a = new Student();
    System.out.println(a);
    
    Student b = new Student("Shaun White");
    System.out.println(b);
    
    double [] d = new double[3];
    d[0]=4.0;
    d[1]=3.5;
    d[2]=2.5;
    Student c = new Student("Body Miller", d, "Computer Science");
    System.out.println(c);
    
    ****/

    
/**** PART B ****/

    Student e = new Student();
    boolean name = e.setName("Apolo Ohno");
    System.out.println("Name was successfully set: " + name);
    boolean grade = e.setGrade(0, 4.0);
    System.out.println("The first grade was successfully set: " + grade);
    boolean major = e.setMajor("Bioengineering");
    System.out.println("The major was successfully set: " + major);
    System.out.println(e);
    System.out.println(e.getName() + 
                       " has changed his mind and realized CS is much better");
    major = e.setMajor("Computer Science");
    System.out.println(e.getName() + " has a new major! It is " + e.getMajor());


  } 
}
