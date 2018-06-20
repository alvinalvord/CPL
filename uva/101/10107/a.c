#include <stdio.h>
#include <stdlib.h>

void merge (int *left, int *right, int n, int m);
void mergesort (int *arr, int n);

void 
merge (int *left, int *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	int i = 0, j = 0, len = n + m, *arr = malloc (sizeof (int) * len), dex = 0;
	while (i < n && j < m)
		arr[dex++] = ((left[i] < right[j]) ? left[i++] : right[j++]);
	while (i < n) arr[dex++] = left[i++];
	while (j < m) arr[dex++] = right[j++];
	for (i = 0; i < len; i++) left[i] = arr[i];
	free (arr);
}

void 
mergesort (int *arr, int n)
{
	int x = n / 2, y = n - x;
	merge (arr, arr + x, x, y);
}

int
median (int *arr, int size)
{
	int mid = (size - 1) / 2;
	
	return 
		(
			(size % 2 == 1) ? 
			arr[mid] : 
			(arr[mid] + arr[mid + 1]) / 2
		);
}

int
main ()
{
	int *arr, n = 0, dex = -1, *temp, in;
	arr = malloc (sizeof (int));
	while (scanf ("%d", &in) == 1) {
		n++; dex++;
		temp = realloc (arr, sizeof(int) * n);
		arr = temp;
		arr[dex] = in;
		mergesort (arr, n);
		printf ("%d\n", median (arr, n));
	}
	free (arr);
	return 0;
}
