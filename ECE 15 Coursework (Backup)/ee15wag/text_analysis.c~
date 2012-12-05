/******************************************************************************
 *
 * File name: text_analysis.c
 *
 * Author:  Glenn Briones
 *          09175057
 *          gbriones@ucsd.edu
 *
 * Problem #: 1
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
#include <ctype.h>




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

FILE *input;
FILE *output;




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  @                                                                             @
  @                      Forward Function Declarations                          @
  @                                                                             @
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

void letter_frequency_analysis(int letter_count[]);
void repeated_letter_extraction(int r, int letter_count[]);




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function:
  The program performs various text analyses on multiple lines of text in a
  data file.
  The program first scans the input for an integer r to determine the type
  of text analysis.
  If r is 0, the program performs a letter frequency analysis on the
  corresponding text in the data file.
  If r is greater than 0, the program determines which letters, if any, appear
  at least r times.
  The program terminates when r < 0.

  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main(void) 
{
   char inputFilename[] = "text_analysis.dat";
   char outputFilename[] = "text_analysis.out";

   //Open the files
   if( (input = fopen(inputFilename,"r")) == NULL)
   {
      fprintf(stderr, "Could not %s for reading\n", inputFilename);
      return 1;
   }

   if( (output = fopen(outputFilename,"w")) == NULL)
   {
      fprintf(stderr, "Could not open %s for writing", outputFilename);
      fclose(input);
   }

   int r=0, i, letter_count[26] = {0};


   //Scan the input file for integer r, to determine text analysis type
   fscanf(input, "%d ", &r);

   while(r>=0)
   {
      if(r==0)
      {
         //Perform a letter frequency analysis
         letter_frequency_analysis(letter_count);
      }
      else if (r > 0)
      {
         //Perform a repeated letter extraction
         repeated_letter_extraction(r, letter_count);
      }
      fprintf(output, "\n");
      //Reset all values in letter count to 0.
      for(i=0; i<26; i++)
         letter_count[i] = 0;
      //Scan for the next value of r to determine analysis type.
      fscanf(input, "%d ", &r);
   }


   //Close the files
   fclose(input); fclose(output);
   return 0;
}



/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  @                                                                             @
  @                            Function Definitions                             @
  @                                                                             @
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

/* Function letter_frequency_analysis:
 * The function performs the following tasks:
 * 1. Prints the text from the data file to the output.
 * 2. Counts how many letters in the text.
 * 3. Counts how many distinct letters there are.
 * 4. Lists all the distinct letters in alphabetical order and how many times
 *    they appear in the text.
 * 5. Indicates the most frequent and least frequent letters in the text.
 */
void letter_frequency_analysis(int letter_count[])
{
   int num_letters = 0, num_distinct_letters = 0;
   int low_freq, high_freq, i;
   char c = '\0';

   //Scan a character
   fscanf(input, "%c", &c);
   //Analyze it
   while(c != '\n')
   {
      fprintf(output, "%c", c);
      if( tolower(c)>= 'a' && tolower(c) <='z')
      {
         //Count frequency of each letter
         letter_count[tolower(c)-'a']++;
         num_letters++;
      }
      //Get another character from the file.
      fscanf(input, "%c", &c);
   }
   fprintf(output, "\n");

   //Determine number of distinct letters
   for(i=0; i<26; i++)
      if(letter_count[i] > 0) num_distinct_letters++;
   //Determine most frequent and least frequent letters
   //Find the most frequent letter(s)
   high_freq = 0;
   for(i=0; i<26; i++)
   {
      if(letter_count[i] > high_freq)
         high_freq = letter_count[i];
   }
   //Find the least frequent letter(s)
   low_freq = high_freq; //We can assume low_freq<=high_freq
   for(i=0; i<26; i++)
   {
      if(letter_count[i] < low_freq && letter_count[i]>0)
         low_freq = letter_count[i];
   }

   //Print the results
   fprintf(output, "The text contains %d letters, of which %d are distinct\n", 
         num_letters, num_distinct_letters);
   for(i=0; i<26; i++)
   {
      if(letter_count[i] > 0)
      {
         fprintf(output, "%c: %d ", i+'a', letter_count[i]);
         if(letter_count[i] == high_freq)
            fprintf(output, "<--most frequent ");
         if(letter_count[i] == low_freq)
            fprintf(output, "<--least frequent");
         fprintf(output, "\n");
      }
   }
} /* END OF letter_frequency_analysis() */





/* Function repeated_letter_extraction:
 * The function performs the following tasks:
 * 1. Prints the text from the data file to the output.
 * 2. Indicates the letters which appear at least r times OR
 *    Indicates that none of the letters appear at least r times.
 */
void repeated_letter_extraction(int r, int letter_count[])
{
   int success = 0, i;
   char c, rptd_letter_arr[26] = {'\0'};
   // rptd_letter_arr stores all the distinct letters in the order
   // it was scanned, preserving the letter's case.

   //Scan for a character
   fscanf(input, "%c", &c);

   //Analyze each character
   i=0;
   while(c != '\n')
   {
      fprintf(output, "%c", c);
      if( tolower(c)>= 'a' && tolower(c) <='z')
      {
         //If letter has not yet been scanned, put into rptd_letter_arr
         if(letter_count[tolower(c)-'a'] == 0)
         {
            rptd_letter_arr[i++] = c;
         }
         // Increase the count of that letter
         letter_count[tolower(c)-'a']++;
      }
      fscanf(input, "%c", &c);
   }
   fprintf(output, "\n");

   //Loop through rptd_letter_arr and check which letters appear
   //at least r times
   for(i=0; rptd_letter_arr[i] != '\0'; i++)
   {
      // If any of the letters in the array appear less than r times,
      // change them to null so they won't be printed.
      if(letter_count[tolower(rptd_letter_arr[i])-'a'] < r)
         rptd_letter_arr[i] = '\0';
   }

   //Check if any letters appeared r or more times
   for(i=0; i<26; i++)
      if (rptd_letter_arr[i] != '\0')
      {
         success = 1; break;

      } // Otherwise success = 0 --> No letters appeared at least r times.

   //Print the results
   if(success)
   {
      if(r == 1)
         fprintf(output, "These letters appear at least once: ");
      else if (r == 2)
         fprintf(output, "These letters appear at least twice: ");
      else
         fprintf(output, "These letters appear at least %d or more times: ", r);
      for(i=0; i<26; i++)
         if(rptd_letter_arr[i] != '\0')
            fprintf(output, "%c", rptd_letter_arr[i]);
      fprintf(output, "\n");
   }
   else
   {
      if(r == 1)
         fprintf(output, "No letters appear at least once.\n");
      if(r == 2)
         fprintf(output, "No letters appear at least twice.\n");
      else
         fprintf(output, "No letters appear %d or more times.\n", r);
   }
} /* END OF repeated_letter_extraction() */






/******************************************************************************

  End of file

 ******************************************************************************/
