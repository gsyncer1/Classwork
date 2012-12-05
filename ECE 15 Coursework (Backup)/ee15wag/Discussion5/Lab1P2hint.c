#include<stdio.h>

int main()
{
  int n = 234;

  printf("%d\n", n);
  printf("%d\n", n/10);
  printf("%d\n", n/100);    // or n/10/10
  printf("%d\n", n/1000);   // or n/10/10/10
  printf("%d\n", n/10000);  // or n/10/10/10/10

  return 0;
}


// How many times should we divide n by 10? - When to stop dividing?
// Make use of "%" operator.
// You could use (? :) to get an absolute value of a number
