#include <stdio.h>


int
main ()
{
	int t, i, min;
	scanf ("%d", &t);
	
	for (i = 0; i < t; i++) {
		int n, d;
		scanf ("%d %d\n", &n, &d);
		
		int arr[n + 2], temp, dex = 1;
		int j; char s, trash;
		arr[0] = 0;
		for (j = 0; j < n; j++) {
			scanf ("%c%c%d%*c", &s, &trash, &temp);
			if (s == 'B') {
				arr[dex++] = temp;
			}
		}
		arr[dex++] = d;
		arr[dex] = -1;
		min = 0;
		
		for (j = 0; arr[j + 1] != -1; j++) {
			temp = arr[j + 1] - arr[j];
			if (temp > min)
				min = temp;
		}
		
		printf ("Case %d: %d\n", i + 1, min);
	}
	
	
	return 0;
}
