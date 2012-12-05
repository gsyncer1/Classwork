#include <stdio.h>

int main()
{
  int a;

  // Question: Can you re-write this loop so that it does not use break
  // or continue?
  while(1)
  {
    printf("Enter an integer :");
    if (scanf("%d", &a) <1) // if reading is not successful
    {
      continue; // reading = erasing (removing) from input buffer
      //while(getchar() != '\n');
    }
    break;
  }
  printf("You entered %d\n", a);

  return 0;
}











