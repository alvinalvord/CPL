#include <stdio.h>

void
succ (double h, double u, double d, double f, double cur, int c)
{
	if (cur + u > h) {
		printf("success on day %d\n", c);
		return;
	}
	
	if (cur + u - d < 0) {
		printf ("failure on day %d\n", c);
		return;
	}
	
	succ (h, (u - f > 0) ? u - f : 0, d, f, cur + u - d, c + 1);
}

int
main ()
{
	double h, u, d, f;
	
	while (1) {
		scanf ("%lf", &h);
		if (h == 0)
			break;
		scanf (" %lf %lf %lf", &u, &d, &f);
		
		succ (h, u, d, u * f / 100.0, 0.0, 1);
	}
	return 0;
}