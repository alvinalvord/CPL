#include <stdio.h>

int
main ()
{
	int t;
	scanf ("%d", &t);
	int arr[10];
	int i, n, temp;
	while (t--) {
		for (i = 0; i < 10 ; i++)
			arr[i] = 0;
		scanf ("%d", &n);
		
		for (i = 1; i <= n; i++) {
			temp = i;
			while (temp > 0) {
				arr[temp % 10]++;
				temp /= 10;
			}
		}
		
		for (i = 0; i < 10; i++) {
			printf ("%d", arr[i]);
			if (i < 9)
				printf (" ");
		}
		printf ("\n");
	}
	
	return 0;
}
