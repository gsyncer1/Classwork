#include <stdio.h>

int main()
{
   /* Declare variables */
   char current;
   char previous = 0;
   int count = 0;

   /* Prompt for user input, and start reading response letter by letter. */
   printf("Please enter a phrase:\n");
   scanf("%c", &current);
   /* Loop to read the rest of the user input.  If the letter read is the 
    * same as the previous letter, increment the count.  Then, store the
    * current letter as the previous letter before reading the next letter. */
   while (current != '\n')
   {
      if (previous == current)
         count++;

      previous = current;
      scanf("%c", &current);
   }

   /* Print the result */
   if (count == 1)
      printf("There was 1 double letter.\n");
   else
      printf("There were %d double letters.\n", count);


   return 0;
}
