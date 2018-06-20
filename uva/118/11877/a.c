#include <stdio.h>

void
func (int n)
{
	int acc = 0;
	int mod = 0;
	
	while (n > 0) {
		mod += n % 3;
		n /= 3;
		n += mod / 3;
		mod %= 3;
		acc += n;
	}
	
	if (mod > 1)
		acc++;
	
	printf ("%d\n", acc);
}


int
main ()
{
	int n;
	
	while (1) {
		scanf ("%d", &n);
		if (n == 0)
			break;
		func (n);
	}
	
	return 0;
}
