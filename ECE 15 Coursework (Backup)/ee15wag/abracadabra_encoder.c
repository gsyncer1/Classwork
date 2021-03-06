/******************************************************************************
 *
 * File name: abracadabra_encoder.c
 *
 * Author:  Glenn Briones
 *          09175057
 *          gbriones@ucsd.edu
 *
 *
 *     Lab #: 2
 * Problem #: 3
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

#define MIN_CHARS 7




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function (describe what your program does here):

  The program encrypts a word that the user enters using a simple substitution
  cipher based on key that the user inputs. It then prints the encrypted word.

  The word must use the characters 'a', 'b', 'c', 'd', and 'r', and no other
  character. 

  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
   char natural_abra[5] = {'a', 'b', 'c', 'd', 'r'};
   char key[5];
   char input_chars[MIN_CHARS], out_chars[MIN_CHARS];
   int i, j, valid_chars = 0;

   printf("Enter key: ");
   for (i = 0; i < 5; i++) key[i] = getchar();

   getchar(); //Discards \n character

   printf("Enter word: ");
   for (i = 0; i < MIN_CHARS; i++) input_chars[i] = getchar();

   while(getchar() != '\n'); //Discards garbage

   //Counts how many valid characters there are.
   for (j = 0; j < 5; j++)
      for (i = 0; i < MIN_CHARS; i++)
         if (natural_abra[j] == input_chars[i]) valid_chars++;

   //If the number of valid characters don't add up to
   //the minimum amount, the program states
   //"You did not speak in ABRA...."
   if (valid_chars != MIN_CHARS) 
   {
      printf("You did not speak in ABRACADABRA to me!\n");
      return 1;
   }

   //Otherwise, the program encrypts the word
   else
   {
      for (j = 0; j < 5; j++)
         for (i = 0; i < MIN_CHARS; i++) //Search through ABRA chars
            if (input_chars[i] == natural_abra[j])
               out_chars[i] = key[j]; //substitute chars

      printf("Encrypted word: ");
      for (i = 0; i < MIN_CHARS; i++) printf("%c", out_chars[i]);
      printf("\n");
   }
   return 0;
}



/******************************************************************************
  End of file
 ******************************************************************************/


