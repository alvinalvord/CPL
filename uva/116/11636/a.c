#include <stdio.h>

int
main ()
{
	int arr[16];
	int i;
	
	arr[0] = 1;
	for (i = 1; i < 16; i++) {
		arr[i] = arr[i - 1] * 2;
	}
	
	int n, c = 0;

	while (1) {
		c ++;
		scanf ("%d", &n);
		if (n < 0)
			break;
		
		for (i = 0; i < 16; i++) {
			if (n <= arr[i]) {
				printf ("Case %d: %d\n", c, i);
				break;
			}
		}
	}
	
	return 0;
}
