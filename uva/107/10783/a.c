#include <stdio.h>

int
os (int i, int j)
{
	if (i % 2 != 0)
		i --;
	
	if (j % 2 != 0)
		j ++;
	
	return (j * j / 4) - (i * i / 4);
}

int
main ()
{
	int n, i, a, b;
	
	scanf ("%d", &n);

	for (i = 0; i < n; i++) {
		scanf ("%d %d", &a, &b);
		printf ("Case %d: %d\n", i+1, os (a, b));
	}
	
	return 0;
}
