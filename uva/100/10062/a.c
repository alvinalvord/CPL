#include <stdio.h>
#include <stdlib.h>

typedef struct {
	char ch;
	int n;
} node;

int
comp (const void *a, const void *b)
{
	node *x = (node *) a;
	node *y = (node *) b;

	if (x->n == y->n) {
		return y->ch - x->ch;
	}
	return x->n - y->n;
}

int
main ()
{
	char string[1024];
	node arr[128];
	int i;
	fgets (string, sizeof(string), stdin);
	while (1) {
		for (i = 0; i < 128; i++) {
			arr[i].ch = i;
			arr[i].n = 0;
		}
		
		for (i = 0; string[i] && string[i] != '\n'; i++) {
			arr[(int)string[i]].n ++;
		}
		
		qsort (arr, 128, sizeof (node), comp);
		
		for (i = 127; arr[i].n; i--);
		
		for (i = i + 1; i < 128; i++) {
			printf ("%d %d\n", arr[i].ch, arr[i].n);
		}
		if (fgets (string, sizeof(string), stdin) != NULL)
			printf ("\n");
		else break;
	}
	
	
	return 0;
}
