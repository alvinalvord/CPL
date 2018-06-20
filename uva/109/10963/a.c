#include <stdio.h>

int
main ()
{
	int t, n, a, b, dist;
	char flag;
	
	scanf ("%d", &t);
	while (t--) {
		scanf ("%d", &n);
		
		scanf ("%d %d", &a, &b);
		dist = a - b;
		n--;
		flag = 1;
		while (n--) {
			scanf ("%d %d", &a, &b);
			
			if (dist != a - b)
				flag = 0;
		}
		
		printf ("%s\n", flag ? "yes" : "no");
		if (t > 0)
			printf ("\n");
	}
	
	return 0;
}
