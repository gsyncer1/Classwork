#include <stdio.h>
#define S_NUM_CLASS 101
/* Demonstrate the use of #define
Show some more formatting with printf() */

int main()
{
   /* You can adjust the way numbers display by putting proper values
    *  between % and the conversion character. */

   // Allocate 8 spaces for this number!!
   printf("There are %8d students in this class\n",S_NUM_CLASS);
   return 0;
}
