#include <stdio.h>

void badguy(char sentence[]);

int main()
{
  char sentence[] = "HELLO MAN ~ !!\n";
  printf("%s", sentence);
  badguy(sentence);
  printf("%s", sentence);

  return 0;
}

void badguy(char sen[]) // parameter name doesn't matter
{
  sen[4] = ',';
}
// read_DNA, compare_DNA <-- they should do some similar things!!
