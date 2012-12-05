#include <stdio.h>

#define HORIZ 2
#define VERT 4

int main()
{
   int gridsize=3, i, j;

   // Horizontal lines -  are drawn where i%HORIZ==0
   // Vertical lines | are drawn where j%VERT==0
   // Plus signs should be placed at the intersections.

   for(i=0; i<=HORIZ*gridsize; i++)
   {
      for(j=0; j<=VERT*gridsize; j++)
      {
         if( i%HORIZ == 0 && j%VERT == 0 ) 
         {
            printf("+");
         } else if( i%HORIZ == 0 )
         {
            // We're at a location where the vertical line needs to be drawn
            printf("-");
         } else if( j%VERT == 0 )
         {
            // We're at a location where the horizontal line needs to be drawn
            printf("|");

         } else if( j%(VERT/2) == 0)
         {
            // all other cases need a space drawn
            printf("O");

         } else
         {
            printf(" ");
         }

      }
      printf("\n");
   }
   return 0;
}
