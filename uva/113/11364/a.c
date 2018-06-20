#include <stdio.h>

int
main ()
{
	int t, n, min, max, temp;
	scanf ("%d", &t);
	
	while (t--) {
		scanf ("%d", &n);
		scanf ("%d", &temp);
		min = max = temp;
		
		n--;
		while (n--) {
			scanf ("%d", &temp);
			if (min > temp)
				min = temp;
			if (max < temp)
				max = temp;
		}
		
		temp = (max - min) * 2;
		
		printf ("%d\n", temp);
	}
	
	return 0;
}
