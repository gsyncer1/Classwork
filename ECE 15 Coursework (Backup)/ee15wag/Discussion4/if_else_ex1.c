#include <stdio.h>


//enum{LETTER=1, P_NP};

/*
#define LETTER 1
#define P_NP 2
*/

#define LETTER 1

int main()
{
  int ans;
  printf("\nWhat is your grading option?\n");
  printf("1.Letter\t2.Pass/No Pass\n");
  printf("Answer : ");
  scanf("%d",&ans);

  if (ans == LETTER)
  //if (ans != P_NP)
    printf("Your choice is letter grading\n");
  else
    printf("Your choice is P/NP grading\n");

 return 0;
}
