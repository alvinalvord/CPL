#include <stdio.h>

#define ROW 12
#define COL 48
#define LEN 49

int
main ()
{
	char A[ROW][LEN];
	char B[ROW][LEN];
	char C[ROW][LEN];
	char D[ROW][LEN];
	
	int i, j;
	for (i = 0 ; i < ROW; i ++) {
		A[i][COL] = 0;
		B[i][COL] = 0;
		C[i][COL] = 0;
		D[i][COL] = 0;
		for (j = 0; j < COL; j++) {
			A[i][j] = 'A';
			B[i][j] = 'B';
			C[i][j] = 'C';
			D[i][j] = 'D';
		}
	}
	
	int a,b,c,d;
	scanf("%d %d %d %d", &a, &b, &c, &d);
	a--; b--; c--; d--;
	
	i = 1; j = 1;
	while (a--) {
		B[i][j] = 'A';
		j += 2;
		if (j == 47) {
			j = 2;
			i++;
		} else if (j == 48) {
			j = 1;
			i += 2;
		}
	}
	
	i = 1; j = 1;
	while (b--) {
		C[i][j] = 'B';
		j += 2;
		if (j == 47) {
			j = 2;
			i++;
		} else if (j == 48) {
			j = 1;
			i += 2;
		}
	}
	
	i = 1; j = 1;
	while (c--) {
		D[i][j] = 'C';
		j += 2;
		if (j == 47) {
			j = 2;
			i++;
		} else if (j == 48) {
			j = 1;
			i += 2;
		}
	}
	
	i = 1; j = 1;
	while (d--) {
		A[i][j] = 'D';
		j += 2;
		if (j == 47) {
			j = 2;
			i++;
		} else if (j == 48) {
			j = 1;
			i += 2;
		}
	}
	
	printf ("48 48\n");
	for (i = 0; i < ROW; i++)
		printf ("%s\n", A[i]);
	for (i = 0; i < ROW; i++)
		printf ("%s\n", B[i]);
	for (i = 0; i < ROW; i++)
		printf ("%s\n", C[i]);
	for (i = 0; i < ROW; i++)
		printf ("%s\n", D[i]);
	
	return 0;
}
