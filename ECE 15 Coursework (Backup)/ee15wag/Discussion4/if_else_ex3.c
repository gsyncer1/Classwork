#include <stdio.h>

int main()
{
  int grade;
  printf("What grade do you want?\n");
  printf("1.A\t2.B\t3.C\t4.Who cares?\n");
  printf("Answer :  ");
  scanf("%d",&grade);

  if(grade == 1)
    printf("You should try very hard!\n");
  else if(grade == 2)
    printf("Don't be shy..\n");
  else if(grade == 3)
    printf("Are you kidding?\n");
  else if(grade == 4)
    printf("Drop it before it's too late.\n");
  else
    printf("Invalid Answer\n");

  return 0;
}
