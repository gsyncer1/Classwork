#include <stdio.h>

int main()
{
   /* Declare variables */
   int oct1, oct2, oct3, oct4;

   /* Prompt for user input, and read the input.  Notice the '.' in the
    * scanf() means that the user MUST enter a '.' or the read will fail. */

   printf("Enter an IP address: ");
   scanf("%d.%d.%d.%d", &oct1, &oct2, &oct3, &oct4);

   /* Give some output */
   printf("The first octet is:\t %03d\n", oct1);
   printf("The second octet is:\t %03d\n", oct2);
   printf("The third octet is:\t %03d\n", oct3);
   printf("The fourth octet is:\t %03d\n", oct4);


   return 0;
}
