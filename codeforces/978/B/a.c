#include <stdio.h>

typedef char string[128];

int
main ()
{
	int n;
	string str;
	scanf ("%d", &n);
	scanf ("%s", str);
	int i, ctr = 0;
	
	for (i = 2; i < n; i++) {
		if (str[i] == str[i - 1] && str[i] == str[i - 2]
			&& str[i] == 'x')
			ctr++;
	}
	
	printf ("%d\n", ctr);
	
	return 0;
}
