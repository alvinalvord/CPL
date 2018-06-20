#include <stdio.h>

typedef char string[256];

char
isnum (char ch)
{
	return ch >= '0' && ch <= '9';
}

int
main ()
{
	int i, dex, count;
	char ch;
	string in;
	string out;
	
	while (fgets (in, sizeof(in), stdin) != NULL) {
		dex = 0; count = 0; out[dex] = 0;
		for (i = 0; in[i]; i++) {
			if (in[i] == '!' || in[i] == '\n') {
				printf ("%s\n", out);
				dex = 0;
			}
			else if (isnum(in[i])) count += (in[i] - '0');
			else {
				ch = in[i];
				if (ch == 'b')
					ch = ' ';
				while (count--) {
					out[dex++] = ch;
				}
				count = 0;
				out[dex] = 0;
			}
			
		}
		if (dex > 0)
			printf ("%s\n", out);
	} 
	
	
	return 0;
}
