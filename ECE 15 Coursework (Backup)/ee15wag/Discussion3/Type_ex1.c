#include <stdio.h>

int main()
{
  int i1,i2;
  double d1,d2;

  i1 = 3; // int type
  i2 = 4; // int type
  d1 = i1/i2; // division between int
  d2 = (double)i1/(double)i2; // division with type casting
                              // i1 and i2 remain type int, but are
                              // treated as type double for the calculation
  printf("%d / %d = %f without type cast\n", i1, i2, d1);
  printf("%d / %d = %f with type cast\n", i1, i2, d2);
  return 0;
}
