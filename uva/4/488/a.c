#include <stdio.h>

void
print (int amp, int freq)
{
	int i, j, k;
	
	for (i = 0; i < freq; i++) {
		for (j = 1; j <= amp; j++) {
			for (k = 0; k < j; k++) {
				printf ("%d", j);
			}
			printf ("\n");
		}
		for (j = amp - 1; j >= 1; j--) {
			for (k = 0; k < j; k++) {
				printf ("%d", j);
			}
			printf ("\n");
		}
		if (i < freq - 1)
			printf ("\n");
	}
	
}

int
main ()
{
	int t, amp, freq;
	
	scanf ("%d", &t);
	
	while (t--) {
		scanf ("%d\n%d", &amp, &freq);
		print (amp, freq);
		if (t >= 1)
			printf ("\n");
	}
	return 0;
}
