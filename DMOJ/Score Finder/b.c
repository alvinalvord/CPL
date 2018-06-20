#include <stdio.h>
#include <stdlib.h>

int
main ()
{
	int n, *arr, m, i;
	scanf ("%d", &n);
	
	arr = malloc (sizeof (int) * n);
	for (i = 0; i < n; i++)
		scanf ("%d", arr + i);
	
	scanf ("%d", &m);
	
	int max = arr[0];
	
	for (i = 0; i < n; i++) {
		if (arr[i] > max)
			max = arr[i];
	}
	
	int *carr = malloc (sizeof (int) * (max + 1));
	for (i = 0; i < (max + 1); i++) {
		carr[i] = 0;
	}
	
	for (i = 0; i < n; i++) {
		carr[arr[i]] ++;
	}
	
	int acc = 0;
	for (i = 0; i < max + 1; i++) {
		acc += carr[i];
		
		if (acc >= m) {
			printf ("%d\n", i);
			break;
		}
	}
	
	
	free (arr);
	free (carr);
	
	return 0;
}
