#include <stdio.h>
#define START_NUM 1
#define END_NUM 5

int main()
{
   int i, j;

   /* Print the top labels */
   printf("\t");
   for (i = START_NUM; i <= END_NUM; i++)
      printf("%d\t", i);
   printf("\n");

   /* Print the table, remembering to label the left column */
   for (i = START_NUM; i <= END_NUM; i++)
   {
      printf("%d\t", i);
      for (j = START_NUM; j <= END_NUM; j++)
         printf("%d\t", i*j);
      printf("\n");
   }

   return 0;
}
