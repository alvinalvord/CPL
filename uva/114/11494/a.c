#include <stdio.h>

int
a (int x)
{
	return x > 0 ? x : x * -1;
}

int
main ()
{
	int sx, sy, gx, gy;
	
	while (1) {
		scanf ("%d %d %d %d", &sx, &sy, &gx, &gy);
		
		if (!(sx | sy | gx | gy)) break;
		
		if (sx == gx && sy == gy) {
			printf ("0\n");
		} else if (
			!(gx - sx) ||
			!(gy - sy) ||
			!(a(gx - sx) - a(gy - sy))
		) {
			printf ("1\n");
		} else printf ("2\n");
	}
	
	
	return 0;
}
