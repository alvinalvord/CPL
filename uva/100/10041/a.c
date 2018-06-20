#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int
comp (const void *a, const void *b)
{
	return (*((const int *)a) - *((const int *)b));
}

int
main ()
{
	int n, r, i, sum;
	scanf ("%d", &n);
	
	while (n--) {
		scanf ("%d", &r);
		int arr[r];
		for (i = 0; i < r; i++)
			scanf ("%d", arr + i);
		
		sum = 0;
		for (i = 0; i < r - 1; i++)
			sum += abs (arr[i] - arr[i + 1]);
		
		printf ("%d\n", sum);
	}
	
	
	return 0;
}
