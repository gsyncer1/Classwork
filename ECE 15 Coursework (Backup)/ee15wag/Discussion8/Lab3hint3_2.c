#include <stdio.h>

int main()
{
  FILE * in;
  const char file_name[] = "ex2.txt";
  char tmp;

  in = fopen(file_name, "r"); // reading mode

  do
  {
    fscanf(in, "%c", &tmp);
    printf("%c", tmp);
  } while(tmp != '\n'); // wait '\n'

  //fclose(in);
  //in = fopen(file_name, "r");

  do
  {
    fscanf(in, "%c", &tmp);
    printf("%c", tmp);
  } while(tmp != '\n'); // wait '\n'


  fclose(in);
}
