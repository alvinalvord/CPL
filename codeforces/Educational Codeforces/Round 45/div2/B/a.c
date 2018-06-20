#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int
main ()
{
	long long int n, k;
	scanf ("%I64d %I64d", &n, &k);
	
	long long int *arr = malloc (sizeof (long long int) * n);
	int i, j;
	
	for (i = 0; i < n; i++) {
		scanf("%I64d", arr + i);
	}
	
	char *d = malloc (sizeof (char) * n);
	long long int total = 0;
	memset (d, 1, n);
	
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			if (d[j]) {
				if (arr[i] > arr[j] && arr[i] <= arr[j] + k)
					d[j] = 0;
			}
		}
	}
	
	for (i = 0; i < n; i++) {
		total += d[i];
	}
	
	printf ("%I64d\n", total);
	
	free (arr);
	free (d);
	return 0;
}

