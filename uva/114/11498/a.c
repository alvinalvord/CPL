#include <stdio.h>

int
main ()
{
	int k, n, m, x, y, i;
	
	while (1) {
		scanf ("%d", &k);
		if (k == 0)
			break;
		
		scanf ("%d %d", &n, &m);
		
		for (i = 0; i < k; i++) {
			scanf ("%d %d", &x, &y);
			
			if (x == n || y == m)
				printf ("divisa\n");
			else {
				if (y > m)
					printf ("N");
				else
					printf ("S");
				if (x > n)
					printf ("E");
				else
					printf ("O");
				
				printf ("\n");
			}
			
		}
		
	}
	
	
	
	return 0;
}
