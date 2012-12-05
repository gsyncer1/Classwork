import java.util.Random;

public class NumberGuessGame
{
  /////////// fields ///////////
  private int minNumber = 1;
  private int maxNumber = 100;
  private int pickedNumber;
  private int numGuesses = 0;
  private Random randomNumGen = new Random();
  
  //////////// constructors /////////////
  
  public NumberGuessGame()
  {
     
//    int numValues = this.maxNumber - 
//      this.minNumber + 1;
//    int number = randomNumGen.nextInt(numValues);
//    this.pickedNumber = number + this.minNumber;
    pickNumber();
  }
  
  public NumberGuessGame(int min, int max)
  {
    this.minNumber = min;
    this.maxNumber = max;
//    int numValues = this.maxNumber - 
//      this.minNumber + 1;
//    int number = randomNumGen.nextInt(numValues);
//    this.pickedNumber = number + this.minNumber;
    pickNumber();
  }
  
  ///////////////////// methods ////////////////
  
   private void pickNumber()
  {
    int numValues = this.maxNumber - 
      this.minNumber + 1;
    int number = randomNumGen.nextInt(numValues);
    this.pickedNumber = number + this.minNumber;
  }
  
  public String toString()
  {
    return "Min: " + this.minNumber +
      ", Max: " + this.maxNumber + 
      ", picked num: " +
      this.pickedNumber + 
      ", and the number of guesses is "+
      this.numGuesses;
  }
  
 
  
  public static void main(String[] args)
  {
    NumberGuessGame game = new NumberGuessGame();
    System.out.println(game);
    game = new NumberGuessGame(5,10);
    System.out.println(game);
  }
  
}
