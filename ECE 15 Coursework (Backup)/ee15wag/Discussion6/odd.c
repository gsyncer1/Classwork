#include <stdio.h>

#define QTY 14 

int main()
{

   int odd[QTY];
   int i;

   for (i = 0; i < QTY; i++)
      odd[i] = 2*i+1;

   for (i = QTY-1; i>=0; i--)
      printf("%d\n", odd[i]);


   return 0;
}
