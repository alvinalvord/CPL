#include <stdio.h>
#include <math.h>

void
func (unsigned int n)
{
	unsigned int root = sqrt (n);
	
	printf ("%s\n", root * root == n ? "yes" : "no");
}

int
main ()
{

	int n;
	
	while (1) {
		scanf ("%u", &n);
		if (!n) break;
		func (n);
	}

	return 0;
}
