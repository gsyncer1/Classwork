#include <stdio.h>

int main()
{
  char str[] = "abcdefghijklmnopqr";
  char str1[] = "abcdefghijklmnopqr##";
  int length = 18;
  int div_len = 5;
  int i,j;

  for(i=0; i<length; i+= div_len)
  {
    for(j=0; j<div_len && j+i<length;j++) // why do we need j+i<length?
    {
      printf("%c", str[i+j]);
    }
    printf("\n");
    for(j=0; j<div_len && j+i<length; j++)
    {
       printf("%c",str1[i+j]);
    }
    printf("\n");
    printf("\n");
  }
}
