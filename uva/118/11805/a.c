#include <stdio.h>

int
main ()
{
	int t;
	scanf ("%d", &t);

	int n, k, p, i;
	for (i = 0; i < t; i++) {
		scanf ("%d %d %d", &n, &k, &p);
		
		printf ("Case %d: %d\n", i + 1, (k - 1 + p) % n + 1);
	}
	
	return 0;
}
