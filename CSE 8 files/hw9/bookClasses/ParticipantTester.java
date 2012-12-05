public class ParticipantTester
{
  public static void main(String [] args)
  {
    boolean passed = true;
    
    System.out.println("Creating a default participant\n");
    Participant participant = new Participant();
    System.out.println("Testing correct default name using the getName method\n");
    if(participant.getName().equals("Joe Bob"))
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant.getName() + " is incorrect, the default name should be Joe Bob]\n");
    }
    
    System.out.println("Testing correct default weight using the getWeight method\n");
    if(participant.getWeight() == 1)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant.getWeight() +" is incorrect, the default weight should be 1]\n");
    }
    
    System.out.println("Testing correct default height using the getHeight method\n");
    if(participant.getHeight() == 1.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant.getHeight() +" is incorrect, the default height should be 1.0]\n");
    }
    
    System.out.println("Testing the getBMI method on the first participant\n");
    if(participant.getBMI() == 703.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant.getBMI() +" is incorrect, the default BMI should be 703.0]\n");
    }
    
    System.out.println("Testing each set method using a default participant\n");
    participant.setName("Sally Jane");
        System.out.println("Testing setName method using the getName method\n");
    if(participant.getName().equals("Sally Jane"))
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant.getName() + " is incorrect, the updated name should be Sally Jane]\n");
    }
    
    participant.setWeight(100);
    System.out.println("Testing setWeight method using the getWeight method\n");
    if(participant.getWeight() == 100)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant.getWeight() +" is incorrect, the updated weight should be 100]\n");
    }
    
    participant.setHeight(5.0);
    System.out.println("Testing setHeight using the getHeight method\n");
    if(participant.getHeight() == 5.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant.getHeight() +" is incorrect, the updated height should be 5.0]\n");
    }
    System.out.println("Testing the getBMI method on the first participant after changing weight and height\n");
    if(participant.getBMI() == 2812.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant.getBMI() +" is incorrect, the default BMI should be 2812.0]\n");
    }
    
    System.out.println("Default testing complete\n\n\n");
    
    System.out.println("***************************************************************************\n");
    System.out.println("Creating a new participant\n");
    Participant participant2 = new Participant("Sean Connery");
    System.out.println("Testing correct name using the getName method\n");
    if(participant2.getName().equals("Sean Connery"))
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant2.getName() + " is incorrect, the name should be Sean Connery]\n");
    }
    
    System.out.println("Testing correct default weight using the getWeight method\n");
    if(participant2.getWeight() == 1)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant2.getWeight() +" is incorrect, the default weight should be 1]\n");
    }
    
    System.out.println("Testing correct default height using the getHeight method\n");
    if(participant2.getHeight() == 1.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant2.getHeight() +" is incorrect, the default height should be 1]\n");
    }
    
    System.out.println("Testing the getBMI method on the second participant\n");
    if(participant2.getBMI() == 703.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant2.getBMI() +" is incorrect, the default BMI should be 703.0]\n");
    }
    
    System.out.println("Single parameter constructor testing complete\n\n\n");
    
    System.out.println("***************************************************************************\n");
    System.out.println("Creating a new participant\n");
    Participant participant3 = new Participant("Alex Baldwin", 150, 5.0);
    System.out.println("Testing correct name using the getName method\n");
    if(participant3.getName().equals("Alex Baldwin"))
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant3.getName() + " is incorrect, the name should be Alex Baldwin]\n");
    }
    
    System.out.println("Testing correct weight using the getWeight method\n");
    if(participant3.getWeight() == 150)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant3.getWeight() +" is incorrect, the weight should be 150]\n");
    }
    
    System.out.println("Testing correct height using the getHeight method\n");
    if(participant3.getHeight() == 5.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant3.getHeight() +" is incorrect, the height should be 5.0]\n");
    }
    
    System.out.println("Testing the getBMI method on the third participant\n");
    if(participant3.getBMI() == 4218.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant3.getBMI() +" is incorrect, the default BMI should be 4218.0]\n");
    }
    
    System.out.println("Three parameter constructor testing complete\n\n\n"); 
    System.out.println("***************************************************************************\n");
    System.out.println("Testing the toString method\n");
    if(participant3.toString().equals("Participant:\nName: Alex Baldwin\nWeight: 150\nHeight: 5.0\n"))
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("[\n"+participant3.toString()+"\nis incorrect, the string should read:\nParticipant:\nName: Alex Baldwin\nWeight: 150\nHeight: 5.0\n]\n");
    } 
        
    System.out.println("***************************************************************************\n");
    System.out.println("Creating a new participant with negative height\n");
    System.out.println("Should print \"Incorrect height, height must be positive. Height will not be updated.\"");
    Participant participant4 = new Participant("Negative Height", 100, -5.0);
    System.out.println();
    if(participant4.getHeight() == 1.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant4.getHeight()+" is incorrect, the height should be 1.0]\n");
    }
    
    System.out.println("Testing setWeight method with negative weight\n");
    System.out.println("Should print \"Incorrect weight, weight must be positive. Weight will not be updated.\"");
    System.out.println();
    participant4.setWeight(-150);
    if(participant4.getWeight() == 100)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant4.getWeight()+" is incorrect, the weight should be 100]\n");
    }
    
    System.out.println("***************************************************************************\n");
    System.out.println("Creating a new participant with negative weight\n");
    System.out.println("Should print \"Incorrect weight, weight must be positive. Weight will not be updated.\"");
    Participant participant5 = new Participant("Negative Weight", -100, 5.0);
    System.out.println();
    if(participant5.getWeight() == 1)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant5.getWeight()+" is incorrect, the weight should be 1]\n");
    }
    System.out.println("Testing setHeight method with negative height\n");
    System.out.println("Should print \"Incorrect height, height must be positive. Height will not be updated.\"");
    participant5.setHeight(-6.0);
    System.out.println();
    if(participant5.getHeight() == 5.0)
      System.out.println("\t[Correct]\n");
    else
    {
      passed = false;
      System.out.println("\t["+participant5.getHeight()+" is incorrect, the weight should be 5.0]\n");
    }
    
    if(passed)
      System.out.println("******Minimal testing passed******\n");
    else
      System.out.println("******Minimal testing failed******\n");
  }
}

