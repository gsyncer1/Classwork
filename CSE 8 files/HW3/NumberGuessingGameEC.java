/* Name: 	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 3 - NumberGuessingGame
 * Date:	April 21, 2011
 *
 * File:	NumberGuessingGame.java
 *
 * Sources of Help: Scanner Java API, Lecture Slides
 *
 * This Java application is a simple number guessing game.
 * The user keeps guessing for a number within the user-specified range
 * and with each guess, the program tells whether the user is too high
 * or too low. At the end, the program tells the user how many games
 * were played and what the average number of tries per game was.
 */ 
 import java.util.*;

 /**
  * class NumberGuessingGame
  * .	The class contains a main method that invokes the number guessing
  * 	game as long as the user wants to play. It also contains the method
  *	getInt that handles the user's integer inputs for the min and max
  *	values and the user's guesses. It contains the method guessNumber
  *	which drives the number guessing game. It also contains the method
  *	calculateAvg that calculates the average number of guesses per game
  *	when the user quits.
  */

  public class NumberGuessingGameEC
  {
     /**
      * main() is the driver for this application
      *
      * The method asks the user if he/she wants to play a game.
      * If so (by entering any character), main invokes the method getInt
      * to get the minimum and maximum values for the random number generator.
      * This minimum must be less than the maximum number. Once this condition
      * is satisfied, it generates a random number, and invokes guessNumber
      * to begin the main number guessing game.
      * Main keeps track of the total number of tries needed and the number of
      * games played. The program asks if the user wants to play again after
      * each game.
      * Main then invokes calculateAvg to display the number of games played
      * and the average number of tries per game when the user quits.
      *
      * Params: String[] args, not used.
      * Return Value: void
      */

      public static void main( String[] args )
      {
	 Scanner input = new Scanner(System.in);
	 Random rand = new Random();
	 int answer, games_played = 0, tries = 0;
	 int min, max, idealGuesses;

	 //Ask user if they want to play a game or quit
	 System.out.println("I am thinking of a number. " +
	 			"Would you care to guess?");
	 System.out.print("Type any character for yes, EOF for no: ");

	 //Scan for input
	 while(input.hasNext())
	 {
	    input.next(); //Clear the input
	    min = getInt(input, "\nEnter minimum number for the game: ");
	    max = getInt(input, "Enter maximum number for the game: ");
	    if(min >= max)
	    {
	       //min and max are invalid. Indicate error to user.
	       System.out.println("Minimum value should be less than " +
	       				"maximum value.");
	    }
	    else
	    {
	       //Generate a random number within min and max (inclusive)
	       answer = rand.nextInt(max-min+1) + min;
	 idealGuesses = (int) Math.ceil(Math.log(max-min+1+1)/Math.log(2));
	       //add number of tries needed to current tries tally
	       tries += guessNumber(input, answer, idealGuesses);
	       //Increment number of games played
	       games_played++;
	    }

	    System.out.print("\nWould you like to play again? ");
	    System.out.print("<any character for yes, EOF to quit>: ");
	 }

	 //User quits, no more input, display average tries per game
	 calculateAvg(tries, games_played);

      } // end main()




      /**
       * method getInt
       * The method prints the prompt passed in as a parameter.
       * The program keeps print error messages while the user's input
       * is not an integer.
       * Once a user has entered a valid integer, it then returns
       * the integer.
       */
      public static int getInt( Scanner console, String prompt )
      {
	 //Print the prompt passed in as a parameter.
	 System.out.print(prompt);

	 //Check for invalid input
	 while(!(console.hasNextInt()))
	 {
	    console.next(); //Remove invalid input
	    System.out.print("Not an integer. Try again: ");
	 }

	 return console.nextInt(); //Return the valid integer
      } // end getInt()



      /**
       * method guessNumber
       * The method calls getInt to prompt the user to guess a number.
       * The method then hints whether the number is too low or
       * too high.
       * The method then prints a congratulations message and prints
       * the number of tries needed once the user has correctly
       * guesse the number.
       */
      public static int guessNumber( Scanner console,  int number, int ideal )
      {
	 int guess, tries = 0;

	 //Use getInt to get the user's guess. Increment number of tries.
	 guess = getInt(console, "\nGuess the number: "); tries++;
	 while(guess != number)
	 {
	    //guess is incorrect...
	    if(guess < number)
	    {
	       //Guess is too low
	       guess = getInt(console, "Too low. Try again: ");
	       tries++;
	    }
	    else
	    {
	       //Guess is too high
	       guess = getInt(console, "Too high. Try again: ");
	       tries++;
	    }
	 }

	 //Guess is correct, display number of tries
	 System.out.println("\nCongratulations!");
	 System.out.println("You needed " + tries + " tries.");
	 if(tries <= ideal)
	 {
	    System.out.println();
	    System.out.print("You guessed within " + ideal + " ideal tries.");
	    System.out.println("\tGreat Job!");
	 }
	 else
	 {
	    System.out.println("You could have guessed within " + ideal
	    			+ " tries if you took CSE 21.");
	 }

	 //Return number of tries for total tally of tries
	 return tries;
      } //end guessNumber()



      /**
       * method calculateAvg
       * Calculates the average number of tries per game by dividing
       * the number of total tries by the number of games played, passed
       * in as parameters.
       * The method prints that 0 games were played if number of games
       * playes is 0.
       */
      public static void calculateAvg( int tries, int games )
      {
	 double average;
	 if(games == 0)
	 {
	    //No games played, can't display average tries per game
	    System.out.println("\n\nYou played a total of 0 games.");
	 }
	 else
	 {
	    //At least one game played, display number of games and avg # tries
	    average = (double) tries / games;
	    System.out.println("\n\nYou played a total of " +games +" games.");
	    System.out.print("Your average number of guesses per game is ");
	    System.out.printf("%.1f\n", average);
	 }
      } // end calculateAvg()

  } // end class NumberGuessingGame
