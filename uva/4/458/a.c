#include <stdio.h>

int
main ()
{
	char buff[1024];
	int i;
	
	while (scanf ("%s", buff) == 1) {	
		for (i = 0; buff[i]; i++) {
				buff[i] -= 7;
		}
		
		printf ("%s\n", buff);
	}
	
	return 0;
}
