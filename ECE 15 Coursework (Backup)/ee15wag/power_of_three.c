/******************************************************************************
*
* File name: power_of_three.c
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 1
* Problem #: 3
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

#define BASE 3


/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function:
  The function prompts the user to enter a positive integer.
  If the integer isn't positive, the function tells the user the integer
  is invalid. If positive, the function says whether the integer is a power of
  BASE and what the exponent is. If not, it prompts the user that it's
  not a power of BASE.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
  int num, a, i = 0 ;

  printf("Enter a positive integer: ");
  scanf("%d", &num);

  if (num <= 0)
  {
     printf("Error: invalid integer entered!\n");
     return 1;
  }

  a = num; //Performs calculations on a so num is preserved.
  if (a == 1) //If the integer is 1, the exponent is 0
     printf("%d is a power of %d, exponent = %d\n", num, BASE, 0);
  else
  {
     while (a > 0)
     {   
        if (a%BASE != 0) //If not divisible by 3, then not a power of 3
        {
           printf("%d is not a power of %d!\n", num, BASE);
           break;
        }
        else 
        {
           a /= BASE; i++; // Increment i whenever division occurs.
                           // i determines exponent.
           
           // If num is a power of 3, then the last calculation must be
           // 3/3 which is 1.
           if (a == 1)
           {
              printf("%d is a power of %d, exponent = %d\n", num, BASE, i);
              break;
           }
        }
     }
  }
}



/******************************************************************************
                                End of file
******************************************************************************/


