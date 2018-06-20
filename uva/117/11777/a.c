#include <stdio.h>

int
main ()
{
	int n, i, j, arr[7], min, sum;
	char g;
	scanf ("%d", &n);
	
	for (i = 0; i < n; i++) {
		for (j = 0; j < 7; j++)
			scanf ("%d", arr + j);
		
		min = 4;
		if (arr[5] < arr[min])
			min = 5;
		if (arr[6] < arr[min])
			min = 6;
		
		arr[min] = 0;
		
		sum = 0;
		sum += arr[0];
		sum += arr[1];
		sum += arr[2];
		sum += arr[3];
		sum += (arr[4] + arr[5] + arr[6]) / 2;
		
		g = 'F';
		
		if (sum >= 60) g -= 2;
		if (sum >= 70) g --;
		if (sum >= 80) g --;
		if (sum >= 90) g --;
			
		
		printf ("Case %d: %c\n", i + 1, g);
	}
	
	
	return 0;
}
