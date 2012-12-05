#include <stdio.h>

// This program acts like the UNIX "more" command, but writes output
// to a file rather than the screen.  It will open a file for reading,
// then output the contents to a different file.

// In this example, the input and output file names will be taken from
// the command line.

int main()
{
   // Notice the length of the array is automatically determined.
   char inputFilename[] = "input2.txt";
   char outputFilename[] = "output2.txt";

   // We need a file pointer.  These ones are called infile and outfile.
   FILE * infile;
   FILE * outfile;

   // We need a place to store what we read from the file so we can
   // print it out again.
   char curr_char;

   // We need to check how many values fscanf reads.
   int num_read;
   int i; // loop variable


   // Open the file for reading, and test that it opened correctly.
   if( (infile = fopen(inputFilename, "r")) == NULL)
   {
      // Output the error message to standard error.
      // This will appear on the screen, like standard out.
      fprintf(stderr, "Could not open %s for reading\n", inputFilename);
      return 1;
   }

   // Open the file for writing, and test that it opened correctly.
   if( (outfile = fopen(outputFilename, "w")) == NULL)
   {
      // Output the error message to standard error.
      // This will appear on the screen, like standard out.
      fprintf(stderr, "Could not open %s for writing\n", outputFilename);

      // If you're here, you've opened a file for reading.  Close it.
      fclose(infile);

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
      fprintf(outfile, "%c", curr_char);
   }

   // Close the files
   fclose(infile);
   fclose(outfile);

   return 0;
}

