#include <stdio.h>

char
rev (char ch) 
{
	switch (ch) {
		case 'E': return '3';
		case '3': return 'E';
		case 'J': return 'L';
		case 'L': return 'J';
		case 'S': return'2';
		case '2': return 'S';
		case 'Z': return '5';
		case '5': return 'Z';
		case '1':
		case '8':
		case 'A':
		case 'H': 
		case 'I':
		case 'M':
		case 'O':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
			return ch;
	}
	return '-';
}

char
equal (char *a, char *b)
{
	while (*a && *b) {
		if (*a != *b)
			return 0;
		
		a++; b++;
	}
	return 1;
}

char
palindrome (char a[], int i, int j)
{
	if (i > j)
		return 1;
	
	if (a[i] != a[j])
		return 0;
	
	return palindrome (a, i + 1, j - 1);
}

char 
mirrored (char *a)
{
	while (*a) {
		if (*a == '-')
			return 0;
		a++;
	}
	return 1;
}

void
getRev (char *buff, char *reverse)
{
	while (*buff) {
		*reverse = rev (*buff);
		buff ++; reverse ++;
	}
}

int
main ()
{
	char buff[1024];
	char reverse[1024];
	int len;
	
	while (fgets (buff, sizeof (buff), stdin) != NULL) {
		for (len = 0; buff[len]; len++);
		len--;
		buff[len] = 0;
		reverse[len] = 0;
		getRev (buff, reverse);
		
		if (equal (buff, reverse)) {
			printf ("%s -- is a mirrored palindrome.\n\n", buff);
		} else if (palindrome (buff, 0, len - 1)) {
			printf ("%s -- is a regular palindrome.\n\n", buff);
		} else if (mirrored (reverse)) {
			printf ("%s -- is a mirrored string.\n\n", buff);
		} else {
			printf ("%s -- is not a palindrome.\n\n", buff);
		}
	}
	
	
	return 0;
}


