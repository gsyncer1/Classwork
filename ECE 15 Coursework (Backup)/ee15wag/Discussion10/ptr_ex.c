#include <stdio.h>

int main()
{
   int x = 5;
   int *px = NULL; // initialize px to point to NULL

   printf("The original value of x is %d\n", x);
   printf("px points to location %p\n\n", px);

   // Make px point at x.
   px = &x;
   printf("px now points to location %p.  x has the address %p.\n", px, &x);
   // Change the value of x.
   *px = 10;
   printf("The new value of x is %d\n", x);
   printf("We can also print the value of x using *px: *px gives %d\n", *px);

   return 0;
}
