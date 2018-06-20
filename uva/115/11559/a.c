#include <stdio.h>

int
main ()
{
	int n, b, h, w, i, j, temp;
	char flag;
	
	while (scanf ("%d %d %d %d", &n, &b, &h, &w) == 4) {
		int hots[h];
		for (i = 0; i < h; i++) {
			scanf ("%d", hots + i);
			hots[i] *= n;
			
			flag = 0;
			
			for (j = 0; j < w; j++) {
				scanf ("%d", &temp);
				if (temp >= n)
					flag = 1;
			}
			
			if (flag && hots[i] > b)
				flag = 0;
			
			if (!flag)
				hots[i] = b + 1;
		}
		
		int min = b + 1;
		for (i = 0; i < h; i++) {
			if (hots[i] < min) {
				min = hots[i];
			}
		}
			
		if (min < b) {
			printf ("%d\n", min);
		} else {
			printf ("stay home\n");
		}
	}
	
	return 0;
}
