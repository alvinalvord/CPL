#include <stdio.h>
#include <stdlib.h>

char
subseq (char *a, char *b)
{
	while (*b) {
		if (*a == *b) a++;
		b++;
	}
	
	if (*a == *b && *a == 0)
		return 1;
	
	return 0;
}

int
main ()
{
	char *a = malloc (sizeof (char) * 100000);
	char *b = malloc (sizeof (char) * 100000);
	
	while (scanf ("%s %s\n", a, b) == 2) {
		printf ("%s\n", ((subseq (a, b)) ? "Yes": "No"));
	}
	
	free (a);
	free (b);
	return 0;
}
