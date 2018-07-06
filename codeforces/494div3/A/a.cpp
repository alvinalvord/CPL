#include <iostream>
#include <cstdio>

int 
main ()
{
	int arr[101];
	for (int i = 0; i < 101; i++)
		arr[i] = 0;
	
	int n, temp;
	scanf ("%d", &n);
	
	for (int i = 0; i < n; i++) {
		scanf ("%d", &temp);
		arr[temp] ++;
	}
	
	int max = 1;
	
	for (int i = 0; i < 101; i++) 
		if (arr[i] > max)
			max = arr[i];
	
	
	printf ("%d\n", max);
	return 0;
}
