#include <stdio.h>

int main()
{
  int gender;
  int age;
  char name[20]; //array of chars is like a string type variable

  printf("\nFamily name? ");
  
  /* Reading input strings: No need for & here.  name is already an address */
  scanf("%s", name); 
  
  printf("Gender? (1.M or 2.F) ");
  scanf("%d",&gender); // read the input int
 
  printf("Age?");
  scanf("%2d",&age);   // read the input integer - ignore after 2 digits
  
  if (gender == 1){ // if the gender you input is 1    
    printf("Mr.");  // put Mr.
  } else {            // else
    printf("Ms.");  // put Ms.
  }
  printf("%s is %3d years old.\n",name,age);
  
  return 0;
}
