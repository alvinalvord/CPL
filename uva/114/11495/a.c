#include <stdio.h>

int swaps;

void
swap (int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

int
bubble (int n, int arr[n])
{
	char flag;
	int temp = n - 1;
	int s = 0;
	int i;
	do {
		flag = 0;
		for (i = 0; i < temp; i++) {
			if (arr[i] > arr[i+1]) {
				flag = 1;
				s++;
				swap (arr + i, arr + i + 1);
			}
		}
		temp --;
	} while (flag);
	
	return s;
}

void
merge (int *left, int *right, int n, int m)
{
	if (n > 1) {
		int x = n / 2;
		int y = n - x;
		merge (left, left + x, x, y);
	}
	if (m > 1) {
		int x = m / 2;
		int y = m - x;
		merge (right, right + x, x, y);
	}
	
	int i = 0, j = 0;
	int size = n + m;
	int arr[size];
	int dex = 0;
	
	while (i < n && j < m) {
		if (left[i] <= right[j]) {
			arr[dex++] = left[i++];
		} else {
			arr[dex++] = right[j++];
			swaps += n - i;
		}
	}
	while (i < n) {
		arr[dex++] = left[i++];
	}
	while (j < m) {
		arr[dex++] = right[j++];
	}
	for (i = 0; i < size; i++) {
		left[i] = arr[i];
	}
}

void
mergesort (int arr[], int n)
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
		
		int arr[n];
		for (i = 0; i < n; i++) {
			scanf ("%d", arr + i);
		}
		
		swaps = 0;
		mergesort (arr, n);
		printf ("%s\n", ((swaps % 2 == 0) ? "Carlos" : "Marcelo"));
	}
	
	return 0;
}
