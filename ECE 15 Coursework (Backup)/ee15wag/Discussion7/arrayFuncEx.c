#include <stdio.h>

/* Forward Function Headers */
void myFunc(int myArray[], int size);
void printArray(int myArray[], int size);

/* Main */

int main()
{
   int arr[5] = {0};

   printArray(arr, 5);

   /* myFunc changes all values in arr to 1 */

   myFunc(arr, 5);
   printArray(arr, 5);

   return 0;
}

/* Function definitions */
void myFunc(int myArray[], int size)
{
   /* Change all values in myArray[] to 1 */
   int i;
   for (i = 0; i<size; i++)
      myArray[i] = 1;
}

void printArray(int myArray[], int size)
{
   /* Print all values in myArray */
   int i;
   for (i = 0; i<size; i++)
      printf("myArray[%d] = %d\n", i, myArray[i]);
   printf("Done printing!\n\n");
}
