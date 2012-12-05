/******************************************************************************
 *
 * File name: alphabetic_sort.c
 *
 * Author:  Glenn Briones
 *          09175057
 *          gbriones@ucsd.edu
 *
 * Problem #: 2
 *
 * Submission Date: March 18, 2011
 *
 ******************************************************************************/


/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  @                                                                             @
  @                              Include Files                                  @
  @                                                                             @
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  @                                                                             @
  @                 Symbolic Constants and Type Definitions                     @
  @                                                                             @
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  @                                                                             @
  @                           Global Variables                                  @
  @                                                                             @
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/





/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  @                                                                             @
  @                      Forward Function Declarations                          @
  @                                                                             @
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int findAlphaFirstWord(char **wordArray, int num_words);



/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function:
  The program takes in a list of words from a data file, sorts the words in
  alphabetic order, and outputs the list into another file.

  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main(void) 
{
   /* Open files for reading and writing */
   FILE *input;
   FILE *output;
   char inputFileName[] = "alphabetic_sort.dat";
   char outputFileName[] = "alphabetic_sort.out";
   if( (input = fopen(inputFileName,"r")) == NULL)
   {
      fprintf(stdout, "File %s: failed to open for reading", inputFileName);
   } else if( (output = fopen(outputFileName, "w")) == NULL)
   {
      fprintf(stdout, "File %s: failed to open for writing", outputFileName);
      fclose(input);
   }

   int num_words, num_letters;
   int i, j;
   /* Create 2 dimensional array with pointers to create an array of words*/
   char **wordArray, c = '\0';
   fscanf(input, "%d", &num_words);
   wordArray = (char**) malloc(num_words*sizeof(char*));
   for(i = 0; i<num_words; i++)
   {
      fscanf(input, "%d ", &num_letters);
      //Allocate memory for each character in the word
      *(wordArray+i) = (char*) malloc((num_letters+1)*sizeof(char));
      for(j=0; j<=num_letters; j++)
      {
         //scan for a character between a and z, or newline character
         while( !( (c >= 'a' && c <= 'z') || c == '\n') )
         {
            fscanf(input, "%c", &c);
         }
         // Change the new line character to a null character so
         // character array can be treated as a string.
         if(c == '\n') *(*(wordArray+i)+j) = '\0';
         else *(*(wordArray+i)+j) = c;

         c = '\0'; //Set c to null character to enter while loop body again.
      }
   }

   //Sort the words into a sorted word array
   int alphaWordIndex; //<--- Index of the next word alphabetically
   char **sortedWordArray = (char**) malloc(num_words*sizeof(char*));
   for(i=0; i<num_words; i++)
   {
      alphaWordIndex = findAlphaFirstWord(wordArray, num_words);
      sortedWordArray[i] = wordArray[alphaWordIndex];
      wordArray[alphaWordIndex] = NULL;   // Set to NULL so it can be ignored
                                          // in the next iteration.
   }

   // Print to the output the sorted words
   for(i=0; i<num_words; i++)
   {
      fprintf(output, "%s\n", sortedWordArray[i]);
   }

   //Free the memory
   for(i=0; i<num_words; i++)
      free(*(wordArray+i));

   fclose(input); fclose(output);

   return 0;
}



/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  @                                                                             @
  @                            Function Definitions                             @
  @                                                                             @
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

/*** Finds the alphabetically first word in the remaining words in the
 * word array (passed in) ***/
int findAlphaFirstWord(char **wordArray, int num_words)
{
   int i, wordIndex = 0;
   char *alphaFirstWord;

   //Find the first non-NULL pointer
   for(i=0; i< num_words; i++)
   {
      if(wordArray[i] != NULL)
      {
         alphaFirstWord = wordArray[i];
         wordIndex = i;
         break;
      }
   }

   /* Find the alphabetically first word */
   for(i=wordIndex+1; i<num_words; i++)
   {
      if(wordArray[i] == NULL) continue; //Ignore NULL pointers
      else if( strcmp(alphaFirstWord, wordArray[i]) > 0)
      {
         alphaFirstWord = wordArray[i];
         wordIndex = i;
      }
   }

   return wordIndex;
} /* end of findAlphaFirstWord() */



/******************************************************************************

  End of file

 ******************************************************************************/
