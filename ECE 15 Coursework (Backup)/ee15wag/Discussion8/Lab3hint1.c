#include <stdio.h>

/* Hint for P1.  Basically if i2 == 1, perform
func1(), and if i2 == 2 perform func2(). */

double func1(double x);
double func2(double x);

int main()
{
  int i1,i2;
  double d1;
  int i;

  FILE * in;
  const char file_name[] = "ex.txt";

  in = fopen(file_name, "r");

  fscanf(in, "%d%d", &i1, &i2);
  
  for(i=0;i<i1;i++)
  {
    fscanf(in, "%lf", &d1);
    if(i2 == 1)
      printf(" %lf\n",func1(d1)); 
    else
      printf(" %lf\n",func2(d1)); 
  }
  
  fclose(in);
  return 0;
}

double func1(double x)
{
  return x * 2.0;
}

double func2(double x)
{
  return x / 2.0;
}
