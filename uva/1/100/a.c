#include <stdio.h>

void
func (int i, int j, int a, int b) {
	int ctr, n, max = 0, oi = i, oj = j;
	int arr[j - i + 1];
	
	for ( ; i <= j; i++) {
		n = i;
		ctr = 1;
		while (n != 1) {
			if (n % 2 == 1) {
				n = 3 * n + 1;
			}
			else {
				n = n / 2;
			}
			ctr++;
		}
		
		arr[i - oi] = ctr;
	}
	
	for (i = 0; i < oj - oi + 1; i++) {
		if (max < arr[i])
			max = arr[i];
	}
	
	printf ("%d %d %d\n", a, b, max);
}

int
main () {
	
	int a, b;
	
	while ((scanf("%d %d", &a, &b)) == 2) {
		if (a < b)
			func (a, b, a, b);
		else 
			func (b, a, a, b);
	}
	
	return 0;
}
