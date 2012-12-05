#include <stdio.h>
#include <string.h>

int main()
{
	char s1[] = "newton", s2[] = "einstein", s3[] = "shannon";
	printf("\ncompare %s with %s: %d\n\n",s2, s1, strcmp(s2,s1));
	printf("compare %s with %s: %d\n\n",s1, s2, strcmp(s1,s2));
	printf("compare %s with %s: %d\n\n",s3, s3, strcmp(s3,s3));

	if((strcmp(s1,s2) < 0) && (strcmp(s1,s3)<0))
		printf("%s comes before the others\n\n",s1);
	else if((strcmp(s2,s1)) < 0 && (strcmp(s2,s3)<0))
		printf("%s comes before the others\n\n",s2);
	else
		printf("%s comes before the others\n\n",s3);

	return 0;
}
