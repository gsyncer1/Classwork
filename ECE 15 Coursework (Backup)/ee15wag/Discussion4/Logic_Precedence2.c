#include <stdio.h>

int main()
{
	int x, y, z, w;
	w = x = y = z = -1;
	printf("++w || z++ || ++x && ++y = %d\n",++w || z++ || ++x && ++y);
	printf("After evaluation, w = %d, x = %d, y = %d, and z = %d. \n",w,x,y,z);
	return 0;
}
