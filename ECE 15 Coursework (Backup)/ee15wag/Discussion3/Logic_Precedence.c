#include <stdio.h>

int main()
{
   int x, y, z;
   x = y = z = -1;
   //x = y = z = 0;
   z++ || ++x && ++y;
   printf("x=%d, y=%d, z=%d\n", x, y, z);

   return 0;
}
