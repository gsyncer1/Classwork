#include <stdio.h>
#include <stdlib.h>

/* This program will ask how many integers to store in an array.  It will then
 * dynamically allocate the memory using malloc(), store some numbers in the
 * array, and print them out.  It will finish by releasing the memory, using 
 * free(). */

int main()
{
   int number;
   int *ptr;
   int i;

   printf("How many ints would you like to store? ");
   scanf("%d", &number);

   // dynamically allocate the memory
   // On some compilers, the cast may occur automatically, but the explicit
   // cast is still a good idea!
   ptr = (int *) malloc(number * sizeof(int));

   // make sure memory allocation was successful
   if (ptr != NULL)
   {
      for (i=0; i<number; i++)
      {
         *(ptr+i) = i;
      }

     /* // print out in reverse order
      for (i = number-1; i>=0; i--)
      {
         printf("location %d: %d\n", i, *(ptr+i));
      }*/

      // Two ways of printing out the numbers
      printf("Print using *(ptr+1): ");
      for(i = 0; i< number; i++)
	 printf("%d ",*(ptr+i));
      printf("\n");

      printf("Print using ptr[i]: ");
      for(i = 0; i < number; i++)
         printf("%d ",ptr[i]);
      printf("\n");

      // free the allocated memory
      free(ptr);
   } else {
      printf("Memory allocation failed - not enough memory\n");
      return 1;
   }

   return 0;
}
