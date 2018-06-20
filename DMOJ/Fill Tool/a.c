#include <stdio.h>

struct node {
	int n;
	int m;
	char t;
	char f;
};

void
fill (int x, int y, struct node d, char arr[][d.m])
{
	int p = x + 1, q = x - 1, r = y + 1, s = y - 1;
	arr[x][y] = d.f;
	if (p < d.n) 
		if (arr[p][y] == d.t)
			fill (p, y, d, arr);
	if (q >= 0) 
		if (arr[q][y] == d.t)
			fill (q, y, d, arr);
	if (r < d.m) 
		if (arr[x][r] == d.t)
			fill (x, r, d, arr);
	if (s >= 0) 
		if (arr[x][s] == d.t)
			fill (x, s, d, arr);
}

int
main ()
{
	struct node d;
	int i, x, y;
	scanf ("%d %d", &d.m, &d.n); d.m++;
	char arr[d.n][d.m];
	
	for (i = 0; i < d.n; i++)
		scanf ("%s", arr[i]);
	scanf ("%d %d %c", &x, &y, &d.f);
	d.t = arr[x][y];
	
	fill (x, y, d, arr);
	
	for (i = 0; i < d.n; i++)
		printf ("%s\n", arr[i]);
	
	return 0;
}
