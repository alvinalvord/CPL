#include <stdio.h>


int
main ()
{
	int n, i, a, b, c, mid;
	scanf ("%d", &n);
	for (i = 0; i < n; i++) {
		scanf ("%d %d %d", &a, &b, &c);
		
		mid = a;
		
		if ((mid > b && mid > c) || (mid < b && mid < c))
			mid = b;
		
		if ((mid > a && mid > c) || (mid < a && mid < c))
			mid = c;
		
		printf ("Case %d: %d\n", i + 1, mid);
	}
	
	return 0;
}
