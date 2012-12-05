#include <stdio.h>

int main()
{
   int num1, num2, i=0;

   // The following is an infinite loop with no way out.  This is BAD
   // programming practice - you should not write code like this!
   // To stop running the program, you can type Ctrl-C to quit.
   while( 1 )
   {
      i++;
      printf("Enter two integers to divide: ");
      scanf("%d%d", &num1, &num2);
      if(num2 == 0)
         continue;
      printf("i=%d, num1/num2=%d/%d=%d\n", i, num1, num2, num1/num2);

   }

   return 0;
}
