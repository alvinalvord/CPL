#include <stdio.h>

char
isAlpha (char ch)
{
	return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
}

int
count (char *a)
{
	char flag = 0;
	int ctr = 0;
	
	while (*a) {
		if (isAlpha (*a) && !flag) {
			flag = 1;
			ctr ++;
		}
		else if (flag && !isAlpha (*a)) {
			flag = 0;
		}
		
		a++;
	}
	
	return ctr;
}

int
main ()
{
	char buff[1024];
	
	while (scanf ("%[^\n]%*c", buff) == 1) {
		printf ("%d\n", count (buff));
	}
	
	return 0;
}
