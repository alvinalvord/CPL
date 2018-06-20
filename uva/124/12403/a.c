#include <stdio.h>

int
main ()
{
	int n, i;
	int acc = 0, temp;
	char buff[10];
	
	scanf ("%d", &n);
	
	for (i = 0; i < n; i++) {
		scanf ("%s", buff);
		if (buff[0] == 'd') {
			scanf ("%d", &temp);
			acc += temp;
		}
		else
			printf ("%d\n", acc);
	}
	
	
	return 0;
}
