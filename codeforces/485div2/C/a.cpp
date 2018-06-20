#include <iostream>
#include <cstdlib>

using namespace std;

typedef struct {
	long long int s;
	long long int c;
	int index;
} node;

void mergesort (node *arr, int n);

void
merge (node *left, node *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, len = n + m, dex = 0;
	node *arr = (node *)malloc (sizeof (node) * len);
	
	while (i < n && j < m) {
		if (left[i].c == right[j].c) {
			if (left[i].s == right[j].s) {
				if (left[i].index < right[j].index) {
					arr[dex++] = left[i++];
				} else {
					arr[dex++] = right[j++];
				}
			}
			else if (left[i].s < right[j].s) {
				arr[dex++] = left[i++];
			}else {
				arr[dex++] = right[j++];
			}
		}
		else if (left[i].c < right[j].c) {
			arr[dex++] = left[i++];
		} else {
			arr[dex++] = right[j++];
		}
	}
	while (i < n) arr[dex++] = left[i++];
	while (j < m) arr[dex++] = right[j++];
	for (i = 0; i < len; i++) left[i] = arr[i];
	
	free (arr);
	
}

void
mergesort (node *arr, int n)
{
	int x = n / 2;
	int y = n - x;
	merge (arr, arr + x, x, y);
}


int
main ()
{
	std::ios::sync_with_stdio(false);
	
	int n, i, j, k;
	long long int min;
	
	cin >> n;
	node arr[n];
	
	for (i = 0; i < n; i++) {
		cin >> arr[i].s;
		arr[i].index = i;
	}
	for (i = 0; i < n; i++)
		cin >> arr[i].c;
	
	// mergesort (arr, n);
	
	min = 0x7fffffffffffffff;
	
	// bool flag = false;
	for (i = 0; i < n - 2; i++) {
		for (j = i + 1; j < n - 1; j++) {
			for (k = j + 1; k < n; k++) {
				if (arr[i].s < arr[j].s && arr[j].s < arr[k].s) {
					min = arr[i].c + arr[j].c + arr[k].c;
				}
			}
			// if (flag) break;
		}
		// if (flag) break;
	}
	
	if (min == 0x7fffffffffffffff)
		min = -1;
	
	cout << min << endl;
	
	return 0;
}

