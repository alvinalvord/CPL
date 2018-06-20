#include <stdio.h>

typedef char string[101];

int
main ()
{
	int n, i;
	
	scanf ("%d", &n);
	
	string names[n];
	string song[16] = 
		{"Happy", "birthday", "to", "you",
		 "Happy", "birthday", "to", "you",
		 "Happy", "birthday", "to", "Rujia",
		 "Happy", "birthday", "to", "you"
		};
	for (i = 0; i < n; i++)
		scanf ("%s", names[i]);
	
	int lim = n / 16 + ((n % 16 != 0) ? 1:0);
	int j = 0, k;
	for (i = 0; i < lim; i++) {
		for (k = 0; k < 16; k++) {
			printf ("%s: %s\n", names[j % n], song[k]);
			j++;
		}
	}
	
	return 0;
}
