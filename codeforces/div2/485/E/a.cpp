#include <iostream>
#include <cstdlib>

using namespace std;

long long int count;

void mergesort (int *arr, int n);

void
merge (int *left, int *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, len = n + m, *arr = (int *) malloc (sizeof (int) * len), dex = 0;
	
	while (i < n && j < m) {
		if (left[i] > right[j]) {
			arr[dex++] = right[j++];
			count += n - i;
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
	
	cout << "here";
	int x = n / 2;
	int y = n - x;
	merge (arr, arr + x, x, y);
}


int
main ()
{
	count = 0;
	int n, *arr, i;
	
	cin >> n;
	
	arr = (int *) malloc (sizeof (int) * n);
	
	for (i = 0; i < n; i++)
		cin >> arr[i];
	
	mergesort (arr, n);
	cout << (3 * n % count == 0 ? "Petr" : "Um_nik") << endl;
	
	free (arr);
	return 0;
}
