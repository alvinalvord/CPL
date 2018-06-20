#include <stdio.h>

int
main ()
{

	int n, m, i, j, sum, a, b, c;
	scanf ("%d", &n);
	
	for (i = 0; i < n; i++) {
		scanf ("%d", &m);
		sum = 0;
		for (j = 0; j < m; j++) {
			scanf ("%d %d %d", &a, &b, &c);
			sum += (a * c);
		}
		printf ("%d\n", sum);
	}	
	
	return 0;
}

