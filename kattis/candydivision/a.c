#include <stdio.h>
#include <math.h>

int
main ()
{
	int size1 = 0, size2 = 0, j;
	unsigned long long int list1[10000];
	unsigned long long int list2[10000];
	unsigned long long int n;
	
	scanf ("%llu", &n);
	
	unsigned long long int i = 1;
	unsigned long long int lim = (unsigned long long int) ceil (sqrt(n));
	
	while (i < lim) {
		if (n % i == 0) {
			if (n / i == i) {
				list1[size1++] = i - 1;
			} else {
				list1[size1++] = i - 1;
				list2[size2++] = n / i - 1;
			}
		}
		i++;
	}
	
	for (j = 0; j < size1; j++) {
		printf ("%llu ", list1[j]);
	}
	for (j = size2 - 1; j >= 0; j--) {
		printf ("%llu ", list2[j]);
	}
	
	return 0;
}