#include <stdio.h>

int main()
{
  int a;
  while(1)
  {
    printf("Enter an integer :");
    if(scanf("%d", &a) <1) // if reading is not successful
    {
      continue; // reading = erasing
      //while(getchar() != '\n');  // ignore the rest of the line?
    }
    break;
  }
  printf("You entered %d\n", a);
}











