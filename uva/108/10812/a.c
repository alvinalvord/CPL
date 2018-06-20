#include <stdio.h>

int
main ()
{
	int t, s, d, x, y;
	
	scanf ("%d", &t);
	
	while (t--) {
		scanf ("%d %d", &s, &d);
		
		x = (s + d) / 2;
		y = s - x;
		if (x + y != s)
			printf ("impossible\n");
		else if (x - y != d)
			printf ("impossible\n");
		else if (x < 0)
			printf ("impossible\n");
		else if (y < 0)
			printf ("impossible\n");
		else {
			if (x > y)
				printf ("%d %d\n", x, y);
			else
				printf ("%d %d\n", y, x);
		}
		
	}

	
	return 0;
}
