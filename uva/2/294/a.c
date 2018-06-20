#include <stdio.h>
#include <math.h>

int
main ()
{
	int t;
	scanf ("%d", &t);
	
	while (t--)
	{
		int a, b;
		scanf ("%d %d", &a, &b);
		
		int ctr = 0;
		int i, j, lim, max = a, maxdiv = 0;
		for (i = a; i <= b; i++) {
			ctr = 0;
			lim = (int)floor (sqrt (i));
			for (j = 1; j <= lim; j++) {
				if (i % j == 0) {
					if (i / j != j)
						ctr += 2;
					else ctr++;
				}
			}
			
			if (ctr > maxdiv) {
				max = i;
				maxdiv = ctr;
			}
		}
		
		printf ("Between %d and %d, %d has a maximum of %d divisors.\n", 
			a, b, max, maxdiv
		);
		
	}
	
	
	return 0;
}

