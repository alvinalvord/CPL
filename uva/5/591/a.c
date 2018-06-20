#include <stdio.h>


int
main ()
{
	int n;
	int set = 0;
	while (1) {
		set++;
		scanf ("%d", &n);
	
		if (n == 0)
			break;
		
		int arr[n], i;
		int sum = 0;
		
		for (i = 0; i < n; i++) {
			scanf ("%d", arr + i);
			sum += arr[i];
		}
		
		sum /= n;
		
		int moves = 0;
		
		for (i = 0; i < n; i++) {
			if (arr[i] > sum)
				moves += (arr[i] - sum);
		}
		
		printf ("Set #%d\n", set);
		printf ("The minimum number of moves is %d.\n\n", moves);
	}
	
	return 0;
}
