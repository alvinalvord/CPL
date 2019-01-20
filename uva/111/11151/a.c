#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char String[1002];

int
max (int a, int b, int c)
{
	int m = a;
	if (b > m) m = b;
	return m > c ? m : c;
}

int
main ()
{
	int n, i, j, x;
	String str;
	int **arr = malloc (sizeof (int *) * 1001);
	for (i = 0; i < 1001; i++)
		arr[i] = malloc (sizeof (int) * 1001);
	
	scanf("%d", &n);
	fgets (str, sizeof (str), stdin);
	
	for (x = 0; x < n; x++) {
		fgets (str, sizeof (str), stdin);
		
		int len = strlen (str);
		
		for (i = 0; i <= len; i++) {
			arr[i][0] = arr[0][i] = 0;
		}
		
		for (i = 1; i <= len; i++) {
			for (j = 1; j <= len; j++) {
				arr[i][j] = max (
					arr[i - 1][j - 1] + (str[i - 1] == str[len - j - 1]),
					arr[i-1][j], 
					arr[i][j-1]
				);
			}
		}
		printf ("%d\n", arr[len][len]);
	}
	
	for (i = 0; i < 1001; i++)
		free (arr[i]);
	free (arr);
	return 0;
}