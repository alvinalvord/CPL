#include <iostream>

using namespace std;

int
main ()
{
	ios::sync_with_stdio(false);
	int n, m;
	
	cin >> n >> m;
	int arr[10];
	int a[n];
	int b[m];
	int i;
	
	for (i = 0; i < 10; i++) {
		arr[i] = 0;
	}
	
	for (i = 0; i < n; i++) {
		cin >> a[i];
		arr[a[i]]++;
	}
	
	for (i = 0; i < m; i++) {
		cin >> b[i];
		arr[b[i]]++;
	}
	
	for (i = 0; i < n; i++) {
		if (arr[a[i]] == 2) {
			printf ("%d ", a[i]);
		}
	}
	
	return 0;
}
