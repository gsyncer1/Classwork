/******************************************************************************
*
* File name: hopscotch.c
* 
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
* Problem #: 3
*
* Submission Date: March 18, 2011
*
******************************************************************************/


/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@                                                                             @
@                              Include Files                                  @
@                                                                             @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

#include <stdio.h>
#include <stdlib.h>



/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@                                                                             @
@                 Symbolic Constants and Type Definitions                     @
@                                                                             @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

#define FIELDWIDTH 3 //The width of the hopscotch field.



/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@                                                                             @
@                           Global Variables                                  @
@                                                                             @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

FILE *input;
FILE *output;




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@                                                                             @
@                      Forward Function Declarations                          @
@                                                                             @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int tally_max(int *tally_row, int middle_index);
int** alloc_hopscotchArr(int fieldLength, int fieldWidth);
int** alloc_tallyArr(int fieldLength, int fieldWidth);




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function:
  The program takes in an array of integers, representing a hopscotch field
  with a certain number of marbles in each square. The program determines
  the optimal path through which someone can gain the most marbles.
  The game:
  At each hop through the hopscotch field, the person may either jump down to
  the left (L), straight down (D), or down to the right (R). The person
  collects whatever marbles lie in square. The challenge is to find the path
  which will allow the collectin of the most marbles.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main(void) 
{
  //Open files for reading and writing
   char inputFileName[] = "hopscotch.dat";
  char outputFileName[] = "hopscotch.out";

  if( (input = fopen(inputFileName, "r")) == NULL)
  {
     fprintf(stderr, "Could not open %s for reading\n", inputFileName);
     return 1;
  }

  if( (output = fopen(outputFileName, "w")) == NULL)
  {
     fprintf(stderr, "Could not open %s for writing\n", outputFileName);
     fclose(input);
     return 1;
  }

  int fieldLength, i, j;
  // Scan the input for the length of the field
  fscanf(input, "%d", &fieldLength);

  // Allocate memory for the integers in the hopscotch (marble) array
  // and tally array.
  int **hopscotchArr = alloc_hopscotchArr(fieldLength, FIELDWIDTH);
  int **tallyArr = alloc_tallyArr(fieldLength, FIELDWIDTH);


  // Scan the input file for the integer (marble) array and put into
  // the hopscotch array.
  for(i=0; i<fieldLength; i++)
  {
     for(j=0; j<FIELDWIDTH; j++)
     {
        fscanf(input, "%d", &hopscotchArr[i][j]);
     }
  }


  //Calculate the tally array
  for(i=0; i<fieldLength; i++)
  {
     for(j=0; j<FIELDWIDTH; j++)
     {
        tallyArr[i][j] =
          //Find the max value from the previous row 
           ( ((i-1) < 0) ? 0 : tallyArr[i-1][tally_max(tallyArr[i-1],j)] )
          //Add the number of marbles at the current square 
           + hopscotchArr[i][j];
     }
  }

  // Find the score of the path, which is the highest tally value in the last row
  // of the tally array
  int path_score = tallyArr[fieldLength-1][tally_max(tallyArr[fieldLength-1],1)];

  // Determine of the path through the field of the highest possible score
  char hop_path[fieldLength+1];
  int current_row = fieldLength, current_pos = 1, previous_pos;
  for(i=current_row; i>=0; i--)
  {
     if(i==0) previous_pos = 1;
     else previous_pos = tally_max(tallyArr[i-1], current_pos);

     switch(current_pos - previous_pos){
        case -1: hop_path[i] = 'L';
                 break;
        case 0: hop_path[i] = 'D';
                break;
        case 1: hop_path[i] = 'R';
                break;
     }

     current_pos = previous_pos;
  }

  // Print to the output the results
  fprintf(output, "Maximum possible score: %d\n", path_score);
  fprintf(output, "A path that achieves this score: ");
  for(i=0; i<=fieldLength; i++)
     fprintf(output, "%c", hop_path[i]);
  fprintf(output, "\n");


  return 0;
}



/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@                                                                             @
@                            Function Definitions                             @
@                                                                             @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/


/* Function tally_max:
 * Takes in a row of tallies from a tally array, and the middle index
 * to check for the maximum tally value of among the hopscotch square
 * to the left of the middle index, the square of the middle index, and
 * the square to the right of the middle index. Checks to see if indices
 * to the left and right of middle index exist (in the cases that
 * middle_index == 0 or middle_index == fieldLength-1) 
 */
int tally_max(int* tally_row, int middle_index) //FUNC//
{
   int k, value = 0, max_value_index = -1;
   for(k=middle_index-1; k<=middle_index+1; k++)
   {
      if(k >= 0 && k < FIELDWIDTH)
         if(tally_row[k] > value) 
         {
            value = tally_row[k];
            max_value_index = k;
         }

   }
   return max_value_index;

} /* END OF tally_max() */



/* Function alloc_hopscotchArr:
 * Allocates memory for an array of integers to represent the number
 * of marbles in each hopscotch square.
 */
int **alloc_hopscotchArr(int fieldLength, int fieldWidth)
{
   int **hopArr;
   int *aux1;
   int i, j;

   aux1 = (int *) malloc(fieldLength*fieldWidth*sizeof(int));
   if (aux1 == NULL) exit(1);

   hopArr = (int **) malloc(fieldLength*sizeof(int *));
   if(hopArr == NULL) exit(1);

   for(i=j=0; i<fieldLength; i++, j+=fieldWidth)
      hopArr[i] = &aux1[j];

   return hopArr;
} /* END OF alloc_hopscotchArr() */


/* Function alloc_tallyArr:
 * Allocates memory for an array of integers to represent the square
 * tallies of each hopscotch square.
 */
int **alloc_tallyArr(int fieldLength, int fieldWidth)
{
   int **talArr;
   int *aux2;
   int i, j;

   aux2 = (int *) malloc(fieldLength*fieldWidth*sizeof(int));
   if (aux2 == NULL) exit(1);

   talArr = (int **) malloc(fieldLength*sizeof(int *));
   if(talArr == NULL) exit(1);

   for(i=j=0; i<fieldLength; i++, j+=fieldWidth)
      talArr[i] = &aux2[j];

   return talArr;
} /* END OF alloc_tallyArr() */





/******************************************************************************

                                End of file

******************************************************************************/
