#include <stdio.h>

int
main ()
{
	int t, n, i, j;
	scanf ("%d", &t);
	
	for (i = 0; i < t; i++) {
		scanf ("%d", &n);
		
		int arr[n];
		double ave = 0;
		for (j = 0; j < n; j++) {
			scanf ("%d", arr + j);
			ave += arr[j];
		}
		ave /= n;
		
		int ctr = 0;
		for (j = 0; j < n; j++)
			if (arr[j] > ave)
				ctr ++;
			
		printf ("%.3lf%c\n", ctr * 100.0 / n, '%');
	}
	
	
	return 0;
}
