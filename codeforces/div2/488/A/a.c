#include <stdio.h>

int
main ()
{
	int n, m;
	
	scanf ("%d %d", &n, &m);
	int arr[10];
	int a[n];
	int b[m];
	int i;
	
	for (i = 0; i < 10; i++) {
		arr[i] = 0;
	}
	
	for (i = 0; i < n; i++) {
		scanf ("%d", a + i);
		arr[a[i]]++;
	}
	
	for (i = 0; i < m; i++) {
		scanf ("%d", b + i);
		arr[b[i]]++;
	}
	
	for (i = 0; i < n; i++) {
		if (arr[a[i]] == 2) {
			printf ("%d ", a[i]);
		}
	}
	
	printf ("\n");
	return 0;
}
