/******************************************************************************
 *
 * File name: connect4_functions.c
 *
 * Author:  Glenn Briones
 *          09175057
 *          gbriones@ucsd.edu
 *
 *
 *     Lab #: 4
 * Problem #: 1
 *
 ******************************************************************************/


/*-----------------------------------------------------------------------------
  Include files
  -----------------------------------------------------------------------------*/
#include "connect4_functions.h"

// If you would like to use standard library functions other than those
// declared in <stdio.h>, <stdlib.h>, <time.h>, <stdbool.h> (for which
// the #include directives are already given in connect4_functions.h), 
// you may #include the corresponding header files here.



/*=============================================================================
  Constants and definitions
  =============================================================================*/

// If you would like to define constants other than BOARD_SIZE_HORIZ and 
// BOARD_SIZE_VERT, or if you would like to define new types, you may put 
// the corresponding #defines and typedefs here.

#define HORIZ_LINES 2 //Determines where to draw horiz lines
#define VERT_LINES 4 //Determines where to draw vert lines

/*=============================================================================
  Global variables
  =============================================================================*/

// If you would like to use global variables, declare them here.



/*=============================================================================
  Forward function declarations
  =============================================================================*/

// If you would like to use functions other than those already declared in
// connect4_functions.h, put the forward declarations of these functions here.
int check_horizontal(int board[][BOARD_SIZE_VERT], int last_move);
int check_vertical(int board[][BOARD_SIZE_VERT], int last_move);
int check_diagonal(int board[][BOARD_SIZE_VERT], int last_move);



/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  Function Definitions of Required Functions

  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/


/*******************************************************************************
 *                                                                             *
 *                       Function print_welcome()                              *
 *                                                                             *
 ******************************************************************************/
int print_welcome(void)
{
   char choice;

   printf("*** Welcome to the Connect Four game!!! ***\n");
   printf("Would you like to make the first move [y/n]: ");
   scanf("%c", &choice);

   //Clear input buffer
   while (getchar() != '\n');

   //Make user 2nd player if they type 'n' or 'N'
   if (choice == 'n' || choice == 'N') return 2;
   //Otherwise, they go first
   else return 1;
}

/*******************************************************************************
 *                                                                             *
 *                      Function display_board()                               *
 *                                                                             *
 ******************************************************************************/
void display_board(int board[][BOARD_SIZE_VERT])
{
   int i, j;

   for(i=0; i<=HORIZ_LINES*BOARD_SIZE_VERT; i++)
   {
      for(j=0; j<=VERT_LINES*BOARD_SIZE_HORIZ; j++)
      {
         if( i%HORIZ_LINES == 0 && j%VERT_LINES == 0 )
         {
            //At an intersection of two lines
            printf("+");
         } else if ( i%HORIZ_LINES == 0 )
         {
            //At a location of a horizontal line
            printf("-");
         } else if( j%VERT_LINES == 0 )
         {
            //At a location of a vertical line
            printf("|");
         } else if( j%(VERT_LINES/2) == 0 )
         {
            //At location of a player's stone
            if( board[j/VERT_LINES][i/HORIZ_LINES] == 1 )
               printf("X");
            else if( board[j/VERT_LINES][i/HORIZ_LINES] == 2)
               printf("O");
            else printf(" ");
         } else printf(" ");
      }
      printf("\n");
   }

   //Print column numbers
   for(i=0; i<BOARD_SIZE_HORIZ; i++) printf("  %d ", i+1);
   printf("\n");


}

/*******************************************************************************
 *                                                                             *
 *                      Function random_move()                                 *
 *                                                                             *
 ******************************************************************************/
int random_move(int board[][BOARD_SIZE_VERT], int computer_num)
{
   int temp, m;

   //seed rand
   srand(time(0));

   //Find an open column (1 - BOARD_SIZE_HORIZ)
   do{
      temp = rand();
      m = (temp / ((double)RAND_MAX+1)) * (BOARD_SIZE_HORIZ) + 1;
   } while( is_column_full(board, m) );

   //Update the board with the computer's random move
   update_board(board,m,computer_num);

   //Return the column number
   return m;
}

/*******************************************************************************
 *                                                                             *
 *                      Function player_move()                                 *
 *                                                                             *
 ******************************************************************************/
int player_move(int board[][BOARD_SIZE_VERT], int player_num)
{
   int m, i;
   bool valid = false, is_full;

   do
   {
      //Prompt user for a column number and clear input buffer
      printf("Please enter your move: ");
      scanf("%d", &m); while(getchar()!='\n');

      //Determine if move is valid
      for(i=1; i<=BOARD_SIZE_HORIZ; i++)
         if(m == i) valid = true;

      //Determine if column is valid
      is_full = is_column_full(board,m);

      //Prompt user if any errors with moves
      if(valid == false) printf("Not a valid move. Enter a column number!\n");
      else if(is_full == true) printf("This column is full. Try again!\n");

   } while (valid == false || is_full == true); //Loop while move is invalid

   //Update the board
   update_board(board,m,player_num);

   //Return the column number
   return m;
}

/*******************************************************************************
 *                                                                             *
 *                      Function check_win_or_tie()                            *
 *                                                                             *
 ******************************************************************************/
bool check_win_or_tie(int board[][BOARD_SIZE_VERT], int last_move)
{
   bool end_game;

   // Check Winner
   int player_num = check_winner(board, last_move);
   if(player_num) //True if check_winner returns 1 or 2
   {
      switch(player_num) {
         case 1: printf("*****************************\n");
                 printf("* Player X won!!! Game over *\n");
                 printf("*****************************\n");
                 end_game = true;
                 break;
         case 2: printf("*****************************\n");
                 printf("* Player O won!!! Game over *\n");
                 printf("*****************************\n");
                 end_game = true;
      }
   }
   else
   {

      //Check Tie (in no winner)
      bool is_there_tie = true;
      int i, j;

      for(i=0; i<BOARD_SIZE_HORIZ; i++)
         for(j=0; j<BOARD_SIZE_VERT; j++)
            if( board[i][j] == 0 ) is_there_tie = false;

      if (is_there_tie)
      {
         printf("Tie game!\n");
         end_game = true;
      }
   }

   return end_game; //returns true if there is winner or tie
}

/*******************************************************************************
 *                                                                             *
 *                     Function is_column_full()                               *
 *                                                                             *
 ******************************************************************************/
bool is_column_full(int board[][BOARD_SIZE_VERT], int m)
{
   int i;
   bool isFull = true; //Assume column is full

   //Search through column spaces
   for(i = 0; i<BOARD_SIZE_VERT; i++)
   {
      //If any space is 0, then column is not full
      if(board[m-1][i] == 0)
      { 
         isFull = false;
      }
   }

   return isFull;
}

/*******************************************************************************
 *                                                                             *
 *                      Function update_board()                                *
 *                                                                             *
 ******************************************************************************/
void update_board(int board[][BOARD_SIZE_VERT], int m, int player_num)
{
   int i;

   //Find the bottom-most spot in the column
   for(i = BOARD_SIZE_VERT-1; i>=0 && board[m-1][i] != 0; i--);

   //At this point, i is the value of the lowest unoccupied row.
   board[m-1][i] = player_num;
}

/*******************************************************************************
 *                                                                             *
 *                      Function check_winner()                                *
 *                                                                             *
 ******************************************************************************/
int check_winner(int board[][BOARD_SIZE_VERT], int last_move)
{
   int player_num;

   //Check horizontally
   if( (player_num = check_horizontal(board,last_move)) )
   {
      return player_num;
   }
   //Check vertically
   else if( (player_num = check_vertical(board,last_move)) )
   {
      return player_num;
   }
   //Check diagonally
   else if( (player_num = check_diagonal(board,last_move)) )
   {
      return player_num;
   }
   //If all else fails, return 0 (no winner)
   else return 0;
}

/*******************************************************************************
 *                                                                             *
 *                       Function best_move()                                  *
 *                                                                             *
 *******************************************************************************
 *                                                                             *
 *  This is the EXTRA-CREDIT function to be used for the student competition.  *
 *                                                                             *
 ******************************************************************************/
int best_move(int board[][BOARD_SIZE_VERT], int computer_num)
{
   int player_num = 1; //Assume player(opponent) goes first
   //If computer is first, then player(opponent) is second
   if (computer_num == 1) player_num = 2;

   int m; //The column number to be played.
   int i, j; //i to loop through columns, j to loop through rows
   bool best_move_made = false;



   /****  Check if there is a winning move, if so, take it ****/


   /* Check vertically */
   for(i=0; i<BOARD_SIZE_HORIZ; i++)
   {
      for(j=BOARD_SIZE_VERT-1; j>=3; )
         if(board[i][j] == computer_num)
         {
            if(board[i][--j] == computer_num)
               if(board[i][--j] == computer_num)
                  //Check if token can be placed for win
                  if(board[i][--j] == 0)
                  {
                     m = i+1; best_move_made = true; break;
                  }
         } else j--;
      if(best_move_made) break;
   }


   /* Check horizontally */

   //Check for | |x|x|x| match
   if(!best_move_made)
   {
      for(j=BOARD_SIZE_VERT-1; j>=0; j--)
      {
         for(i=0; i<BOARD_SIZE_HORIZ-3; )
            if(board[i][j] == 0)
            {
               if(j == BOARD_SIZE_VERT-1 || board[i][j+1] != 0)
               {
                  if(board[++i][j] == computer_num)
                     if(board[++i][j] == computer_num)
                        if(board[++i][j] == computer_num)
                        {
                           m=i-2; best_move_made = true; break;
                        }
               } else i++;
            } else i++;
         if(best_move_made) break;
      }
   }

   //Check for |x|x|x| | match
   if(!best_move_made)
   {
      for(j=BOARD_SIZE_VERT-1; j>=0; j--)
      {
         for(i=0; i<BOARD_SIZE_HORIZ-3; )
            if(board[i][j] == computer_num)
            {
               if(board[++i][j] == computer_num)
                  if(board[++i][j] == computer_num)
                     if(board[++i][j] == 0)
                     {
                        if(j == BOARD_SIZE_VERT-1 || board[i][j+1] != 0)
                        {
                           m=i+1; best_move_made = true; break;
                        } else i++;
                     }
            } else i++;
         if(best_move_made) break;
      }
   }

   //Check for |x| |x|x| match
   if(!best_move_made)
   {
      for(j=BOARD_SIZE_VERT-1; j>=0; j--)
      {
         for(i=0; i<BOARD_SIZE_HORIZ-3; )
            if(board[i][j] == computer_num)
            {
               if(board[++i][j] == 0)
               {
                  if(j == BOARD_SIZE_VERT-1 || board[i][j+1] != 0)
                  {
                     if(board[++i][j] == computer_num)
                        if(board[++i][j] == computer_num)
                        {
                           m=i-1; best_move_made = true; break;
                        }
                  } else i++;
               }
            } else i++;
         if(best_move_made) break;
      }
   }

   //Check for |x|x| |x| match
   if(!best_move_made)
   {
      for(j=BOARD_SIZE_VERT-1; j>=0; j--)
      {
         for(i=0; i<BOARD_SIZE_HORIZ-3; )
            if(board[i][j] == computer_num)
            {
               if(board[++i][j] == computer_num)
                  if(board[++i][j] == 0)
                  {
                     if(j == BOARD_SIZE_VERT-1 || board[i][j+1] != 0)
                     {
                        if(board[++i][j] == computer_num)
                        {
                           m=i; best_move_made = true; break;
                        }
                     } else i++;
                  }
            } else i++;
         if(best_move_made) break;
      }
   }




   /**** If no winning move, check if the opponent has any winning moves, if so, block it ****/


   /* Check vertically */
   if(!best_move_made)
   {
      for(i=0; i<BOARD_SIZE_HORIZ; i++)
      {
         for(j=BOARD_SIZE_VERT-1; j>=3; )
            if(board[i][j] == player_num)
            {
               if(board[i][--j] == player_num)
                  if(board[i][--j] == player_num)
                     //Check if a block has not already been made
                     if(board[i][--j] == 0)
                     {
                        m = i+1; best_move_made = true; break;
                     }
            } else j--;
         if(best_move_made == true) break;
      }
   }


   /* Check horizontally if a best move has not yet been made. */
   if(best_move_made == false)
   {
      //Check for | |x|x|x|
      for(j=BOARD_SIZE_VERT-1; j>=0; j--)
      {
         for(i=0; i<BOARD_SIZE_HORIZ-3; )
            if(board[i][j] == 0)
            {
               //Check if token can be placed to block
               if(j == BOARD_SIZE_VERT-1 || board[i][j+1] != 0)
               {
                  if(board[++i][j] == player_num)
                     if(board[++i][j] == player_num)
                        if(board[++i][j] == player_num)
                        {
                           m=i-2; best_move_made = true; break;
                        }
               } else i++;
            } else i++;
         if(best_move_made) break;
      }
   }

   //Check for |x| |x|x|
   if(!best_move_made)
   {
      for(j=BOARD_SIZE_VERT-1; j>=0; j--)
      {
         for(i=0; i<BOARD_SIZE_VERT-3; )
         {
            if(board[i][j] == player_num)
            {
               if(board[++i][j] == 0)
               {
                  if(j == BOARD_SIZE_VERT-1 || board[i][j+1] !=0)
                  {
                     if(board[++i][j] == player_num)
                        if(board[++i][j] == player_num)
                        {
                           m=i-1; best_move_made = true; break;
                        }
                  } else i++;
               }
            } else i++;
         }
         if(best_move_made) break;
      }
   }

   //Check for |x|x| |x|
   if(!best_move_made)
   {
      for(j=BOARD_SIZE_VERT-1; j>=0; j--)
      {
         for(i=0; i<BOARD_SIZE_VERT-3; )
            if(board[i][j] == player_num)
            {
               if(board[++i][j] == player_num)
                  if(board[++i][j] == 0)
                  {
                     if(j == BOARD_SIZE_VERT-1 || board[i][j+1] !=0)
                     {
                        if(board[++i][j] == player_num)
                        {
                           m=i; best_move_made = true; break;
                        }
                     } else i++;
                  }
            } else i++;
         if(best_move_made) break;
      }
   }

   //Check for |x|x|x| |
   if(!best_move_made)
   {
      for(j=BOARD_SIZE_VERT-1; j>=0; j--)
      {
         for(i=0; i<BOARD_SIZE_HORIZ-3; )
            if(board[i][j] == player_num)
            {
               if(board[++i][j] == player_num)
                  if(board[++i][j] == player_num)
                     if(board[++i][j] == 0)
                     {
                        //Check if token can be placed to block
                        if(j == BOARD_SIZE_VERT-1 || board[i][j+1] != 0)
                        {
                           m=i+1; best_move_made = true; break;
                        }
                        else i++;
                     }
            } else i++;
         if(best_move_made) break;
      }
   }

   
   /*****  If no winning move or block can be made, then make a random move  *****/
   if(best_move_made == false) m = random_move(board,computer_num);
   /*****           If a best move was determined, update the board          *****/
   else update_board(board,m,computer_num);

   return m;
}






/*=============================================================================
  Function definitions of other functions
  =============================================================================*/

// If you would like to use functions other than those declared in
// connect4_functions.h and implemented above, put the definitions
// of these functions here.

/***   Function check_horizontal()   ***/
/* Checks if there is a horizontal connect 4 */
int check_horizontal(int board[][BOARD_SIZE_VERT],int last_move)
{
   //Find the row of the last token
   int m = 0, player_num = 0;
   while(board[last_move-1][m] == 0) m++;

   //Find 4 consecutive tokens - Search across row of last token
   int i;
   for(i=0; i<BOARD_SIZE_HORIZ-3; )
      if(board[i][m] == board[++i][m])
         if(board[i][m] == board[++i][m])
            if(board[i][m] == board[++i][m])
               if(board[i][m] != 0)
               {
                  player_num = board[i][m];
                  break;
               }

   return player_num;
}



/***   Function check_vertical()   ***/
/* Checks if there is a vertical connect 4 */
int check_vertical(int board[][BOARD_SIZE_VERT], int last_move)
{
   int m, player_num = 0;

   //Find 4 consecutive tokens - Search across column of last token
   for(m=0; m<BOARD_SIZE_VERT-3; )
      if(board[last_move-1][m] == board[last_move-1][++m])
         if(board[last_move-1][m] == board[last_move-1][++m])
            if(board[last_move-1][m] == board[last_move-1][++m])
               if(board[last_move-1][m] !=0)
               {
                  player_num = board[last_move-1][m];
                  break;
               }
   return player_num;
}


/***   Function check_diagonal   ***/
/* Checks if there is a diagonal connect 4 */
int check_diagonal(int board[][BOARD_SIZE_VERT], int last_move)
{
   int player_num = 0;

   //Find the last token placed in last_move's column
   int row = 0, col = last_move-1;
   while(board[col][row] == 0) row++;

   //Find the bottom-left-most position diagonally down to the left of token.
   int start_row = row, start_col = col;
   while(start_row < BOARD_SIZE_VERT-1 && start_col > 0)
   {
      start_row++; start_col--;
   }

   int i, j;
   //Find 4 consecutive tokens - Search across off-diagonal of last token
   for(i=start_col,j=start_row; i<BOARD_SIZE_HORIZ-3 && j>=3; )
      if(board[i][j] == board[++i][--j])
         if(board[i][j] == board[++i][--j])
            if(board[i][j] == board[++i][--j])
               if(board[i][j] != 0)
               {
                  player_num = board[i][j];
                  break;
               }

   if(player_num == 0) //If player_num is still 0, check the other diagonal
   {
      //Find the upper-left-most position diagonally up to the left of token.
      start_row = row; start_col = col;
      while(start_col > 0 && start_row > 0)
      {
         start_col--; start_row--;
      }

      //Find 4 consecutive tokens - Search across on-diagonal of last token
      for(i=start_col,j=start_row; 
            i < BOARD_SIZE_HORIZ-3 && j<BOARD_SIZE_VERT-3; )
         if(board[i][j] == board[++i][++j])
            if(board[i][j] == board[++i][++j])
               if(board[i][j] == board[++i][++j])
                  if(board[i][j] != 0)
                  {
                     player_num = board[i][j];
                     break;
                  }
   }

   return player_num;
}



/******************************************************************************
  End of file
 ******************************************************************************/


