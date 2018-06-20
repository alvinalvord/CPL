#include <stdio.h>

typedef char string[128];

typedef struct {
	string str;
	int i;
} node ;

int
main ()
{
	int t, i, max, c;
	node n[10];
	
	scanf ("%d\n", &t);
	for (c = 1; t-- ; c++) {
		max = 0x80000000;
		for (i = 10; i-- ; ) {
			scanf ("%s %d", n[i].str, &(n[i].i));
			if (n[i].i > max)
				max = n[i].i;
		}
		printf ("Case #%d:\n", c);
		for (i = 10; i-- ; ) {
			if (n[i].i == max) {
				printf ("%s\n", n[i].str);
			}
		}
	}
	
	return 0;
}

