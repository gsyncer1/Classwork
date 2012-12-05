/******************************************************************************
*
* File name: digits.c
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 1
* Problem #: 2
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
  Prints each digit of an entered integer on a separate line, last digit first.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
   int n;

   printf("Enter an integer: ");
   scanf("%d", &n);

   n = ((n >= 0) ? n:-n); //Makes n positive if negative.

   //If integer is 0, prints that first digit is 0.
   if (n == 0) printf("Digit (1): 0\n");

   int i = 1;
   while (n != 0)
   {
      printf("Digit (%d): %d\n", i, n%10); //Prints last digit
      n = n/10; i++; //Deletes last digit, moves to next digit
   }


   return 0;
}


/******************************************************************************
                                End of file
******************************************************************************/


