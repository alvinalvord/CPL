#include <stdio.h>

int
f (int n) 
{
	if (n == 0)
		return n;
	
	return n % 10 + f (n / 10);
}

int 
main ()
{
	int n;
	
	while (1) {
		scanf ("%d", &n);
		if (n == 0)
			break;
		
		do {
			n = f(n);
		} while (n > 9);
		
		printf("%d\n", n);
	}
	
	return 0;
}
