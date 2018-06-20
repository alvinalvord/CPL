#include <stdio.h>

void
init (long long int *arr)
{
	arr[0] = 1;
	arr[1] = 1;
	int i;
	for (i = 2; i <= 50; i++) {
		arr[i] = arr[i - 1] + arr[i - 2];
	}
}

int
main ()
{
	long long int arr[51];
	init (arr);
	
	int n;
	
	while (1) {
		scanf ("%d", &n);
		if (!n) break;
		printf ("%lld\n", arr[n]);
	}
	
	return 0;
}
