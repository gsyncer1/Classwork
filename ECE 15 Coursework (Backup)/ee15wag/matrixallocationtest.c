#include <stdio.h>
#include <stdlib.h>

int **alloc_matrix(int M, int N);

int main()
{
   int m, n; // m rows, n columns
   int **A;

   scanf("%d%d", &m, &n);
   A = alloc_matrix(m,n);

   // work with the matrix...

   int i;
   for(i=0; i<m; i++)
      free(A[i]);

   free(A);
   return 0;
}

int **alloc_matrix(int M, int N)
{
   int **p;
   int *aux;
   int i, j;

   aux = (int *) malloc(M*N*sizeof(int));
   if(aux == NULL) exit(1);

   p = (int **) malloc(M*sizeof(int *));
   if (p == NULL) exit(1);

   for(i=j=0; i<M; i++, j+=N)
      p[i] = &aux[j];
   
   return p;
}
