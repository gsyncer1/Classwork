#include <stdio.h>
#include <stdbool.h>
int main()
{
  int a,b,c;
  while(1){
    printf("\n\n (a, b, c) = ? ");
    scanf("%d%d%d",&a,&b,&c);

    printf("\n The logical value of a = %d",(bool)a);
    printf("\n The logical value of b = %d",(bool)b);
    printf("\n The logical value of c = %d",(bool)c);

    printf("\n\n a || b = %d",a||b);
    printf("\n a || b && c = %d",a||b&&c);
    printf("\n(a || b) && c = %d",(a||b)&&c);

    printf("\n\n !a = %d",!a);
    printf("\n!!a = %d",!!a);
  }
  return 0;
}
