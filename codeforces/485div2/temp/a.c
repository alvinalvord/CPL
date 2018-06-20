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
		if (left[i] > right[j]) {
			arr[dex++] = right[j++];
		} else {
			arr[dex++] = left[i++];
		}
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
main ()
{
	int arr[10] = {100,5,9,8,6,12,15,7,69,11};
	int i;
	
	mergesort (arr, 10);
	
	for (i = 0; i < 10; i++)
		printf ("%d ", arr[i]);
	
	return 0;
}
