#include <stdio.h>

/* prinf() can be pretty powerful when it's use is mastered.
This example demonstrates how to use printf() appropriately to
print a table. */

int main()
{
   // Make a table using printf
   printf("\n\t%s\n\n","Table1"); // %s print strings, notice use of \t
   printf("Grade\tClass1\tClass2\n");
   printf("%3c%9d%%%7d%%\n",'A',20,30); // %c print char
   printf("%3c%9d%%%7d%%\n",'B',35,40);
   printf("%3c%9d%%%7d%%\n",'C',15,10);
   printf("%3c%9d%%%7d%%\n",'D',27,18);
   printf("%3c%9d%%%7d%%\n\n",'F',3,2);
   return 0;
}
