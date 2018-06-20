#include <stdio.h>

int
main ()
{
	char ch;
	char flag = 0;
	
	while (scanf ("%c", &ch) == 1) {
		if (!flag) {
			if (ch == '\"') {
				printf ("``");
				flag++;
			}
			else
				printf ("%c", ch);
		} else {
			if (ch == '\"') {
				printf ("''");
				flag--;
			}
			else
				printf ("%c", ch);
		}
	}
	
	return 0;
}
