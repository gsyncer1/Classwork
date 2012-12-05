#include <stdio.h>
#include <stdlib.h>

#define RANGE_MIN 1
#define RANGE_MAX 10
#define NUM_RAND 1000000


/* Test to see which method produces better random numbers */

int main()
{
  int i, temp;
  int a, b;
  int seed = 0;
  int rand_nums_a[RANGE_MAX - RANGE_MIN + 1] = {0};
  int rand_nums_b[RANGE_MAX - RANGE_MIN + 1] = {0};
  int err_a = 0, err_b = 0;

  // Seed the random number generator ONCE
  srand(seed);

  for (i = 0; i < NUM_RAND; i++)
  {
      // Get a random number from the generator
      temp = rand();

      // Two ways to modify it to be in the correct range
      a = temp%(RANGE_MAX-RANGE_MIN+1) + RANGE_MIN;
      b = (temp / ((double)RAND_MAX+1)) * (RANGE_MAX-RANGE_MIN+1) + RANGE_MIN;

      // Add to counts for the arrays
      rand_nums_a[a-RANGE_MIN]++;
      rand_nums_b[b-RANGE_MIN]++;
  }

  /* Now we're done getting random numbers.  Print out the values
   * in the histogram. */

   printf("i\trand_nums_a[i]\trand_nums_b[i]\n");
   for (i = RANGE_MIN; i <= RANGE_MAX; i++)
   {
       printf("%d\t%d\t\t%d\n", i, rand_nums_a[i-RANGE_MIN], 
             rand_nums_b[i-RANGE_MIN]);

   }

   /* Use a measure to see how poorly the methods perfomed.  We expect
    * to have NUM_RAND / (RANGE_MAX - RANGE_MIN + 1) in each slot. */
   for (i = RANGE_MIN; i <= RANGE_MAX; i++)
   {
      /* Calculate squared error for a */
      temp = rand_nums_a[i-RANGE_MIN] -
         (NUM_RAND / (RANGE_MAX - RANGE_MIN + 1));
      err_a = err_a + temp*temp;

      /* and for b */
      temp = rand_nums_b[i-RANGE_MIN] -
         (NUM_RAND / (RANGE_MAX - RANGE_MIN + 1));
      err_b = err_b + temp*temp;
   }

   printf("err_a = %d, err_b = %d\n", err_a, err_b);

  return 0;
}
