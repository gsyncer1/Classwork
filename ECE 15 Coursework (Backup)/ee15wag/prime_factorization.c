/******************************************************************************
*
* File name: prime_factorization.c
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 2
* Problem #: 2
*
* Submission Date: February 10, 2011
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

  The main function (describe what your program does here):

  The program computes the prime factorization of an integer that a user inputs.
  If the integer that the user enters is negative, the program makes it
  positive. If the user enters a value <= 1, the program terminates.

  The program uses the following algorithm to compute the prime factorization:
  1. Initialize by setting i = 2.
  2. If i divides n, add i to the list of prime factors, otherwise increment
     i by 1.
  3. If i > n, then terminate the algorithm. Otherwise, repeat step 2.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
  int i, n;

  while (1)
  {
     printf("Enter an integer:  ");
     scanf("%i", &n);

     n = (n < 0) ? -n:n; //makes integer positive
     
     if (n <= 1) break; //Terminates program when user enter value <= 1

     printf("The prime factorization of %i is ", n);
     
     // Computes prime factorization
     i = 2; //initialize i to 2
     while (i <= n)
     {
        if (n%i == 0)
        {
           n /= i;
           printf("%d ",i);
        }
        else i++;
     }

     printf("\n");
  }
  return 0;
}



/******************************************************************************
                                End of file
******************************************************************************/


