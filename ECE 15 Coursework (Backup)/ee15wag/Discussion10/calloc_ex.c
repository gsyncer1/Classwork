#include <stdio.h>
#include <stdlib.h>

int main()
{
   double *c1, *c2, *m1, *m2;
   int i;

   // allocate some space, using both calloc and malloc
   c1 = (double *) calloc(3, sizeof(double));
   c2 = (double *) calloc(3, sizeof(double));
   m1 = (double *) malloc(3 * sizeof(double));
   m2 = (double *) malloc(3 * sizeof(double));

   // make sure the allocation was successful
   if (c1 != NULL && c2 != NULL && m1 != NULL && m2 != NULL)
   {

      // print out whatever is in the space allocated
      // notice that nothing has explictly been assigned in this code
      for (i=0; i<3; i++) 
      {
         printf("c1[%d]: %lf, ", i, c1[i]);
         printf("m1[%d]: %lf\n", i, m1[i]);
         // another way of accessing the memory
         printf("c2[%d]: %lf, ", i, *(c2+i));
         printf("m2[%d]: %lf\n", i, *(m2+i));
      }

      // free the memory
      free(c1);
      free(c2);
      free(m1);
      free(m2);

     } else {
        printf("Not enough memory\n");
        return 1;
     }
   
   return 0;

}

// Notes:
// Output will vary from machine to machine.  The c1 and c2 arrays should
// contain zeros.  The m1 and m2 contents will vary.
//
// Output from one machine (with floats instead of doubles):
// c1[0] holds 0.00000, m1[0] holds -431602080.00000
// c2[0] holds 0.00000, m2[0] holds -431602080.00000
// c1[1] holds 0.00000, m1[1] holds -431602080.00000
// c2[1] holds 0.00000, m2[1] holds -431602080.00000
// c1[2] holds 0.00000, m1[2] holds -431602080.00000
// c2[2] holds 0.00000, m2[2] holds -431602080.00000 
