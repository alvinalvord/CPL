#include <stdio.h>
#include <math.h>

int
Mile (int n)
{
	return (int) ceil (n / 30.0) * 10 + ((n % 30 == 0) ? 10: 0);
}

int
Juice (int n)
{
	return (int) ceil (n / 60.0) * 15 + ((n % 60 == 0) ? 15: 0);
}

int
main ()
{
	int t, i, j, n, m;
	
	int mile, juice;
	
	scanf ("%d", &t);
	for (i = 0; i < t; i++) {
		scanf ("%d", &n);
		mile = 0;
		juice = 0;
		
		for (j = 0; j < n; j++) {
			scanf ("%d", &m);
			mile += Mile (m);
			juice += Juice (m);
		}
		
		printf ("Case %d: ", i + 1);
		if (mile == juice) {
			printf ("Mile Juice %d\n", mile);
		} else if (mile < juice) {
			printf ("Mile %d\n", mile);
		} else {
			printf ("Juice %d\n", juice);
		}
		
	}
	
	return 0;
}
