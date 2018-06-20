#include <stdio.h>

unsigned long int
reverse (unsigned long int n)
{
	unsigned long int m = 0;
	
	while (n > 0) {
		m = n % 10 + m * 10;
		n /= 10;
	}
	
	return m;
}

void
getOut (unsigned long int n)
{
	int ctr = 0;
	unsigned long int rev;
	rev = reverse (n);
	while (1) {
		n += rev;
		ctr++;
		
		rev = reverse (n);
		if (n - rev == 0 || ctr >= 1000)
			break;
	}
	
	printf ("%d ", ctr);
	printf ("%lu\n", n);
}

int
main ()
{
	unsigned long int n, i, in;
	
	scanf ("%lu", &n);
	
	for (i = 0; i < n; i++) {
		scanf ("%lu", &in);
		getOut (in);
	}
	
	return 0;
}
