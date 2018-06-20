#include <stdio.h>


int
main ()
{
	unsigned long long int n, m, a, b;
	
	scanf ("%I64u %I64u %I64u %I64u", &n, &m, &a, &b);
	
	unsigned long long int destroy = n % m;
	unsigned long long int build = m - destroy;
	
	build *= a;
	destroy *= b;
	
	printf ("%I64u\n", build < destroy ? build : destroy);
	
	
	return 0;
}

