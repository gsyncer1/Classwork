#include <stdio.h>

// This program acts like the UNIX "more" command, but writes output
// to a file rather than the screen.  It will open a file for reading,i
// then output the contents to a different file.

// In this example, the input and output file names will be taken from
// the command line.

int main(int argc, char *argv[])
{
   // This time we don't need to specify the file names.  The user
   // will input them on the command line.

   // We need a file pointer.  These ones are called infile and outfile.
   FILE * infile;
   FILE * outfile;

   // We need a place to store what we read from the file so we can
   // print it out again.
   char curr_char;

   // We need to check how many values fscanf reads.
   int num_read;
   int i; // loop variable


   // Check that the user entered the right number of arguments
   if (argc != 3)
   {
      fprintf(stderr,
            "Usage: Enter 2 arguments, the input file and the output file\n");
      return 1;
   } else
   {
      for(i=0; i<3; i++)
         // We'll print the arguments to stdin.
         fprintf(stdout, "Argument %d is %s", i, argv[i]);

   }

   // Open the file for reading, and test that it opened correctly.
   if( (infile = fopen(argv[1], "r")) == NULL)
   {
      // Output the error message to standard error.
      // This will appear on the screen, like standard out.
      fprintf(stderr, "Could not open %s for reading\n", argv[1]);
      return 1;
   }

   // Open the file for writing, and test that it opened correctly.
   if( (outfile = fopen(argv[2], "w")) == NULL)
   {
      // Output the error message to standard error.
      // This will appear on the screen, like standard out.
      fprintf(stderr, "Could not open %s for writing\n", argv[2]);

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

