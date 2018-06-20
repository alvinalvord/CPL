#include <stdio.h>

int
main ()
{
	printf ("char arr[20000][6] = {");
	int i;
	for (i = 1; i < 20000; i++) {
		printf ("\"%d\", ", i);
	}
	
	printf ("\"%d\"};", 20000);
	
	return 0;
}
