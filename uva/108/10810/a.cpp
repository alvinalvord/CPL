#include <stdio.h>
#include <stdlib.h>

void merge (int *left, int *right, int n, int m);
void mergesort (int *arr, int n);

long long swaps;

void
merge (int *left, int *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, size = n + m, *arr = (int *) malloc (sizeof (int) * size), dex = 0;
	
	while (i < n && j < m) {
		if (left[i] <= right[j]) {
			arr[dex++] = left[i++];
		} else {
			arr[dex++] = right[j++];
			swaps += n - i;
		}
	}
	while (i < n) arr[dex++] = left[i++];
	while (j < m) arr[dex++] = right[j++];
	for (i = 0; i < size; i++) left[i] = arr[i];
	free (arr);
}

void
mergesort (int *arr, int n)
{
	int x = n / 2;
	int y = n - x;
	merge (arr, arr + x, x, y);
}

int
main ()
{
	int n, i;
	
	while (1) {
		scanf ("%d", &n);
		if (n == 0) break;
		
		int *arr = (int *) malloc (sizeof (int) * n);
		for (i = 0; i < n; i++) {
			scanf ("%d", arr + i);
		}
		
		swaps = 0;
		mergesort (arr, n);
		printf ("%lld\n", swaps);
		free (arr);
	}
	
	return 0;
}
