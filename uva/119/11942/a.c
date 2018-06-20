#include <stdio.h>

int
main ()
{
	int t, i, asc, des, cur, prev;
	
	scanf ("%d", &t);
	printf ("Lumberjacks:\n");
	for ( ; t-- ; ) {
		asc = 1; des = 1;
		scanf ("%d", &prev);
		for (i = 9; i-- ; ) {
			scanf ("%d", &cur);
			
			if (asc || des) {
				if (cur > prev) des = 0;
				else asc = 0;
			}
			prev = cur;
		}
		if (asc || des) printf ("Ordered\n");
		else printf ("Unordered\n");
	}
	
	return 0;
}
