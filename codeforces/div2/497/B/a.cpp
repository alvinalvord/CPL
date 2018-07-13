#include <cstdio>

typedef struct {
	int w, h;
} P;

int
main ()
{
	int n;
	scanf ("%d", &n);
	
	P arr[n];
	int w, h;
	for (int i = 0; i < n; i++) {
		scanf ("%d %d", &w, &h);
		
		if (h > w) {
			arr[i].h = h; arr[i].w = w;
		} else {
			arr[i].w = h; arr[i].h = w;
		}
	}
	
	int i;
	int j;
	int temp;
	bool flag = true;
	for (i = 0; i < n - 1; i++) {
		j = i + 1;
		
		if (arr[i].h < arr[j].h) {
			if (arr[i].h < arr[j].w) {
				flag = false;
				break;
			} else {
				temp = arr[j].h;
				arr[j].h = arr[j].w;
				arr[j].w = temp;
			}
		}
		
	}
	
	
	printf ("%s\n", (flag ? "YES": "NO"));
	
	
	
	
	return 0;
}
