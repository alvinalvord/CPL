#include <stdio.h>

int
main ()
{
	int n, m, i, j, search, count, temp;
	
	scanf ("%d", &n);
	
	for (i = 0; i < n; i++) {
		scanf ("%d", &m);
		search = 1;
		count = 0;
		for (j = 0; j < m; j++) {
			scanf ("%d", &temp);
			if (temp == search) {
				count++;
				search++;
			}
		}
		printf ("%d\n", m - count);
	}
	
	return 0;
}