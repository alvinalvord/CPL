#include <stdio.h>

int
main ()
{
	int n, m, sum = 0, i, temp, total;
	
	scanf ("%d %d", &n, &m);
	total = n * m;
	
	for (i = 0; i < n; i++) {
		scanf ("%d", &temp);
		sum += temp;
	}
	
	if (sum < total) {
		printf ("NOT ENOUGH FOOD\n");
	} else if (sum == total) {
		printf ("JUST ENOUGH FOR EVERYONE\n");
	} else {
		printf ("PARTY!\n");
	}
	
	return 0;
}
