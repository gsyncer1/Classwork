#include <stdio.h>

int main()
{
  char in;
  int num;
  printf("Enter an integer : ");
  scanf("%d",&num); // read an integer

  while(getchar() != '\n'); // read until <enter> is read

  printf("Enter a character after $ sign: ");

  while(getchar() != '$');  // read until '$' is read
  in = getchar();

  //scanf(" $%c",&in);

  printf("\nnum : %d   char : %c\n", num, in);
}
