#include <stdio.h>
#include <stdlib.h>

void
init (int arr[26])
{
	arr[0] = 1;
	arr[1] = 2;
	arr[2] = 3;
	arr[3] = 1;
	arr[4] = 2;
	arr[5] = 3;
	arr[6] = 1;
	arr[7] = 2;
	arr[8] = 3;
	arr[9] = 1;
	arr[10] = 2;
	arr[11] = 3;
	arr[12] = 1;
	arr[13] = 2;
	arr[14] = 3;
	arr[15] = 1;
	arr[16] = 2;
	arr[17] = 3;
	arr[18] = 4;
	arr[19] = 1;
	arr[20] = 2;
	arr[21] = 3;
	arr[22] = 1;
	arr[23] = 2;
	arr[24] = 3;
	arr[25] = 4;
}

int
main ()
{
	int arr[26];
	char str[200];
	int i, t, acc, j;
	char s1[10];
	init (arr);
	scanf ("%[^\n]%*c", s1);
	
	t = atoi (s1);
	for (i = 0; i < t; i++) {
		acc = 0;
		fgets (str, sizeof(str), stdin);
		
		for (j = 0; str[j]; j++) {
			if (str[j] == ' ')
				acc++;
			else if (str[j] >= 'a' && str[j] <= 'z') 
				acc += arr[str[j] - 'a'];
		}
		
		printf ("Case #%d: %d\n", i + 1, acc);
	}
	
	
	return 0;
}
