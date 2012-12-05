#include <stdio.h>

// Demonstrates what happens when input buffer is not cleared
// appropriately

int main()
{
  char in;
  int num;
  printf("Enter an integer : ");
  scanf("%d",&num);

  //getchar();
  //while(getchar() != '\n');

  printf("Enter a character : ");

  in = getchar();

  printf("\nnum : %d   char : %c\n", num, in);
}
