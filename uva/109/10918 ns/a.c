#include <stdio.h>

int f (int n);

int 
g (int n)
{
	if (n == 0) return n;
	if (n == 1) return n;
	
	return f(n-1) + g(n-2);
}

int
f (int n)
{
	if (n == 0) return 1;
	if (n == 1) return 0;
	
	return f(n-2) + g(n-1) + g(n-1);
}

int
main ()
{
	int n;
	
	while (1) {
		scanf ("%d", &n);
		if (n == -1) break;
		
		printf ("%d\n", f (n));
	}
	
	return 0;
}
