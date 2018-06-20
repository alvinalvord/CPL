#include <stdio.h>

int
nessy (int n, int m)
{
	return (n / 3) * (m / 3);
}

int
main ()
{
	int t;
	scanf ("%d", &t);
	
	int n, m;
	while (t--) {
		scanf ("%d %d", &n, &m);
		
		printf ("%d\n", nessy (n, m));
	}
	
	return 0;
}
