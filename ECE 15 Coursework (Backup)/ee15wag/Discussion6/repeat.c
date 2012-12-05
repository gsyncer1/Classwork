#include <stdio.h>

#define NUM_INPUTS 10

int main()
{
   int values[NUM_INPUTS];
   int i, j, repeat_index = -1;
   int count = 0;

   for (i = 0; i < NUM_INPUTS; i++)
   {
      // read a value
      scanf("%d", &values[i]);
      
      // check to see if the input is a repeat
      // (but only if the first repeat hasn't been found)
      if (i == 0) continue;
      else if (repeat_index == -1)
      {
         // check for a repeat in the earlier entries
         for (j = 0; j < i; j++)
         {
            if (values[j] == values[i])
            {
               repeat_index = i;
               count = 2;
            }
         }
      } else {
         // we've already found a repeat, so now just keep count
         if (values[i] == values[repeat_index])
            count++;
      }
   }

   if (count > 0)
      printf("%d was repeated %d times\n", values[repeat_index], count);
   else
      printf("No repeat values found\n");


   return 0;
}
