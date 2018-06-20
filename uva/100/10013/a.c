#include <stdio.h>

int
main ()
{
	int n, m, i, j, dex;
	
	scanf ("%d", &n);
	
	for (i = 0; i < n; i++) {
		scanf ("%d", &m);
		
		int a1[m];
		int a2[m];
		int carry[m];
		char temp[m + 2];
		char out[m + 2];
		
		for (j = 0; j < m - 2; j++) temp[j] = 0;
		
		for (j = m; j--; ) {
			scanf ("%d %d", a1 + j, a2 + j);
			carry[j] = a1[j] + a2[j];
		}
		
		temp[0] = '0' + carry[0] % 10;
		dex = 1;
		for (j = 1; j < m; j++) {
			carry[j] = carry[j]  + carry[j - 1] / 10;
			temp[dex++] = '0' + carry[j] % 10;
		}
		
		if (carry[m - 1] / 10 > 0)
			temp[dex++] = '0' + carry[m - 1] / 10;

		
		for (j = 0; dex > 0; j++)
			out[j] = temp[--dex];
		
		out[j] = 0;
		
		printf ("%s\n", out);
		
		if (i != n - 1) printf ("\n");
	}
	
	return 0;
}
