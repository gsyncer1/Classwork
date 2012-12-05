#include <stdio.h>

// This program acts like the UNIX "more" command.  It will
// open a file for reading, then output the contents to the screen.

int main()
{
   // Notice the length of the array is automatically determined.
   char inputFilename[] = "input.txt";

   // We need a file pointer.  This one is called infile.
   FILE * infile;

   // We need a place to store what we read from the file so we can
   // print it out again.
   char curr_char;

   // We need to check how many values fscanf reads.
   int num_read; 

   // Open the file for reading, and test that it opened correctly.
   if( (infile = fopen(inputFilename, "r")) == NULL)
   {
      // Output the error message to standard error.
      // This will appear on the screen, like standard out.
      fprintf(stderr, "Could not open %s for reading\n", inputFilename);
      return 1;
   }

   // If we reach this point, the file opened correctly.
   // The following loop is inefficient, but does not require 
   // knowing anything about the contents of the file.
   
   while ( (num_read = fscanf(infile, "%c", &curr_char)) != EOF 
         && num_read  == 1)
   {
      // The while condintion reads one character from the file.

      // Print the character to the screen.
      printf("%c", curr_char);
   } 

   // Close the file.
   fclose(infile);

   return 0;
}

