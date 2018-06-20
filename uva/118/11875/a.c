#include <stdio.h>

int
main ()
{
	int t, i, j, n, mid, temp;
	scanf ("%d", &t);
	
	for (i = 0; i < t; i++) {
		scanf ("%d", &n);
		mid = n / 2;
		for (j = 0; j < n; j++) {
			scanf ("%d", &temp);
			if (j == mid)
				printf ("Case %d: %d\n", i + 1, temp);
		}
	}
	
	return 0;
}
