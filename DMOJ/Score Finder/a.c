#include <stdio.h>
#include <stdlib.h>

void mergesort (int *arr, int n);

void
merge (int *left, int *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, len = n + m, *arr = malloc (sizeof (int) * len), dex = 0;
	
	while (i < n && j < m) {
		arr[dex++] = (
			(left[i] < right[j]) ?
			left[i++] : right[j++]
		);
	}
	
	while (i < n) arr[dex++] = left[i++];
	while (j < m) arr[dex++] = right[j++];
	for (i = 0; i < len; i++) left[i] = arr[i];	
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
comp (const void *a, const void *b)
{
	return *((const int *) a) - *((const int *) b);
}

int
main ()
{
	int n, *arr, m, i;
	scanf ("%d", &n);
	
	arr = malloc (sizeof (int) * n);
	for (i = 0; i < n; i++)
		scanf ("%d", arr + i);
	
	qsort (arr, n, sizeof(int), comp);
	
	scanf ("%d", &m);
	
	printf ("%d\n", arr[m - 1]);
	
	free (arr);
	return 0;
}
