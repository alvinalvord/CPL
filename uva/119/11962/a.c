#include <stdio.h>
#include <string.h>

typedef char String[31];
typedef unsigned long long int ull;

int
main ()
{
	int n, a, i, j;
	String buffer;
	ull b;
	
	scanf ("%d", &n);
	
	for (i = 1; i <= n; i++)  {
		scanf ("%s", buffer);
		a = strlen (buffer);
		b = 0;
		for (j = 0; j < a - 1; j++) {
			switch (buffer[j]) {
				case 'T': b ^= 0x3; break;
				case 'G': b ^= 0x2; break;
				case 'C': b ^= 0x1; break;
				case 'A': b ^= 0x0; break;
			}
			b <<= 2;
		}
		switch (buffer[j]) {
			case 'T': b ^= 0x3; break;
			case 'G': b ^= 0x2; break;
			case 'C': b ^= 0x1; break;
			case 'A': b ^= 0x0; break;
		}
		
		printf ("Case %d: (%d:%llu)\n", i, a, b);
	}
	
	return 0;
}