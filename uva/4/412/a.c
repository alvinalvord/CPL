#include <stdio.h>
#include <math.h>

int
hasFactor (int a, int b)
{
	if (b == 0)
		return a;
	
	return hasFactor (b, a % b);
}

int
main ()
{
	int n, i, j;
	
	while (1) {
		scanf ("%d", &n);
		if (n == 0)
			break;
		
		int arr[n];
		for (i = 0; i < n; i++)
			scanf ("%d", arr + i);
		int ctr = 0, pair = 0;
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				pair++;
				if (hasFactor (arr[i], arr[j]) == 1) {
					ctr++;
				}
			}
		}
		
		if (ctr == 0) {
			printf ("No estimate for this data set.\n");
		} else {
			printf ("%.6lf\n", sqrt (6.0 * pair / ctr));
		}
		
	}
	
	return 0;
}
