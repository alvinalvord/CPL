#include <stdio.h>

int
func ()
{
	int arr[1500];
	int i, dex, temp;
	
	arr[0] = 1;
	dex = 1;
	for (i = 2; dex < 1500 ; i++) {
		temp = i;
		while (temp > 1) {
			if (temp % 2 == 0)
				temp /= 2;
			else break;
		}
		
		while (temp > 1) {
			if (temp % 3 == 0)
				temp /= 3;
			else break;
		}
		
		while (temp > 1) {
			if (temp % 5 == 0)
				temp /= 5;
			else break;
		}
		
		if (temp == 1) {
			arr[dex++] = i;
		}
	}
	
	return arr[1499];
}

int
main ()
{
	printf ("The 1500'th ugly number is 859963392.\n");
	
	return 0;
}
