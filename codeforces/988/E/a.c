#include <stdio.h>
#include <string.h>

typedef char string[32];

int
main ()
{
	string in;
	scanf ("%s", in);
	int len = strlen (in);
	int i, d1, d2, min, temp;
	
	// 00
	min = -1;
	d1 = -1; d2 = -1;
	for (i = len - 1; i >= 0; i--) {
		if (in[i] == '0') {
			if (d1 == -1) d1 = i;
			else if (d2 == -1) {
				d2 = i; break;
			}
		}
	}
	
	if (d1 != -1 && d2 != -1) {
		temp = len + len - 2 - d1 - d2;
		if (min == -1 || (min != -1 && min > temp))
			min = temp;
	}
	
	//25
	d1 = -1; d2 = -1;
	for (i = len - 1; i >= 0; i--) {
		if (in[i] == '2') {
			if (d1 == -1) d1 = i;
		}
		else if (in[i] == '5') {
			if (d2 == -1) d2 = i;
		}
		if (d1 != -1 && d2 != -1) break;
	}
	
	if (d1 != -1 && d2 != -1) {
		temp = len + len - 2 - d1 - d2;
		if (min == -1 || (min != -1 && min > temp))
			min = temp;
	}
	
	//50
	d1 = -1; d2 = -1;
	for (i = len - 1; i >= 0; i--) {
		if (in[i] == '5') {
			if (d1 == -1) d1 = i;
		}
		else if (in[i] == '0') {
			if (d2 == -1) d2 = i;
		}
		if (d1 != -1 && d2 != -1) break;
	}
	
	if (d1 != -1 && d2 != -1) {
		temp = len + len - 2 - d1 - d2;
		if (min == -1 || (min != -1 && min > temp))
			min = temp;
	}
	
	//75
	d1 = -1; d2 = -1;
	for (i = len - 1; i >= 0; i--) {
		if (in[i] == '7') {
			if (d1 == -1) d1 = i;
		}
		else if (in[i] == '5') {
			if (d2 == -1) d2 = i;
		}
		if (d1 != -1 && d2 != -1) break;
	}
	
	if (d1 != -1 && d2 != -1) {
		temp = len + len - 2 - d1 - d2;
		if (min == -1 || (min != -1 && min > temp))
			min = temp;
	}
	
	printf ("%d\n", min);
	
	return 0;
}
