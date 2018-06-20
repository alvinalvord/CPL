#include <stdio.h>
/* 
void
count50 (int *c, int acc, int target)
{
	if (acc == target) {
		(*c)++;
	}
	else if (acc < target) {
		count50 (c, acc + 50, target);
	}
}


void
count25 (int *c, int acc, int target)
{
	if (acc == target) {
		(*c)++;
	}
	else if (acc < target) {
		count25 (c, acc + 25, target);
		count50 (c, acc + 50, target);
	}
}


void
count10 (int *c, int acc, int target)
{
	if (acc == target) {
		(*c)++;
	}
	else if (acc < target) {
		count10 (c, acc + 10, target);
		count25 (c, acc + 25, target);
		count50 (c, acc + 50, target);
	}
}


void
count5 (int *c, int acc, int target)
{
	if (acc == target) {
		(*c)++;
	}
	else if (acc < target) {
		count5 (c, acc + 5, target);
		count10 (c, acc + 10, target);
		count25 (c, acc + 25, target);
		count50 (c, acc + 50, target);
	}
}

void
count (int *c, int acc, int target)
{
	if (acc == target) {
		(*c)++;
	}
	else if (acc < target) {
		count (c, acc + 1, target);
		count5 (c, acc + 5, target);
		count10 (c, acc + 10, target);
		count25 (c, acc + 25, target);
		count50 (c, acc + 50, target);
	}
} 
*/

void
c1 (int *c, int n)
{
	if (n >= 0)
		(*c)++;
}

void
c5 (int *c, int n)
{
	if (n < 0)
		return;
	
	if (n == 0)
		c1 (c, n);
	
	c5 (c, n - 5);
	c1 (c, n);
}

void
c10 (int *c, int n)
{
	if (n < 0)
		return;
	
	if (n == 0)
		c1 (c, n);
	
	c10 (c, n - 10);
	c5 (c, n - 5);
	c1 (c, n);
}

void
c25 (int *c, int n)
{
	if (n < 0)
		return;
	
	if (n == 0)
		c1 (c, n);
	
	c25 (c, n - 25);
	c10 (c, n - 10);
	c5 (c, n - 5);
	c1 (c, n);
}

void
c50 (int *c, int n)
{
	if (n < 0)
		return;
	
	if (n == 0)
		c1 (c, n);
	
	c50 (c, n - 50);
	c25 (c, n - 25);
	c10 (c, n - 10);
	c5 (c, n - 5);
	c1 (c, n);
}

int 
count (int n)
{
	int c = 0;

	c50 (&c, n);

	return c;
}

int
main ()
{
	int n, c;
	
	while (scanf ("%d", &n) == 1) {
		c = count (n);
		
		if (c == 1) 
			printf ("There is only 1 way to produce %d cents change.\n", n);
		else 
			printf ("There are %d ways to produce %d cents change.\n", c, n);
	}
	
	return 0;
}
