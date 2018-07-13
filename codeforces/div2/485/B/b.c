#include <stdio.h>
#include <math.h>

int
main ()
{
	int x, y;
	scanf ("%d %d", &x, &y);
	
	if (x >= 3 && y >= 3) {
		printf ("%c\n", x < y ? '>': x > y ? '<': '=');
	} else {
		double lx = log(x) / x;
		double ly = log(y) / y;
		printf ("%c\n", lx > ly ? '>': lx < ly ? '<': '=');
	}
	
	
	return 0;
}
