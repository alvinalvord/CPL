#include <stdio.h>
#include <math.h>

int
main ()
{
	double n, a;
	
	while (scanf ("%lf %lf", &n, &a) == 2) {
		double total = 0;
		double i;
		for (i = 1; i <= n; i++) {
			total += (i * pow (a, i));
		}
		
		printf ("%.0lf\n", total);
	}
	
	return 0;
}
