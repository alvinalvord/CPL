#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 262144

int
main ()
{
	char *in = malloc (sizeof (char) * SIZE);
	char *stack = malloc (sizeof (char) * SIZE);
	int i, dex, inlen;

	scanf ("%s", in);
	inlen = strlen (in);	
	dex = 0;
	
	for (i = 0; i < inlen; i++) {
		if (dex == 0) {
			stack[dex++] = in[i];
		}
		else if (dex > 0) {
			if (stack[dex - 1] == in[i]) {
				stack[dex--] = 0;
			}
			else {
				stack[dex++] = in[i];
			}
		}
	}

	stack[dex] = 0;
	printf ("%s\n", stack);

	free (in); free (stack);
	return 0;
}
