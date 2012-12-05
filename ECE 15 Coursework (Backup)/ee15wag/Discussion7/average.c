#include <stdio.h>

double average(int arr[], int length);
void zeroBelowAverage(int arr[], int length);


int main()
{
   int myArray[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
   int i;

   /* Print the array so we know what it contains */
   printf("Before computing the average, the array contains: ");
   for (i = 0; i < 10; i++)
      printf("%d ", myArray[i]);
   printf("\n");

   /* Compute and print the average */
   printf("The average is %lf\n", average(myArray, 10));
   
   /* Print the array contents */
   printf("After computing the average, the array contains: ");
   for (i = 0; i < 10; i++)
      printf("%d ", myArray[i]);
   printf("\n");

   /* Zero out all values below the average.  Notice that zeroBelowAverage
    * will need to compute the average */
   zeroBelowAverage(myArray, 10);

   /* Print the array contents */
   printf("After zeroing below average, the array contains: ");
   for (i = 0; i < 10; i++)
      printf("%d ", myArray[i]);
   printf("\n");

   return 0;
}

/* average computes the average of the first length entries in arr[].
 * This assumes that length != 0 */
double average(int arr[], int length)
{
   double sum = 0.0;
   int i;

   for (i = 0; i < length; i++)
      sum += arr[i];

   return sum/length;
}

/* zeroBelowAverage changes all values in the array that are below average 
 * to 0 */
void zeroBelowAverage(int arr[], int length)
{
   int i;
   double avg;

   /* Compute the average */
   avg = average(arr, length);

   /* Zero out appropriate values */
   for (i = 0; i < length; i++)
      if (arr[i] < avg)
         arr[i] = 0;
}
