#include <stdio.h>

#define MIN_IN_HOUR 60

int main()
{
   int number_of_minutes;

   // Prompt the user for input
   printf("How many prime time minutes are in your monthly cell phone plan? ");
   
   // Read the user input
   scanf("%d", &number_of_minutes);

   // Output the answer
   printf("You can talk for %d hours.\n", number_of_minutes/MIN_IN_HOUR);

   return 0;
}
