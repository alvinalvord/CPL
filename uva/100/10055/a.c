#include <stdio.h>

int
main ()
{
	unsigned long a, b;
	
	while (fscanf (stdin, "%lu %lu", &a, &b) == 2) {
		if (a < b)
			printf ("%lu\n", b - a);
		else printf ("%lu\n", a - b);
	}
	
	return 0;
}

