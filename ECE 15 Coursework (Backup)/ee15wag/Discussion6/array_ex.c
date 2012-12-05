#include <stdio.h>
#define NUM_SCORES 5

int main()
{
   int i,n;
   int score[NUM_SCORES];

   for (i = 0; i < NUM_SCORES; i++){// read students' score
      printf("Input the score of student %d : ",i+1);
      scanf("%d",&score[i]); // array number starts with 0, not 1
      //scanf("%d",score + i); // effectively the same as above
   }

   printf("\nInput Success\n");

   /* Infinite while loop with no way to exit!  Don't copy this! */
   while (1){  // output students' score
      printf("Enter student number : ");
      scanf("%d",&n);
      printf("Student %d's score is %d\n",n,score[n-1]);
   }

   return 0;
}
