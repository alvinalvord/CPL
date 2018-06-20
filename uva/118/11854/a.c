#include <stdio.h>

void
swap (int *a, int *b)
{
	*a ^= *b;
	*b ^= *a;
	*a ^= *b;
}

int
main ()
{
	int a, b, c;
	
	while (1) {
		scanf ("%d %d %d", &a, &b, &c);
		
		if (a == b && b == c && a == 0)
			break;
		
		if (a > c) {
			if (a > b)
				swap (&a, &c);
			else swap (&b, &c);
		} else if (b > c) {
			swap (&b, &c);
		}
		
		printf ("%s\n",
			(a * a + b * b == c * c) ? "right" : "wrong"
		);
	}
	
	
	return 0;
}
