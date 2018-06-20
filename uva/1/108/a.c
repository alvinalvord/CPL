#include <stdio.h>

int
main ()
{
	int n, temp, min = 0x80000000,
		i, j, 
		x, y;
	
	scanf ("%d", &n);
	
	char arr[n][n];
	
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			scanf ("%d", &temp);
			arr[i][j] = temp;
		}
	}
	
	char arr[n][n * n];
	
	
	printf ("%d\n", min);
	
	return 0;
}
