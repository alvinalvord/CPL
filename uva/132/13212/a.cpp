#include <iostream>
#include <cstdlib>

using namespace std;

unsigned long long int count;

void mergesort (int *arr, int n);

void
merge (int *left, int *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, len = n + m, dex = 0;
	int *arr = (int *) malloc (sizeof (int) * len);
	
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
	ios::sync_with_stdio (false);
	int n, *arr;
	
	while (true) {
		cin >> n;
		if (n == 0) break;
		count = 0;
		arr = (int *)malloc (sizeof (int) * n);
		
		for (int i = 0; i < n; i++)
			cin >> arr[i];
		
		mergesort (arr, n);
		
		cout << count << endl;
		free (arr);
	}
	
	return 0;
}
