#include <stdio.h>

int
main ()
{
	int n, temp, min = -1270000,
		i, j, k, l;
	
	while (scanf ("%d", &n) == 1) {
		int arr[n][n];
		
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				scanf ("%d", &temp);
				arr[i][j] = temp;
				if (i > 0) arr[i][j] += arr[i-1][j];
				if (j > 0) arr[i][j] += arr[i][j-1];
				if (i > 0 && j > 0) arr[i][j] -= arr[i-1][j-1];
			}
		}
		
		int max = min;
		
		for (i = 0; i < n; i++) for (j = 0; j < n; j++)
		for (k = i; k < n; k++) for (l = j; l < n; l++) {
			temp = arr[k][l];
			if (i > 0) temp -= arr[i-1][l];
			if (j > 0) temp -= arr[k][j-1];
			if (i > 0 && j > 0) temp += arr[i-1][j-1];
			
			if (temp > max)
				max = temp;
		}
		
		printf ("%d\n", max);
	}
	
	return 0;
}
