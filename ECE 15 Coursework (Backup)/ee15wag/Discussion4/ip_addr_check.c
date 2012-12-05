#include <stdio.h>

int main()
{
   /* Declare variables */
   int oct1, oct2, oct3, oct4;

   /* Prompt for user input, and read the input.  Notice the '.' in the
    * scanf() means that the user MUST enter a '.' or the read will fail. */

   printf("Enter an IP address: ");
   scanf("%d.%d.%d.%d", &oct1, &oct2, &oct3, &oct4);

   /* Give some output, checking to make sure each octet is valid */
   if (oct1 >= 0 && oct1 <= 255)
      printf("The first octet is:\t %03d\n", oct1);
   else
      printf("The first octet is:\t Invalid\n");

   if (oct2 >= 0 && oct2 <= 255)
      printf("The second octet is:\t %03d\n", oct2);
   else
      printf("The second octet is:\t Invalid\n");

   if (oct3 >= 0 && oct3 <= 255)
      printf("The third octet is:\t %03d\n", oct3);
   else
      printf("The third octet is:\t Invalid\n");

   if (oct4 >= 0 && oct4 <= 255)
      printf("The fourth octet is:\t %03d\n", oct4);
   else
      printf("The fourth octet is:\t Invalid\n");


   return 0;
}
