/******************************************************************************
*
* File name: linear_solver.c
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 2
* Problem #: 1
*
* Submission Date: February 9, 2011
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
#define VARIABLE_NAME 'Y'



/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function (describe what your program does here):

  The program asks the user to input a linear equation of the form
  aY + b = c, where a, b, and c are real numbers of type double.
  It checks whether the equation the user entered satisfies the following
  criteria...
  1. The equation uses the variable Y
  2. The operator betweey aY and b is a plus sign. ('+')
  3. a != 0
  and if it does, it solves the linear equation with an accuracy of
  three digits after the decimal point.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
  char letter_char, op;
  double a, b, c, result;
  
  printf("Enter a linear equation:  ");
  scanf(" %lf%c %c %lf = %lf", &a, &letter_char, &op, &b, &c);

  while (getchar() != '\n'); //Throws out additional text

  //Checks if variable name is valid
  if (letter_char != VARIABLE_NAME)
     printf("Invalid input!\n");

  //Checks if operator is a + sign
  else if (op != '+')
     printf("Invalid input!\n");

  //Checks if a != 0
  else if (a == 0)
  {
     printf("Invalid equation!\n");
     return 1;
  }

  //Evaluates result
  else
  {
     result = (c - b)/a;
     printf("%c = %.3lf\n", VARIABLE_NAME, result); //prints result to
                                                    //3 decimal places
  }

  return 0;
}



/******************************************************************************
                                End of file
******************************************************************************/


