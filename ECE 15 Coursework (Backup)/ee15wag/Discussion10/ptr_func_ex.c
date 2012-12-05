#include <stdio.h>

void incPassValue(int);
void incPassRef(int *);

int main()
{
   int x = 0;

   printf("The original value of x is %d\n", x);

   // Call a function that increments x when passed by value.
   // Does the value of x change outside the function?
   incPassValue(x);
   printf("After calling incPassValue, x is %d\n", x);
   
   // Call a function that increments x when passed by reference.
   // Does the value of x change outside the function?
   incPassRef(&x);
   printf("After calling incPassRef, x is %d\n", x);

   return 0;
}

void incPassValue(int x)
{
   x++;
   printf("The value of x inside incPassValue is %d\n", x);
}

void incPassRef(int *px)
{
   // Why are the parentheses necessary?
   // *px++; // This line is wrong.  Try it to see what happens.
   (*px)++;
   printf("The value of x inside incPassRef is %d\n", *px);
}
