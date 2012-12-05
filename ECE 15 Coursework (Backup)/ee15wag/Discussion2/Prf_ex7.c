#include <stdio.h>

/* In this program, we want to calculate 1+2+3+...+10.
 * This program uses a for loop to do the calculation.
 * For loops will be discussed in detail in a future class. */
int main()
{ 
   int i,sum;
   sum = 0;

   // Repeat a loop 10 times, adding the loop index each time
   for(i=0;i<10;i++){ 
      //printf("%d",i); // use printf for simple debugging
      sum = sum + i;
   }

   printf("\nAns : %d\n",sum); // print out the result
   return 0;
}
