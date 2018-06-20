#include <stdio.h>
#include <math.h>

int
main ()
{
	int x, y;
	scanf ("%d %d", &x, &y);
	
	double xp = pow(x, y);
	double yp = pow(y, x);

	printf ("%c\n", xp > yp ? '>': xp < yp ? '<' : '=');
	
	return 0;
}
