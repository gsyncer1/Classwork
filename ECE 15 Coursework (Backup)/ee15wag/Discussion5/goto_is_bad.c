#include <stdio.h>

int main()
{
   int i, j;
   char m[12];
   char f[12] = "dlroW olleH";
   goto seti;

pm: printf("%c", m[i]);

setm: m[i]=f[11-i-1];
      goto ii;

seti: i = 0;
      j = 0;
      goto setm;
ii: i++;
    if (i==11 && j == 0)
    {
       i = 0;
       j = 1;
       goto pm;
    } else if (j == 1)
    {
       if (i == 11)
          goto end;
       goto pm;
    }
    goto setm;

end: printf("\n");
     return 0;
}
