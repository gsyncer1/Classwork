#include <stdio.h>

#define TAX 0.0875

FILE *output;
int order[128] = {0};

int main()
{
    double total = 0.0, subtotal = 0.0;
    double amnt_paid, change;
    
    /* Print the menu */
    printf("******* In-N-Out ******\n\n\n");
    printf("Enter the number/letter corresponding to each item.\n\n");
    printf("----- COMBOS -----\n");
    printf("1: Double-Double, French Fries, and Medium Drink\n");
    printf("2: Cheeseburger,  French Fries, and Medium Drink\n");
    printf("3: Hamburger,     French Fries, and Medium Drink\n\n");
    printf("----- MAIN MENU -----\n");
    printf("Q: Double-Double\n");
    printf("W: Cheeseburger\n");
    printf("E: Hamburger\n");
    printf("R: French Fries\n");
    printf("T: Shake\n\n");
    printf("----- DRINKS -----\n");
    printf("A: Coke\n");
    printf("S: Seven-up\n");
    printf("D: Root Beer\n");
    printf("F: Dr. Pepper\n");
    printf("G: Lemonade\n");
    printf("H: Iced Tea\n");
    printf("\n");
    printf("K: Milk\n");
    printf("L: Coffee\n");
    printf("\n");
    
    /* Input items */
    /*
    c = getchar();
    while(1)
    {
        switch(c)
        {
            case '1': order['q']++; order['r']++;
                printf("Drink? "); c = getchar();
                printf("Size?  "); c = getchar();
        }
    } */
    
    fclose(output);
    return 0;
}

