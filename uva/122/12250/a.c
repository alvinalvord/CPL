#include <stdio.h>

char
equal (char *a, const char *b)
{
	int i = 0;
	while (b[i]) {
		if (a[i] != b[i]) 
			return 0;
		i++;
	}
	return 1;
}

int
main ()
{
	char buff [20];
	int c = 0;
	while (1) {
		c++;
		scanf ("%s", buff);
		if (buff[0] == '#' && buff[1] == 0)
			break;
		
		if (equal (buff, "HELLO")) {
			printf ("Case %d: ENGLISH\n", c);
		} else if (equal (buff, "HOLA")) {
			printf ("Case %d: SPANISH\n", c);
		} else if (equal (buff, "HALLO")) {
			printf ("Case %d: GERMAN\n", c);
		} else if (equal (buff, "BONJOUR")) {
			printf ("Case %d: FRENCH\n", c);
		} else if (equal (buff, "CIAO")) {
			printf ("Case %d: ITALIAN\n", c);
		} else if (equal (buff, "ZDRAVSTVUJTE")) {
			printf ("Case %d: RUSSIAN\n", c);
		} else printf ("Case %d: UNKNOWN\n", c);
		
	}
	
	return 0;
}

