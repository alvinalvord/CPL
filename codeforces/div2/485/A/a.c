#include <stdio.h>

typedef char string[16];

int
main ()
{
	int n, i;
	scanf ("%d", &n);
	char f[6];
	
	for (i = 0; i < 6; i++)
		f[i] = 0;
	
	string in;
	for (i = 0; i < n; i++) {
		scanf ("%s", in);
		if (in[0] == 'p')
			f[0] = 1;
		else if (in[0] == 'g')
			f[1] = 1;
		else if (in[0] == 'b')
			f[2] = 1;
		else if (in[0] == 'o')
			f[3] = 1;
		else if (in[0] == 'r')
			f[4] = 1;
		else if (in[0] == 'y')
			f[5] = 1;
	}
	
	int ctr = 0;
	for (i = 0; i < 6; i++)
		ctr += f[i];
	
	ctr = 6 - ctr;
	
	printf ("%d\n", ctr);
	if (!f[0])
		printf ("Power\n");
	if (!f[1])
		printf ("Time\n");
	if (!f[2])
		printf ("Space\n");
	if (!f[3])
		printf ("Soul\n");
	if (!f[4])
		printf ("Reality\n");
	if (!f[5])
		printf ("Mind\n");
	
	
	return 0;
}
