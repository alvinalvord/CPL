#include <stdio.h>

void merge (int *left, int *right, int n, int m);
void mergesort (int *arr, int n);

void 
merge (int *left, int *right, int n, int m) 
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	int i = 0, j = 0, size = n + m, arr[size], index = 0;
	while (i < n && j < m) arr[index++] = ((left[i] < right[j]) ? left[i++]: right[j++]);
	while (i < n) arr[index++] = left[i++];
	while (j < m) arr[index++] = right[j++];
	for (i = 0; i < size; i++) left[i] = arr[i];
}

void 
mergesort (int *arr, int n) 
{
	int x = n / 2, y = n - x;
	merge (arr, arr + x, x, y);
}

int
main ()
{
	int n, i;
	scanf ("%d", &n);
	
	int arr[n];
	for (i = 0; i < n; i++)
		scanf ("%d", arr + i);
	
	mergesort (arr, n);
	for (i = 0; i < n; i++)
		printf ("%d ", arr[i]);
	printf ("\n");
	
	return 0;
}
