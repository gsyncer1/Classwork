/******************************************************************************
*
* File name: integer_sum.c
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 1
* Problem #: 4
*
* Submission Date: February 2, 2011
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




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function:
  Determines and tells to the user the sum of integers that the user entered.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
  int number, sum, choice, total_numbers;

  printf("Welcome to the integer sum program!\n");

  choice = 0; total_numbers = 0; sum = 0;
  while (choice != 3)
  {
     printf("So far, you have entered %d numbers. You may:\n", total_numbers);
     printf("1. Enter a new integer\n");
     printf("2. Display the current sum\n");
     printf("3. Exit\n");
     printf("Please enter your choice: ");
     scanf("%d",&choice);

     if (choice == 3) break; //exits program
     else if (choice == 1) //adds integer to sum
     {
        printf("Enter the new integer: ");
        scanf("%d",&number);
        sum += number;
        total_numbers++;
     }
     else if (choice == 2) //displays current sum
        printf("The current sum is: %d\n", sum);
     else continue; //redisplays menu
  }

  return 0;
}



/******************************************************************************
                                End of file
******************************************************************************/


