#include <stdio.h>

int
main ()
{
	int a, b, temp, temp1;

	while (scanf ("%d %d", &a, &b) == 2) {
		if (a == b && a == -1)
			break;
		
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		
		temp = b - a;
		temp1 = 100 + a - b;
		
		printf ("%d\n", ((temp < temp1) ? temp : temp1));
		
	}
	return 0;
}
