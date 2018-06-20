#include <stdio.h>

typedef char string[1024];

int
main () 
{
	string in;
	int n, m, i;
	
	while (1) {
		scanf ("%s", in);
		n = 0; m = 0;
		
		if (in[0] == '0' && in[1] == 0) break;
		
		for (i = 0; in[i]; i++) {
			if (i & 1)
				n += (in[i] - '0');
			else
				m += (in[i] - '0');
		}
		
		printf ("%s is %sa multiple of 11.\n", in,
			((n - m) % 11 == 0) ? "" : "not "
		);
	}
	
	
	return 0;
}
