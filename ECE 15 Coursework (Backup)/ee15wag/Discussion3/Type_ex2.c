#include <stdio.h>

int main()
{
  int i1;
  double d1,result1, result2;

  i1 = 3; // int type
  d1 = 4; // int type

  // division between int and double, with implicit type conversion
  result1 = i1/d1;

  // division with explicit type casting
  // i1 remains type int, but is treated as type double for the calculation
  result2 = (double)i1/d1;

  // notice that you can split a statement over multiple lines if it
  // gets too long
  printf("%d / %f = %f with implicit type conversion (promotion)\n",
          i1, d1, result1);
  printf("%d / %f = %f with explicit type cast\n", i1, d1, result2);

  return 0;
}
