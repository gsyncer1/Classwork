#include <stdio.h> 

int main() 
{
  char string[100], *pstring;

  printf("Array string: ");
  scanf("%s", string);
  printf("%s\n", string);

  printf("Pointer string: ");
  scanf("%s", pstring);
  printf("%s\n", pstring);

  return 0;
}

