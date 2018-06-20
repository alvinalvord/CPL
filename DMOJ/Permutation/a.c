#include <stdio.h>

void
gen (int *arr, int dex, int low, int high, int in)
{
	int i;
	if (dex == -1) {
		for (i = low; i <= high; i++) {
			gen (arr, dex + 1, low, high, i);
		}
	} else {
		arr[dex] = in;
		
		if (dex + 1 == high) {
			for (i = 0; i < high; i++) {
				printf ("%d ", arr[i]);
			}
			printf ("\n");
			return;
		}
		
		for (i = low; i <= high; i++) {
			gen (arr, dex + 1, low, high, i);
		}
	}
}

int
main ()
{
	int n;
	
	scanf ("%d", &n);
	
	int arr[n];
	
	gen (arr, -1, 1, n, 0);
	
	return 0;
}
