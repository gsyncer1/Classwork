#include <stdio.h>
#include <stdlib.h>

#define RANGE_MIN 1
#define RANGE_MAX 6
#define SUM_MIN 2*RANGE_MIN
#define SUM_MAX 2*RANGE_MAX
#define NUM_ROLLS 10000

int main()
{
   int sum[SUM_MAX-SUM_MIN+1] = {0};
   int i, roll1, roll2;

   /* Seed the random number generator */
   srand(100);

   /* Roll and sum the dice, keep track of how many times a sum was seen. */
   for (i = 0; i < NUM_ROLLS; i++)
   {
      roll1 = (rand() / ((double)RAND_MAX+1)) * (RANGE_MAX-RANGE_MIN+1)
         + RANGE_MIN;
      roll2 = (rand() / ((double)RAND_MAX+1)) * (RANGE_MAX-RANGE_MIN+1)
         + RANGE_MIN;
      sum[roll1+roll2-SUM_MIN]++;
   }

   /* Print the results */
   printf("Sum\tTimes Rolled\n");
   for (i = SUM_MIN; i <= SUM_MAX; i++)
   {
      printf("%d\t%d\n", i, sum[i-SUM_MIN]);
   }

   return 0;
}
