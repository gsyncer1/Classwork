#include <stdio.h>

enum{Agrade=1,Bgrade,Cgrade,DontCare};

int main(){
  int grade;
  printf("What grade do you want?\n");
  printf("1.A\t2.B\t3.C\t4.Who cares?\n");
  printf("Answer :  ");
  scanf("%d",&grade);

  switch(grade){
    case Agrade:  // much more intuitive
      printf("You should try very hard!\n");
      break;
    case Bgrade:
      printf("Don't be shy..\n");
      break;
    case Cgrade:
      printf("Are you kidding?\n");
      break;
    case DontCare:
      printf("Drop it before it's too late.\n");
      break;
    default:
      printf("Invalid Answer\n");
      break;  // personal preference
  }
  return 0;
}
