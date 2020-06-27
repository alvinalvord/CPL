#include <stdio.h>

int
main ()
{
	int s[2];
	int e[2];
	
	scanf ("%d:%d", s , s + 1);
	scanf ("%d:%d", e , e + 1);
	
	int start = s[0] * 60 + s[1];
	int end = e[0] * 60 + e[1];
	
	int mid = start + end;
	mid /= 2;
	
	printf ("%02d:%02d\n", mid / 60, mid % 60);
	
	return 0;
}