#include <stdio.h>


int
main ()
{
	int n, i, acc, temp;
	int x = 0;
	while (1) {
		x ++;
		scanf ("%d", &n);
		if (n == 0)
			break;
		
		acc = 0;
		for (i = 0; i < n; i++) {
			scanf ("%d", &temp);
			if (temp != 0)
				acc ++;
			else acc --;
		}
		
		printf ("Case %d: %d\n", x, acc);
	}
	
	return 0;
}
