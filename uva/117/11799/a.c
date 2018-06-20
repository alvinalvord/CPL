#include <stdio.h>

int
main ()
{
	int t, n, i, j, temp, min;
	
	scanf ("%d", &t);
	
	for (i = 0; i < t; i++) {
		min = 0;
		scanf ("%d", &n);
		
		for (j = 0; j < n; j++) {
			scanf ("%d", &temp);
			if (temp > min)
				min = temp;
		}
		
		printf ("Case %d: %d\n", i + 1, min);
	}
	
	
	return 0;
}