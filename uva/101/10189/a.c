#include <stdio.h>
#include <stdlib.h>

int
count (int i, int j, int n, int m, char *map) 
{
	int ctr = 0;
	if (i - 1 >= 0) {
		if (map[(i - 1) * m + j] == '*')
			ctr++;
	}
	if (i - 1 >= 0 && j + 1 < m) {
		if (map[(i - 1) * m + j + 1] == '*')
			ctr++;
	} 
	if (j + 1 < m) {
		if (map[i * m + j+1] == '*')
			ctr++;
	}
	if (i + 1 < n && j + 1 < m) {
		if (map[(i + 1) * m + j + 1] == '*')
			ctr++;
	}
	if (i + 1 < n) {
		if (map[(i + 1) * m + j] == '*')
			ctr++;
	}
	if (i + 1 < n && j - 1 >= 0) {
		if (map[(i + 1) * m + j - 1] == '*')
			ctr++;
	}
	if (j - 1 >= 0) {
		if (map[i * m + j - 1] == '*')
			ctr++;
	}
	if (i - 1 >= 0 && j - 1 >= 0) {
		if (map[(i - 1) * m + j - 1] == '*')
			ctr++;
	}
	return ctr;
}

int
main ()
{
	int n, m, i, j, x = 0;
	
	while (1) {
		x++;
		scanf ("%d %d", &n, &m);
		
		if (n == m && n == 0)
			break;
		else if (x != 1)
			printf ("\n");
		
		char *map = malloc (sizeof (char) * n * m);
		for (i = 0; i < n; i++) {
			scanf ("%s", &map[i * m]);
		}
		
		printf ("Field #%d:\n", x);
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (map[i * m + j] == '*')
					printf ("*");
				else
					printf ("%d", count (i, j, n, m, map));
			}
			printf ("\n");
		}
		
		free (map);
	}
	
	
	return 0;
}
