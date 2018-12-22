#include <cstdio>

int
main ()
{
	int n;
	
	scanf ("%d", &n);
	
	int arr[n];
	for (int i = 0; i < n; i++) {
		scanf ("%d", arr + i);
		
		if (!(arr[i] & 1))
			arr[i]--;
		
		printf ("%d ", arr[i]);
	}
	
	return 0;
}
