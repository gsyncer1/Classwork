/******************************************************************************
*
* File name: match_and_hit.c
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 3
* Problem #: 2
*
* Submission Date: Feb 27, 2011
*
******************************************************************************/



/*-----------------------------------------------------------------------------
   Include files
-----------------------------------------------------------------------------*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


/*=============================================================================
  Constants and definitions
=============================================================================*/

// put all #defines and typedefs (if any) here

#define NUM_RANGE_MIN 1234 //lowest possible # with distinct integers
#define NUM_RANGE_MAX 9876 //highest possible # with distinct integers
#define MAX_QUERIES 16
#define N_DIGITS 4

/*=============================================================================
  Global variables
=============================================================================*/

// define/declare all global variables (if any) here
int num_tries = 0;


/*=============================================================================
  Forward function declarations
=============================================================================*/

// put forward declarations of all functions here
int isvalid(int n);
int choose_N(void);
int matches(int N, int M);
int hits(int N, int M);




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function:
  The program is a match and hit game where the user must guess a randomly
  selected valid number within a number of tries.
  A number is valid if it contains all distinct non-zero digits.
  A digit is a match if it is the correct number in its correct place.
  A digit is a hit if it is correct, but incorrectly placed.
  The program will make a user try again if the number the user entered is
  invalid. If the user guesses the number, the program tells the user he or
  she won. If the user doesn't guess within the number of tries, then the user
  loses.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
   int round = 1;
   int N, M; //N = correct, computer answer, M = user's query
   int num_matches;
  
   printf("***Welcome to the MATCH and HIT game***\n\n");

   // Random valid number is selected
   N = choose_N();
   printf("The computer has selected a 4-digit number.\n");
   printf("Try to deduce it in %d rounds of queries.\n", MAX_QUERIES);
   printf("CHEAT: The correct number is %d.\n\n", N);

   while(round <= MAX_QUERIES)
   {
      printf("Round #%d\n", round);
     
      //Ask user to input an integer and checks if it's valid
      do{
         printf("Please enter your query (%d digits): ", N_DIGITS);
         scanf("%d",&M);
         while (getchar() != '\n');
         if (isvalid(M) == 0) printf("Invalid query. Please try again!\n");
      } while (isvalid(M) == 0);
      
      //When number is valid, prints number of matches and hits
      printf("-> %d match%s and %d hit%s\n\n",num_matches = matches(N,M), 
                                          (matches(N,M) == 1) ? "":"es",
                                           hits(N,M),
                                          (hits(N,M) == 1) ? "":"s");
      
      //User moves on to next round if 4 matches weren't achieved
      if(num_matches != 4) round++;
      
      //Otherwise, user wins when there are 4 matches
      else 
      {
         printf("**********************************\n");
         printf("CONGRATULATIONS! You won the game!\n");
         printf("**********************************\n");
         break;
         
      }
   }

   //If round is greater than MAX_QUERIES upon exit of while loop, then
   //the user has run out of guesses and loses.
   if (round > MAX_QUERIES)
   {
      printf("*********************************\n");
      printf("Sorry, out of queries. Game over!\n");
      printf("*********************************\n");
   }

   return 0;

}




/*=============================================================================
  Function definitions
=============================================================================*/

// Checks if the integer is a positive number with the correct number of digits
// that are non-zero and distinct.
int isvalid(int n)
{
   int copy1 = n, copy2 = n;
   int digit_array[] = {0,1,1,1,1,1,1,1,1,1};
   // digit_array determines whether a digit has been repeated or not.

   //Test if positive
   if(n <= 0) return 0;

   //Tests if n has four digits (and if nonzero)
   int num_digits = 0;
   while(copy1%10 > 0)
   {
      copy1 /= 10; num_digits++;
   }
   if (num_digits != N_DIGITS) return 0;

   //Tests if digits are distinct
   int digit, i;
   for (i = 0; i < N_DIGITS; i++)
   {
      digit = copy2%10;
      if (digit_array[digit] == 1) // Digit is distinct
      {
         digit_array[digit] = 0; // Marks digit as used in number (unavailable)
         copy2 /= 10; //Truncates last digit
      }
      else return 0;
   }

   //If all tests are passed, return 1. n is valid
   return 1;

} /* end of isvalid() */





// Chooses a random valid number for the user to guess
int choose_N(void)
{
   int seed = time(0); //Used to seed random num generator based on current time.
   int N, temp;

   srand(seed); //Seeds random number generator.

   do{
      temp = rand();
      //manipulates number to be in valid range
      N = temp%(NUM_RANGE_MAX - NUM_RANGE_MIN+1)+NUM_RANGE_MIN;
   }
   while (isvalid(N) == 0); //repeats if number is invalid

   return N;
} /* end of choose_N */




// Compares user input w/ correct number to determine the number of matches.
int matches(int N, int M) 
{
   int arrayN[N_DIGITS], arrayM[N_DIGITS];
   int i, num_matches = 0;

   for(i = 0; i < N_DIGITS; i++)
   {
      arrayN[i] = N%10;
      arrayM[i] = M%10;
      N /= 10;
      M /= 10;
   }

   for(i = 0; i < N_DIGITS; i++)
      //A match if the digit is the same and in the same place.
      if(arrayN[i] == arrayM[i]) num_matches++;

   return num_matches;
} /* end of matches() */




// Compares user input with the correct number to determine number of hits.
int hits(int N, int M)
{
   int arrayN[N_DIGITS], arrayM[N_DIGITS];
   int i, j, num_hits = 0;

   //puts digits into array
   for(i = 0; i < N_DIGITS; i++)
   {
      arrayN[i] = N%10;
      arrayM[i] = M%10;

      N /= 10;
      M /= 10;
   }

   for(i = 0; i < N_DIGITS; i++)
      for(j = 0; j < N_DIGITS; j++)
         //A hit if there are matching numbers but their places are different.
         if(arrayM[i] == arrayN[j] && i != j) num_hits++;

   return num_hits;
} /* end of hits */

/******************************************************************************
                                End of file
******************************************************************************/


