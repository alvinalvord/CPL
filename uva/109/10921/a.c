#include <stdio.h>
#include <string.h>

typedef char string[31];

char
translate (char ch)
{
	switch (ch) {
		case 'A':
		case 'B':
		case 'C': return '2';
		case 'D':
		case 'E':
		case 'F': return '3';
		case 'G':
		case 'H':
		case 'I': return '4';
		case 'J':
		case 'K':
		case 'L': return '5';
		case 'M':
		case 'N':
		case 'O': return '6';
		case 'P':
		case 'Q':
		case 'R':
		case 'S': return '7';
		case 'T':
		case 'U':
		case 'V': return '8';
		case 'W':
		case 'X':
		case 'Y':
		case 'Z': return '9';
	}
	
	return ch;
}

void
convert (string s)
{
	int len = strlen (s), i;
	for (i = 0; i < len; i++) {
		s[i] = translate (s[i]);
	}
}

int
main ()
{
	string in;
	while (scanf ("%s", in) == 1) {
		convert (in);
		
		printf ("%s\n", in);
	}

	return 0;
}
