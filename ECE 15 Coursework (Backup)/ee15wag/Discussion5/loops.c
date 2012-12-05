#include <stdio.h>

int main()
{
   /* Declare variables */
   int numLetters;
   int i;

   /* Prompt for user input and read response */
   printf("Number: ");
   scanf("%d", &numLetters);

   /* for loop */
   for (i = 0; i < numLetters; i++)
      printf("%c ", 'a'+i);
   printf("\n");

   /* while loop */
   i = 0;
   while (i < numLetters)
   {
      printf("%c ", 'a'+i);
      i++;
   }
   printf("\n");

   /* do-while loop */
   i = 0;
   do
   {
      printf("%c ", 'a'+i);
      i++;
   } while (i < numLetters);
   printf("\n");



   return 0;
}
