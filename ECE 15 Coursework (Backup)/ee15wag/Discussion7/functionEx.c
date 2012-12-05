#include <stdio.h>

/* Forward function headers */
int addThree(int a, int b, int c);

int main()
{
   int i1, i2, i3;

   printf("Enter three numbers to add: ");
   scanf("%d%d%d", &i1, &i2, &i3);

   printf("Sum = %d\n", addThree(i1, i2, i3));

   return 0;
}

int addThree(int a, int b, int c)
{
   return a + b + c;
}
