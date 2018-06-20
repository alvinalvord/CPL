#include <stdio.h>

int
main ()
{
	char buff[15];
	int t, i, n, j;
	scanf ("%d", &t);
	
	for (i = 0; i < t; i++) {
		scanf ("%d", &n);
		
		char arr[n];
		int dex;
		
		for (j = 0; j < n; j++) {
			scanf ("%s", buff);
			if (buff[0] == 'L')
				arr[j] = -1;
			else if (buff[0] == 'R')
				arr[j] = 1;
			else {
				scanf ("%s", buff);
				scanf ("%d", &dex);
				arr[j] = arr[dex - 1];
			}
		}
		int sum = 0;
		for (j = 0; j < n; j++)
			sum += arr[j];
		
		printf ("%d\n", sum);
	}
	
	return 0;
}
