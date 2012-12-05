#include <stdio.h>

int main()
{
   /* Declare variables */
   int i1, i2;
   int retVal;

   /* Prompt for and get user input */
   printf("Enter two integers:\n");
   retVal = scanf("%d%d", &i1, &i2);

   /* Check for valid user input.  If the user entered the correct types,
    * retVal will be 2, since two values were successfully read and converted
    * to the desired types.  If the user entered an incorrect type (try
    * entering a character rather than a number!), then retVal will not be 2.
    */
   if (retVal != 2)
   {
      printf("Invalid input!  Try running the program again!\n");
      return 1;
   } else
   {
       /* Use the modulo operator, %, to compute the remainder */
       printf("The remainder is %d\n", i1%i2);
   }


   return 0;
}