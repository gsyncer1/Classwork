#include <stdio.h>

int main()
{
   double tank_size, avg_mpg;

   // prompt the user
   printf("How big is your gas tank? ");
   
   // read the input
   scanf("%lf", &tank_size);

   // prompt the user again
   printf("What is the average mpg for your car? ");

   // and read this input
   scanf("%lf", &avg_mpg);

   // output the answer
   printf("You can drive %lf miles on one tank of gas.\n", tank_size*avg_mpg);
   //printf("You can drive %.2lf miles on one tank of gas.\n", 
   //      tank_size*avg_mpg);

   return 0;
}
