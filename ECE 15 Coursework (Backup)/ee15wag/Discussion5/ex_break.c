#include <stdio.h>

int main()
{
   char c;

   while(1)
   {
      // Prompt the user for input
      printf("Press any key, Q to quit\n");
      scanf("%c", &c);
      // Print the character we read
      printf("You entered %c\n", c);

      // Why do we need to call getchar?
      // Hint: Try running this program without the call to getchar.
      // What happens? Why?
      //getchar();
      // If you want to clear the rest of the user input, try the line below
      while (getchar() != '\n');

      if(c=='Q')
         // What would happen if we put continue here instead of break?
         break;
   }


   return 0;
}
