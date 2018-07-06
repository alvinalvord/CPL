#include <iostream>
#include <cstdio>
#include <float.h>

int 
main ()
{
	int n, k;
	
	scanf ("%d %d", &n, &k);
	int arr[n];
	
	for (int i = 0; i < n; i++)
		scanf ("%d", arr + i);
	
	double max = -DBL_MAX;
	double temp;
	for (int i = 0; i < n - k + 1; i++) {
		temp = 0;
		for (int j = i; j < i + k; j++) 
			temp += arr[j];
		if (temp > max)
			max = temp;
	}
	
	printf ("%.15lf\n", max/k);
	
	return 0;
}
