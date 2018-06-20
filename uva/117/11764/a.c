#include <stdio.h>

int
main ()
{
	int n, m, i, j, low, high, cur, prev;
	scanf ("%d", &n);
	
	for (i = 0; i < n; i++) {
		low = 0; high = 0;
		
		scanf ("%d", &m);
		scanf ("%d", &prev);
		for (j = 1; j < m; j++) {
			scanf ("%d", &cur);
			if (prev < cur) high ++;
			else if (prev > cur) low ++;
			
			prev = cur;
		}
		
		printf ("Case %d: %d %d\n", i + 1, high, low);
	}
	
	
	return 0;
}
