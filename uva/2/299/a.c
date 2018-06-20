#include <stdio.h>

void
swap (int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

int
main ()
{
	int n, i, m, j, x, y, count, lim;
	char flag;
	
	scanf ("%d", &n);
	for (i = 0; i < n; i++) {
		scanf ("%d", &m);
		
		int arr[m];
		for (j = 0; j < m; j++) {
			scanf ("%d", arr + j);
		}
		
		lim = m;
		count = 0;
		do {
			flag = 0;
			x = 0;
			y = 1;
			
			while (y < lim) {
				if (arr[x] > arr[y]) {
					swap (&arr[x], &arr[y]);
					count++;
					flag = 1;
				}
				x++; y++;
			}
			
			lim --;
		} while (flag);
		
		printf ("Optimal train swapping takes %d swaps.\n", count);
	}
	
	
	return 0;
}
