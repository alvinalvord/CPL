#include <stdio.h>

int
main ()
{
	int n, i, x;
	
	while (scanf ("%d", &n) == 1) {
		if (n == 1) {
			scanf ("%d", &i);
			printf ("Jolly\n");
			continue;
		}
		
		int arr[n];
		char b[n-1];
		char jolly = 1;
		for (i = 0; i < n; i++) {
			scanf ("%d", &arr[i]);
		}
		
		for (i = 0; i < n - 1; i++)
			b[i] = 0;
		
		for (i = 0; i < n - 1; i++) {
			x = arr[i] - arr[i+1];
			if (x < 0)
				x *= -1;
			
			if (x >= 1 && x <= n - 1)
				b[x - 1] = 1;
			else
				jolly = 0;
		}
		
		
		if (jolly) {
			for (i = 0; i < n - 1; i++) {
				if (!b[i]) {
					jolly = 0;
					break;
				}
			}
		}
		
		if (jolly)
			printf ("Jolly\n");
		else printf ("Not jolly\n");
		
	}

	
	return 0;
}
