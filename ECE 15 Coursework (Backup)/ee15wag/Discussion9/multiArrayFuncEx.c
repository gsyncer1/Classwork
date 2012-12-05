#include <stdio.h>
#define SIZE_2 4

/* Forward Function Headers */
void myFunc(int myArray[][SIZE_2], int size);
void printArray(int myArray[][SIZE_2], int size);
void printArrayPretty(int myArray[][SIZE_2], int size);

/* Main */

int main()
{
   int arr[2][SIZE_2] = {{0}};
   int arr2[3][SIZE_2] = { {1, 2, 3, 4}, {10, 20, 30, 40}, {5, 6, 7, 8} };

   printArray(arr, 2);
   printArrayPretty(arr, 2);

   /* myFunc changes all values in arr to 1 */
   myFunc(arr, 2);
   printArray(arr, 2);
   printArrayPretty(arr, 2);
   
   /* Let's look at arr2 */
   printf("arr2 looks like:\n");
   printArrayPretty(arr2, 3);

   return 0;
}

/* Function definitions */
void myFunc(int myArray[][SIZE_2], int size)
{
   /* Change all values in myArray[] to 1 */
   int i, j;
   for (i = 0; i<size; i++)
      for (j = 0; j<SIZE_2; j++)
         myArray[i][j] = 1;
}

void printArray(int myArray[][SIZE_2], int size)
{
   /* Print all values in myArray */
   int i, j;
   for (i = 0; i<size; i++)
      for (j = 0; j<SIZE_2; j++)
         printf("myArray[%d][%d] = %d\n", i, j,  myArray[i][j]);
   printf("Done printing!\n\n");
}

void printArrayPretty(int myArray[][SIZE_2], int size)
{
   /* Print all values in myArray */
   int i, j;

   printf("Printing pretty!\n\n");
   for (i = 0; i<size; i++)
   {
      for (j = 0; j<SIZE_2; j++)
         printf(" %d ", myArray[i][j]);
   
      printf("\n");
   }
   printf("Done printing pretty!\n\n");
}
