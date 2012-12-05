#include <stdio.h>
#include <stdlib.h>

int main()
{
   int *ptr;
   int i;

   // allocate space for 5 ints, and set the values to 0
   ptr = (int *) calloc(5, sizeof(int));

   // make sure allocation did not fail
   if (ptr == NULL)
   {
      printf("Not enough memory - calloc failed.\n");
      return 1;
   }

   // assign some initial values, using different syntax to access the memory
   *ptr = 1;
   *(ptr+1) = 2;
   ptr[2] = 4;
   ptr[3] = 8;
   ptr[4] = 16;
   /* ptr[5] = 32; not valid - no space allocated for this! */


   // we want more space, so reallocate
   ptr = (int *) realloc(ptr, 7*sizeof(int));

   // make sure reallocation did not fail
   if (ptr == NULL)
   {
      printf("Not enough memory - realloc failed.\n");
      return 1;
   }

   printf("More memory allocated\n");
   ptr[5] = 32; // now this is legal to do!
   ptr[6] = 64;

   // print out the values
   for (i=0; i<7; i++)
      printf("ptr[%d]: %d\n", i, ptr[i]);

   // free the memory in a fancier way than using free()
   // has the same effect
   realloc(ptr, 0);

   return 0;
}

