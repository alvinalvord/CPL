#include <stdio.h>

typedef struct {
	unsigned char v : 1;
} bool;

int
main ()
{
	bool arr[100001];
	int i, temp;
	
	for (i = 0; i < 100001; i++)
		arr[i].v = 0;
	
	for (i = 0; (temp = i * i) < 100001; i++)
		arr[temp].v = 1;
	
	int n, m;
	while (1) {
		scanf ("%d %d", &n, &m);
		if (n == 0) break;
		
		temp = 0;
		for (i = n; i <= m; i++) {
			if (arr[i].v)
				temp++;
		}
		
		printf ("%d\n", temp);
	}
	
	return 0;
}
