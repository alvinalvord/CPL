#include <stdio.h>

typedef struct {
	int n; int rank;
} node;

void mergesort (node *arr, int n);

void
merge (node *left, node *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, len = n + m, dex = 0;
	node arr[len];
	
	while (i < n && j < m) {
		if (left[i].rank <= right[j].rank) {
			arr[dex].n = left[i].n;
			arr[dex].rank = left[i].rank;
			dex++; i++;
		} else {
			arr[dex].n = right[j].n;
			arr[dex].rank = right[j].rank;
			dex++; j++;
		}
	}
	while (i < n) {
		arr[dex].n = left[i].n;
		arr[dex].rank = left[i].rank;
		dex++; i++;
	}
	while (j < m) {
		arr[dex].n = right[j].n;
		arr[dex].rank = right[j].rank;
		dex++; j++;
	}
	for (i = 0; i < len; i++) {
		left[i].n = arr[i].n;
		left[i].rank = arr[i].rank;
	}
}

void
mergesort (node *arr, int n)
{
	int x = n / 2;
	int y = n - x;
	merge (arr, arr + x, x, y);
}

int
main ()
{
	int n, m, a, b, i;
	
	while (1) {
		scanf ("%d %d", &n, &m);
		
		if (n == m && m == 0) break;
		
		node arr[n + 1];
	
		for (i = 0; i <= n; i++) {
			arr[i].n = i;
			arr[i].rank = 0;
		}
		arr[0].rank = 0x80000000;
		
		for (i = 0; i < m; i++) {
			scanf ("%d %d", &a, &b);
			arr[a].rank --;
			arr[b].rank ++;
		}
		
		mergesort (arr, n+1);
		
		for (i = 1; i < n; i++) {
			printf ("%d ", arr[i].n);
		}
		printf ("%d\n", arr[n].n);
	}
	
	return 0;
}
