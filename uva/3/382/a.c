#include <stdio.h>

int
s (int n)
{
	int sum = 1, i, lim = n / 2, x, y;
	
	for (i = 2; i < lim; i++) {
		if (n % i == 0) {
			x = i;
			y = n / i;
			
			lim = y;
			
			sum += x;
			sum += y;
		}
	}
	
	return sum;
}


int
main ()
{
	int n, sum;
	
	printf ("PERFECTION OUTPUT\n");
	
	while (1) {
		scanf ("%d", &n);
		if (!n) break;
		
		if (n == 1) {
			printf ("%5d  DEFICIENT\n", 1);
			continue;
		}
		
		sum = s (n);
		
		if (sum > n) printf ("%5d  ABUNDANT\n", n);
		else if (sum < n) printf ("%5d  DEFICIENT\n", n);
		else printf ("%5d  PERFECT\n", n);
		
		
	}
	
	printf ("END OF OUTPUT\n");
	
	return 0;
}

