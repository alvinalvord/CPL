#include <stdio.h>
#include <string.h>

int
isNum (char ch)
{
	return ch >= '0' && ch <= '9';
}

int
main ()
{
	char buff[128];
	
	int n, a, b, ad, len, i, j;
	scanf ("%d\n", &n);
	
	for (i = 1; i <= n; i++) {
		fgets (buff, sizeof (buff), stdin);
		len = strlen (buff);
		b = -1;
		for (j = 0; j < len; j++) {
			if (isNum (buff[j])) {
				a = buff[j] - '0'; ad = j; break;
			}
		}
		for (j = len - 1; j > ad; j--) {
			if (isNum (buff[j])) {
				b = buff[j] - '0'; break;
			}
		}
		double out = a * 0.5 + (b > 0 ? b * 0.05: 0);
		
		printf ("Case %d: %g\n", i, out);
	}
	
	return 0;
}
