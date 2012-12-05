#include <stdio.h>

int my_strlen(char *s);

int main(int argc, char *argv[])
{
   int i, string_length;
   char myArray[] = "funny Clown";

   for (i = 0; i < argc; i++)
   {
      string_length = my_strlen(argv[i]);
      printf("The string \"%s\" in command line argument location %d", argv[i], i);
      printf(" is %d characters long\n", string_length);

   }
   // Why does the above code give us information about one more word than 
   // we entered as a command line parameter?  How would you "fix" this 
   // problem?
   
   printf("myArray, containing the string \"%s\", ", myArray);
   printf("is %d characters long\n", my_strlen(myArray));

   return 0;
}

int my_strlen(char *s)
{
   int i = 0;

   // Count until you reach the end-of-string termination character
   while (*s != '\0')
   {
      i++;
      s++;
   }
   return i;
}


