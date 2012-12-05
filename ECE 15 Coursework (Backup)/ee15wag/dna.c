/******************************************************************************
*
* File name: dna.c
*
* Author:  Glenn Briones
*          099175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 3
* Problem #: 3
*
* Submission Date: Feb 28, 2011
*
******************************************************************************/



/*-----------------------------------------------------------------------------
   Include files
-----------------------------------------------------------------------------*/

#include <stdio.h>



/*=============================================================================
  Constants and definitions
=============================================================================*/

#define MAX_IN_LENGTH 241
#define OUT_LENGTH 60



/*=============================================================================
  Global variables
=============================================================================*/

FILE *input;
FILE *output;
char DNAseq1[MAX_IN_LENGTH], DNAseq2[MAX_IN_LENGTH], DNAseq3[MAX_IN_LENGTH]; 
char DNAcomp12[MAX_IN_LENGTH],DNAcomp13[MAX_IN_LENGTH],DNAcomp23[MAX_IN_LENGTH];



/*=============================================================================
  Forward function declarations
=============================================================================*/

int read_DNA(char sequence[]);
double compare_DNA(char seq1[], char seq2[], char seq3[], int n);
void print_DNA(char seq1[], char seq2[], char seq3[], int n);


/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function:
  The program compares pairs of dna sequences in the file dna_input.dat.
  (There are 3 dna sequence in the dna_input file.)
  In each comparison, the program prints the two DNA sequences with their
  comparison in between. In the comparison line, there is a space if one of DNA
  characters does not matche the DNA character in the ther sequence. Otherwise,
  it prints the matching letter if the letters match in the DNA sequence. The
  program then prints the overlap percentage of the pair of DNA sequences.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
   int char_count1, char_count2, char_count3;
   double overlap_percent1, overlap_percent2, overlap_percent3;

   input = fopen("dna_input.dat","r");
  output = fopen("dna_output.dat", "w");

  /* Reading DNA sequences */
  //each of char counts should have the same value.
  char_count1 = read_DNA(DNAseq1);
  char_count2 = read_DNA(DNAseq2);
  char_count3 = read_DNA(DNAseq3);

  /* Comparing DNA sequences and computing their overlap percentage */
  overlap_percent1 = compare_DNA(DNAseq1, DNAseq2, DNAcomp12, char_count1);
  overlap_percent2 = compare_DNA(DNAseq1, DNAseq3, DNAcomp13, char_count2);
  overlap_percent3 = compare_DNA(DNAseq2, DNAseq3, DNAcomp23, char_count3);

  /* Prints comparison between sequence 1 and sequence 2 */
  fprintf(output, "Comparison between sequence #1 and sequence #2:\n\n");
  print_DNA(DNAseq1, DNAseq2, DNAcomp12, char_count1);
  fprintf(output, "The overlap percentage is %.1lf%%\n\n", overlap_percent1);

  /* Prints comparison between sequence 1 and sequence 3 */
  fprintf(output, "Comparison between sequence #1 and sequence #3:\n\n");
  print_DNA(DNAseq1, DNAseq3, DNAcomp13, char_count2);
  fprintf(output, "The overlap percentage is %.1lf%%\n\n", overlap_percent2);
  
  /* Prints comparison between sequence 2 and sequence 3 */
  fprintf(output, "Comparison between sequence #2 and sequence #3:\n\n");
  print_DNA(DNAseq2, DNAseq3, DNAcomp23, char_count3);
  fprintf(output, "The overlap percentage is %.1lf%%\n\n", overlap_percent3);

  fclose(input); fclose(output);
  
  return 0;
}




/*=============================================================================
  Function definitions
=============================================================================*/


/* Reads a DNA sequence from the file and puts it into an array.
 * It then returns the number of letters. */
int read_DNA(char sequence[])
{
   int letter_count = 0, i = 0;

   //Puts characters from input into array and counts number of letters
   do{
      fscanf(input,"%c",&sequence[i]);
      letter_count++; 
      i++;
   } while (sequence[i-1] != '\n');


   return letter_count-1; //Disregards the newline character
} /* END OF read_DNA */


/* Compares a pair of DNA sequences and stores their comparison into
 * another array. The function also returns the percentage of overlap. */
double compare_DNA(char seq1[], char seq2[], char seq3[], int n)
{
   int i, matches = 0;

   //Compares each character in the sequences and counts the number of matches
   for(i = 0; i < n; i++)
   {
      if (seq1[i] == seq2[i])
      {
         seq3[i] = seq1[i]; //Puts the matching letter into the comparison array
         matches++;
      }
      else seq3[i] = ' '; //Puts blank space into comparison array
   }

   //Subtracting 1 disregards the newline character in calculations
   return (double) (matches)/(n)*100;
} /* END OF compare_DNA */


/* Prints the DNA sequences with their comparison with a maximum of
 * OUT_LENGTH characters per line. */
void print_DNA(char seq1[], char seq2[], char seq3[], int n)
{
   int i,j;

   //Prints the sequences with a maximum of OUT_LENGTH
   //characters per line.
   for(i = 0; i < n; i+= OUT_LENGTH)
   {
      //Prints first DNA sequence
      for(j = 0; j < OUT_LENGTH && j+i < n; j++)
      {
         fprintf(output, "%c", seq1[i+j]);
      }
      fprintf(output, "\n");
      
      //Prints comparison between the two sequences
      for(j = 0; j < OUT_LENGTH && j+i < n; j++)
      {
         fprintf(output, "%c", seq3[i+j]);
      }
      fprintf(output, "\n");

      //Prints second DNA sequence
      for(j = 0; j < OUT_LENGTH && j+i < n; j++)
      {
         fprintf(output, "%c", seq2[i+j]);
      }
      fprintf(output, "\n\n");
   }
} /* END OF print_DNA */



/******************************************************************************
                                End of file
******************************************************************************/


