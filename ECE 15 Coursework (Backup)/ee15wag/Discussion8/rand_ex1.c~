#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
  int seed;

  printf("Enter a seed value: ");
  scanf("%d", &seed);

  srand(1); // seeding with fixed value
  printf("\nWith seed = 1\n");
  printf("Random 1: %d\n", rand()%1000);
  printf("Random 1: %d\n\n", rand()%1000);

  srand(seed); // seeding with the user input
  printf("With seed = %d\n",seed);
  printf("Random 2: %d\n", rand()%1000);
  printf("Random 2: %d\n\n", rand()%1000);

  srand(time(0)); // seeding with time
  printf("With seed = time(0)\n");
  printf("Random 3: %d\n", rand()%1000);
  printf("Random 3: %d\n\n", rand()%1000);

  srand(1); // seeding with the same fixed value above
  printf("With seed = 1\n");
  printf("Random 4? or not? : %d\n", rand()%1000);
  printf("Random 4? or not? : %d\n", rand()%1000);

  return 0;
}
