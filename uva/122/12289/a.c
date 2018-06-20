#include <stdio.h>

int
main ()
{
	char buff[6];
	int n, i;
	scanf ("%d", &n);
	for (i = 0; i < n; i++) {
		scanf ("%s", buff);
		if (buff[3] == 0) {
			if (buff[0] == 'o' || buff[1] == 'n')
				printf ("1");
			else
				printf ("2");
		} else printf ("3");
		printf ("\n");
	}
	
	
	return 0;
}
