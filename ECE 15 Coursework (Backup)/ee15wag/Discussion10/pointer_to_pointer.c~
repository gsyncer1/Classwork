#include <stdio.h>
#include <stdlib.h>
int main()
{
	int **mainArr;
 	int numStudents, quiz, midterm, final,i,j;

	printf("Enter the number of students in your class: ");
	scanf("%d",&numStudents);

	mainArr = (int**)malloc(numStudents*sizeof(int*));


	printf("Enter the number of quizzes in the class: ");
	scanf("%d",&quiz);
	printf("Enter the number of midterms in the class: ");
	scanf("%d",&midterm);	
	printf("Did the class have a final? y=1, n=0:");
	scanf("%d",&final);

	
	printf("\n\n");
	for(i = 0; i< numStudents; i++)
	{
		*(mainArr+i) = (int *) malloc((quiz+midterm+final)*sizeof(int));
		printf("For student #%d\n",i+1);
		for(j = 0; j<quiz+midterm+final; j++)
		{
			printf("Enter score #%d: ",j+1);
			scanf("%d",*(mainArr+i)+j);
		}
		printf("\n");
		
	}

	for(i = 0; i< numStudents; i++)
	{
		printf("Scores of student #%d: ",i+1);
		for(j = 0; j < quiz+midterm+final; j++)
			printf("%d ",*(*(mainArr+i)+j));
		printf("\n");
	}

	for(i = 0; i< numStudents; i++)
		free(*(mainArr+i));

	
	return 0;
}
