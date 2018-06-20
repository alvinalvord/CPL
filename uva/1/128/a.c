#include <stdio.h>

int
main ()
{

	char arr[3] = "A";
	
	unsigned short n = 34943;
	n += arr[0];
	// n <<= 8;
	n += arr[1];
	n %= 34943;
	
	printf ("%d %d", n, 0x0C86);
	
	
	return 0;
}
