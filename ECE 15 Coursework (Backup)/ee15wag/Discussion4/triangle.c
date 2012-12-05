#include <stdio.h>

int main()
{
   /* Declare variables */
   int height = 7, base = 3;

   /* Print the output.  The first line does integer division (no floating
    * point values are involved).  The second line forces type conversions
    * to floating point because 2.0 is a floating point value.  Notice the
    * different output?  Hint: This is important for the circle problem on
    * the homework! */
   printf("The area as an integer is %d\n", base*height/2);
   printf("The area as a double is %lf\n", base*height/2.0);

   return 0;
}
