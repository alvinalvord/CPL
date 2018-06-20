#include <stdio.h>

void
ctoi (char *buff)
{
	char *origin = buff;
	while (*buff) buff++;
	buff --;
	buff --;
	char c;
	while (buff >= origin) {
		c = *buff;
		if (c >= 100)
			printf ("%d%d%d", c % 10, c / 10 % 10, c / 100 % 10);
		else
			printf ("%d%d", c % 10, c / 10 % 10);
		buff --;
	}
	
	printf ("\n");
}

void
itoc (char *buff)
{
	char *origin = buff;
	while (*buff) buff++;
	buff --;
	buff --;
	char c;
	while (buff >= origin) {
		c = 0;
		if (*buff == '1') {
			c = *buff - '0';
			c *= 10;
			buff --;
			
			c += *buff - '0';
			c *= 10;
			buff --;
			
			c += *buff - '0';
			buff --;
		} else {
			c = *buff -'0';
			c *= 10;
			buff --;
			
			c += *buff - '0';
			buff --;
		}
		
		printf ("%c", c);
	}
	
	printf ("\n");
}

int
main ()
{
	char buff[1024];
	
	while (fgets (buff, sizeof (buff), stdin) != NULL) {
		if (buff[0] >= '0' && buff[0] <= '9')
			itoc (buff);
		else
			ctoi (buff);
	}
	
	return 0;
}
