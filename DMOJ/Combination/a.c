#include <stdio.h>


void
gen (int *arr, int dex, int lim, int low, int high, int in)
{
	int i;
	if (dex == -1) {
		for (i = low; i <= high; i++) {
			gen (arr, dex + 1, lim, low + 1, high, i);
		}
	} else {
		arr[dex] = in;
		
		if (dex + 1 == lim) {
			for (i = 0; i < lim; i++) {
				printf ("%d ", arr[i]);
			}
			printf ("\n");
			return;
		}
		
		for (i = low; i <= high; i++) {
			if (i > in)
				gen (arr, dex + 1, lim, low + 1, high, i);
		}		
	}
	
}

int
main ()
{
	
	int n, m;
	
	scanf ("%d %d", &n, &m);
	
	int arr[m];
	gen (arr, -1, m, 1, n, 0);
	
	return 0;
}
