#include <stdio.h>

void
func (int x, int y)
{
	int acc = 0;
	int mod = 0;
	
	do {
		while (x > 0) {
			acc += x;
			mod += (x % y);
			x /= y;
		}
		x = mod / y;
		mod %= y;
	} while (x > 0);
	
	printf ("%d\n", acc);
}


int
main ()
{
	int x, y;
	
	while (scanf ("%d %d", &x, &y) == 2) {
		func (x, y);
	}
	
	return 0;
}
