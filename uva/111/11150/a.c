#include <stdio.h>
#include <math.h>

void
func (int n)
{
	int acc = 0;
	int mod = 0;
	do {
		while (n > 0) {
			acc += n;
			mod += n % 3;
			n /= 3;
		}
		n = mod / 3;
		mod %= 3;
	} while (n > 0);
	
	if (mod > 1)
		acc ++;
	
	printf ("%d\n", acc);
}

int
main ()
{
	int n;
	
	while (scanf ("%d", &n) == 1) {
		func (n);
	}
	
	return 0;
}
