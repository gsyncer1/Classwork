#include <stdio.h>

int main()
{
   int myArray[5] = {1, 3, 5, 7, 9};
   int *ptr_array = myArray;
   int i;

   printf("myArray is located at myArray: %p\n", myArray);
   printf("which is also &myArray[0]: %p\n", &myArray[0]);
   printf("or ptr_array: %p\n\n", ptr_array);

   // Print out the elements of the array
   printf("The first element of the array is myArray[0]: %d\n", myArray[0]);
   printf("which can also be accessed as *ptr_array: %d\n\n", *ptr_array);

   // Print out the ith element of the array
   // It is the programmer's responsibility to ensure that i is a valid index!
   i = 3;
   printf("The ith element of the array is myArray[%d]: %d\n", i, myArray[i]);
   printf("which can also be accessed as *(ptr_array+i): %d\n", *(ptr_array+i));
   // Notice in the printf above that the () are necessary!

   return 0;
}
