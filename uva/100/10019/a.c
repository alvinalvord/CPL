#include <stdio.h>

int
bt (int n)
{
	int ctr = 0;
	while (n) {
		ctr += (n & 1);
		n >>= 1;
	}
	return ctr;
}

int
toHex (int n)
{
	if (!n) return 0;
	
	int m = n % 10;
	
	return ((toHex (n / 10) << 4) + m);
}

int
main ()
{
	int t, n;
	scanf ("%d", &t);
	while (t--) {
		scanf ("%d", &n);
		printf ("%d %d\n", bt (n), bt (toHex (n)));
	}
	
	return 0;
}
