#include <stdio.h>

#define VAR_NAME 'Y'

int main()
{
   char letter_char;
   double a, b;
   int num_chars;

   printf("Enter something in the form Y + a = b: ");

   num_chars = scanf(" %c + %lf = %lf", &letter_char, &a, &b);

   printf("Read %d inputs\n", num_chars);
   printf("letter_char=%c, a=%lf, b=%lf\n", letter_char, a, b);
   printf("letter_char==VAR_NAME: %d (1 means true, 0 means false)\n",
      letter_char == VAR_NAME);


   return 0;
}
