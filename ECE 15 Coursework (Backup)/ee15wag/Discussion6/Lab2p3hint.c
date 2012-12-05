#include<stdio.h>

int main(){
  int i,j;
  char alpha[6] = "ABCDE"; // why is the array size 6, not 5??
                           // Need room for null character '\0' 
  char in_char[3];

  printf("Original chars : %s\n",alpha);

  printf("Input two chars among A ~ E : ");

  for(i=0;i<2;i++) in_char[i] = getchar();  // read two chars

  for(j=0;j<5;j++)   // compare chars one by one
    for(i=0;i<2;i++)
      if(in_char[i] == alpha[j]) alpha[j] = 'O'; // if they are the same...

  // display the result - two ways. 
  //printf("Changed chars  : %s\n",alpha); // print until meeting '\0'

  printf("Changed chars  : ");
  for(i=0;i<5;i++) printf("%c",alpha[i]); // specify the exact length
  printf("\n");

}
