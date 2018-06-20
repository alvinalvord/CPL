#include <stdio.h>

int
main ()
{
	char buff[10];
	int i = 0;
	while (fgets (buff, sizeof (buff), stdin) != NULL) {
		i++;
		if (buff[0] == '*')
			break;
		else if (buff[0] == 'H')
			printf ("Case %d: Hajj-e-Akbar\n", i);
		else 
			printf ("Case %d: Hajj-e-Asghar\n", i);
	}
	
	return 0;
}
