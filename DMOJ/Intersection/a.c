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
	int n, m, *arr, len, i;
	
	scanf ("%d %d", &n, &m);
	len = n + m;
	arr = malloc (sizeof (int) * len);
	
	for (i = 0; i < len; i++) {
		scanf ("%d", arr + i);
	}
	
	mergesort (arr, len);
	
	char flag = 0;
	
	for (i = 0; i < len - 1; i++) {
		if (arr[i] == arr[i + 1]) {
			printf ("%d ", arr[i]);
			flag = 1;
		}
	}
	if (flag)
		printf ("\n");
	else printf ("NO INTERSECTIONS\n");
	
	return 0;
}

