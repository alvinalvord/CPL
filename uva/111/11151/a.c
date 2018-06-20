#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char string[1001];

int
main ()
{
	int t;
	
	scanf ("%d\n", &t);
	
	while (t--) {
		string in;
		fgets (in, sizeof(in), stdin);
		int len = strlen (in) - 1;
		if (len == 0) {
			printf ("0\n");
			continue;
		}
		
		in[len] = 0;
		int i, j, k = len - 1, max = 0;
		
		int **arr = malloc (sizeof (int *) * len);
		for (i = 0; i < len; i++)
			arr[i] = malloc (sizeof (int) * len);
		
		for (i = 0; i < len; i++) {
			for (j = 0; j < len; j++) {
				arr[i][j] = (in[i] == in[k - j]);
				printf ("%d ", arr[i][j]);
			}
			printf ("\n");
		}
		
		i = 0; j = 0;
		int cur, x, y;
		
		for (i = 0; i < len; i++) {
			for (j = 0; j < len; j++) {
				if (arr[i][j]) {
					x = i; y = j; cur = 0;
					
					while (x < len && y < len) {
						if (arr[x][y]) {
							cur++; x++; y++;
						} else x++;
					}
					
					if (cur > max)
						max = cur;
				}
			}
		}
		
		printf ("%d\n", max);
		
		for (i = 0; i < len; i++)
			free (arr[i]);
		free (arr);
	}
	
	return 0;
}
