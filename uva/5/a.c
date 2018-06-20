#include <stdio.h>
#include <string.h>

typedef char string[256];

int
main ()
{
	string in;
	int i, j, acc;
	int arr[32];
	arr [0] = 2;
	for (i = 1; i < 32; i++) {
		arr[i] = arr[i-1] * 2;
	}
	for (i = 0; i < 32; i++) {
		arr[i] --;
	}
	while (1) {
		scanf ("%s", in);
		
		if (in[0] == '0' && in[1] == 0) break;
		i = strlen (in) - 1;
		j = 0;
		acc = 0;
		while (i >= 0) {
			acc += ((in[i] - '0') * arr[j]);
			j++; i--;
		}
		printf ("%d\n", acc);
	}
	
	return 0;
}
