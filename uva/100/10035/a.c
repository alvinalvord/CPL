#include <stdio.h>

char
end (char *a, char *b)
{
	return (*a == *b && *a == '0' && a[1] == b[1] && a[1] == 0);
}

int
getCount (char *a, char *b)
{
	char *oa = a, *ob = b;
	int count = 0;
	int carry = 0;
	int val;
	while (*a)
		a++;
	while (*b)
		b++;
	a--;
	b--;
	while (a >= oa  && b >= ob) {
		val = (*a + *b - 2 * '0' + carry);
		carry = val / 10;
		
		if (carry)
			count++;
		a--; b--;
	}
	
	while (a >= oa) {
		val = *a + carry - '0';
		carry = val / 10;
		if (carry)
			count++;
		a--;
	}
	
	while (b >= ob) {
		val = *b + carry - '0';
		carry = val / 10;
		if (carry)
			count ++;
		b--;
	}
	
	return count;
}

int
main ()
{
	int count;
	char a[11], b[11];

	while (1) {
		scanf ("%s %s", a, b);
		if (end (a,b))
			break;
		
		count = getCount (a, b);
		
		switch (count) {
			case 0: printf ("No carry operation.\n");
				break;
			case 1: printf ("1 carry operation.\n");
				break;
			default: printf ("%d carry operations.\n", count);
		}
	}
	
	return 0;
}
