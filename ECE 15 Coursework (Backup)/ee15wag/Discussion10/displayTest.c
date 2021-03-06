/*-----------------------------------------------------------------------------
  Include files
  -----------------------------------------------------------------------------*/
#include "connect4_functions.h"


/*=============================================================================
  Constants and definitions: Given in connect4_functions.h
  =============================================================================*/


/*=============================================================================
  Global variables: None
  =============================================================================*/


/*=============================================================================
  Forward function declarations: Given in connect4_functions.h
  =============================================================================*/


/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  This program lets you test your display_board() function.  Compile it as
  gcc displayTest.c connect4_functions.c -Wall -std=c99 -o displayTest

  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main()
{
   int boardtest[BOARD_SIZE_HORIZ][BOARD_SIZE_VERT] = 
   { 
      {0, 0, 0, 0, 0, 2}, 
      {0, 2, 1, 1, 2, 1}, 
      {0, 0, 2, 1, 1, 2}, 
      {0, 0, 0, 2, 2, 1}, 
      {0, 0, 0, 0, 2, 1}, 
      {0, 0, 2, 1, 1, 1}, 
      {0, 0, 0, 0, 0, 2} 
   };


   printf("Testing display_board().\n\n");
   display_board(boardtest);

   printf("Done testing display_board().\n\n");
   printf("**********\n\n");

} /* end of main() */

/******************************************************************************
  End of file
 ******************************************************************************/

