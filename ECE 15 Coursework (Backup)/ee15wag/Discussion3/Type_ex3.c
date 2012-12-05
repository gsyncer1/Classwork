#include <stdio.h>

int main()
{
    // declare some variables
    int i1, i2, i3;
    double d1, d2;

    // Let's see what happens if we try some different expressions
    i1 = i2 = 1;
    i3 = 2;
    printf("i1 = %d, i2 = %d, i3 = %d\n\n", i1, i2, i3);
    
    // Demonstrate the order of operations with the ++ operator
    i2 = i1 + i3++;
    printf("We just executed the line i2 = i1 + i3++\n");
    printf("i1 = %d, i2 = %d, i3 = %d\n\n", i1, i2, i3);

    i2 = ++i1 + i3;
    printf("We just executed the line i2 = ++i1 + i3\n");
    printf("i1 = %d, i2 = %d, i3 = %d\n\n", i1, i2, i3);

    // Now let's play with type casting
    d1 = d2 = 10.0;
    printf("d1 = %f, d2 = %f\n\n", d1, d2);
    
    d1 = i1 / i2 * d2;
    printf("We just executed the line d1 = i1 / i2 * d2\n");
    printf("d1 = %f, d2 = %f\n\n", d1, d2);

    d1 = (double)i1 / i2 * d2;
    printf("We just executed the line d1 = (double)i1 / i2 * d2\n");
    printf("d1 = %f, d2 = %f\n\n", d1, d2);

    i3 = i1 / i2 * d2;
    printf("We just executed the line i3 = i1 / i2 * d2\n");
    printf("i1 = %d, i2 = %d, i3 = %d\n", i1, i2, i3);
    printf("d1 = %f, d2 = %f\n\n", d1, d2);

    i3 = (double)i1 / i2 * d2;
    printf("We just executed the line i3 = (double)i1 / i2 * d2\n");
    printf("i1 = %d, i2 = %d, i3 = %d\n", i1, i2, i3);
    printf("d1 = %f, d2 = %f\n\n", d1, d2);
    return 0;
}
