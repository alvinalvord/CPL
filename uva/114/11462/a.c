#include <stdio.h>
#include <stdlib.h>

int
comp (const void *a, const void *b)
{
	return (*((const int *) a) - *((const int *)b));
}


int
main ()
{
	int n;
	int i;
	while (1) {
		scanf ("%d", &n);
		if (n == 0)
			break;
		
		int *arr = malloc (sizeof (int) * n);
		
		for (i = 0; i < n; i++)
			scanf ("%d", arr + i);
		
		qsort (arr, n, sizeof (int), comp);
		
		for (i = 0; i < n - 1; i++)
			printf ("%d ", arr[i]);
		printf ("%d\n", arr[i]);
		
		free (arr);
	}
	
	return 0;
}
