#include <stdio.h>

// This code demonstrates how getchar() works.
// Point out another way of writing while-statements

int main()
{
  char in;

  while((in = getchar())!='Q') printf("%c", in);

  return 0;
}
