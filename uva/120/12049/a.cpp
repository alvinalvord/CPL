#include <cstdio>

void mergesort (int *arr, int n);

void
merge (int *left, int *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, dex = 0, len = n + m;
	int arr[len];
	
	while (i < n && j < m) {
		arr[dex++] = (left[i] < right[j]) ? left[i++] : right[j++];
	}
	while (i < n) arr[dex++] = left[i++];
	while (j < m) arr[dex++] = right[j++];
	
	for (i = 0; i < len; i++)
		left[i] = arr[i];
}

void
mergesort (int *arr, int n)
{
	int x = n / 2;
	int y = n - x;
	merge (arr, arr + x, x, y);
}

void
f ()
{
	int n, m;
	scanf ("%d %d", &n, &m);
	
	int arr1[n], arr2[m];
	
	for (int i = 0; i < n; i++) scanf ("%d", arr1 + i);
	for (int i = 0; i < m; i++) scanf ("%d", arr2 + i);
	
	mergesort (arr1, n);
	mergesort (arr2, m);
	
	int os = n;
	if (os < m) os = m;
	
	int out[m]; int dex = 0;
	int i = 0, j = 0;
	while (i < n && j < m) {
		if (arr1[i] == arr2[j]) {
			out[dex++] = arr1[i++];
			j++;
		}
		else if (arr1[i] > arr2[j]) j++;
		else i++;
	}
	
	printf ("%d\n", n + m - dex * 2);
	
}

int
main () 
{
	int t;
	
	scanf ("%d", &t);
	
	while (t--) {
		f ();
	}
	
	return 0;
}
