/******************************************************************************
*
*
* File name: logic_abc.c
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 1
* Problem #: 1
*
* Submission Date: Jan 26, 2011
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

  The program first prompts the user to enter integers a, b, c.
  The program then computes the following logical operations in sequence:
      !a || !b++ && c
      (a-1 || b/2) && (c*=2)
      (a-- || --b) && (c+=2)
      a || !(b && --c)

   For each operation, if the operation results in 1, then the program
   prints "True". Otherwise, the program prints "False".
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
  int a, b, c;

  printf("Enter integers a, b, c: ");
  scanf("%d %d %d", &a, &b, &c);

  //Evaluates first logical operation
  printf("       !a || !b++ && c: ");
  if ( ( !a||(!b++&&c) ) == 1)
     printf("True\n");
  else
     printf("False\n");

  //Evaluates second logical operation
  printf("(a-1 || b/2) && (c*=2): ");
  if ( ( (a-1||b/2)&&(c*=2) ) == 1)
     printf("True\n");
  else
     printf("False\n");

  //Evaluates third logical operation
  printf("(a-- || --b) && (c+=2): ");
  if ( ( (a--||--b)&&(c+=2) ) == 1)
     printf("True\n");
  else
     printf("False\n");

  //Evaluates fourth logical operation
  printf("      a || !(b && --c): ");
  if ( ( a||!(b&&--c) ) == 1)
     printf("True\n");
  else
     printf("False\n");


  return 0;
}



/******************************************************************************
                                End of file
******************************************************************************/


