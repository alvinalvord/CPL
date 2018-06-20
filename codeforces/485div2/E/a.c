#include <stdio.h>
#include <stdlib.h>

long long int count;

void mergesort (int *arr, int n);

void
merge (int *left, int *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, len = n + m, *arr = malloc (sizeof (int) * len), dex = 0;
	
	while (i < n && j < m) {
		if (left[i] <= right[j]) {
			arr[dex++] = left[i++];
		} else {
			arr[dex++] = right[j++];
			count += n - i;
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
	count = 0;
	int n, *arr, i;
	
	arr = malloc (sizeof (int) * n);
	
	scanf ("%d", &n);
	
	for (i = 0; i < n; i++)
		scanf ("%d", arr + i);
	
	mergesort (arr, n);
	
	if (n % 2 == 0)
		printf ("%s\n", count % 2 == 0 ? "Petr":"Um_nik");
	else
		printf ("%s\n", count % 2 == 1 ? "Petr":"Um_nik");
	
	free (arr);
	return 0;
}
