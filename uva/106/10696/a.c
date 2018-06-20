#include <stdio.h>

int
main ()
{
	int n;
	
	while (1) {
		fscanf (stdin, "%d", &n);
		if (n == 0) break;
		fprintf (stdout, "f91(%d) = %d\n", n, ((n > 100) ? n - 10: 91));
	}
	
	return 0;
}
