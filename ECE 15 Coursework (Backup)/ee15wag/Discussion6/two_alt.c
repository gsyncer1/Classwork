/******************************************************************************:
*
* File name: two_alt.c
*
* Authors:  Jane Doe
*           ee15vzz
*           jjdoe@ucsd.edu
*
*
*     Lab #:(Discussion 5)
* Problem #:1
*
* Submission Date: Oct 28, 2009
*
******************************************************************************/



/*-----------------------------------------------------------------------------
   Include files:
-----------------------------------------------------------------------------*/

#include <stdio.h>

/*=============================================================================
  Constants and definitions:
=============================================================================*/

// put your #defines and typedefs here
// None for this program

/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function: This program will read a string (terminated with 
  an endline) from the user and determine how many double letters are in 
  that string.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main()
{
   char current;

   /* Set initial value of previous to avoid initial unintended matches */
   char previous = 0;  
   int count = 0;
   
   /* prompt user for input and then start processing phrase */
   printf("Please enter a phrase:\n");
   scanf("%c", &current);

   /* Always loop. Break used in order to exit loop. */ 
   while (1)
   {
      /* Leave loop if endline found. */    
      if (current == '\n')
      {
        break;
      }

      /* If previous letter is same as current letter. */
      if (previous == current)
         count++;
      
      /*set previous to current in order to make room for next char */
      previous = current; 
      scanf("%c", &current); //get next char
   }

   if (count == 1)
      printf("There was 1 double letter.\n");
   else
      printf("There were %d double letters.\n", count);


   return 0;
}

/******************************************************************************
                                End of file
******************************************************************************/
