#include <stdio.h>

#define DegPerTick (360 / 40)

void 
func (int s, int a, int b, int c)
{
	int total = 120;
	int temp;
	
	if (a > s) {
		temp = s + 40 - a;
	} else {
		temp = s - a;
	}
	total += temp;
	
	if (b > a) {
		temp = b - a;
	} else {
		temp = b + 40 - a;
	}
	total += temp;
	
	if (c > b) {
		temp = b + 40 - c;
	} else {
		temp = b - c;
	}
	total += temp;
	
	total *= DegPerTick;
	printf ("%d\n", total);
}

int
main ()
{
	int s, a, b, c;
	
	while (1) {
		scanf ("%d %d %d %d", &s, &a, &b, &c);
		if (s == a && a == b && b == c && c == 0)
			break;
		
		func (s, a, b, c);
	}
	
	return 0;
}
