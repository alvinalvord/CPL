#include <iostream>
#include <cstdio>

int 
main ()
{
	int a, b, x;
	
	scanf ("%d %d %d", &a, &b, &x);
	int n = a + b;
	
	char arr[n + 1];
	arr[n] = 0;
	int i = 0;
	
	for ( ; i < a; i++)
		arr[i] = '0';
	for (; i < n; i++)
		arr[i] = '1';
	
	x--;
	int j;
	if (a < b) {
		i = a - 1;
		j = n - 2;
		while (x > 1) {
			arr[i]++;
			arr[j]--;
			i--;
			j -= 2;
			x-=2;
		}
		if (x == 1) {
			arr[0]++;
			arr[1]--;
		}
	}else {
		i = 1;
		j = a;
		
		while (x > 1) {
			arr[i]++;
			arr[j]--;
			i += 2;
			j++;
			x-=2;
		}
		
		if (x == 1) {
			arr[j - 1]++;
			arr[n - 1]--;
		}
	}
	
	printf ("%s\n", arr);
	
	return 0;
}
