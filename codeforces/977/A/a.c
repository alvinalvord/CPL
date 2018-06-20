#include <stdio.h>

int
main ()
{
	int n, k;

	scanf ("%d %d", &n , &k);
	
	int mod;
	while (k) {
		mod = n % 10;
		if (mod > 0) {
			if (k >= mod) {
				k -= mod;
				n -= mod;
			} else {
				n -= k;
				k = 0;
			}
		} else {
			n /= 10;
			k --;
		}
	}
	
	printf ("%d\n", n);
	
	return 0;
}
