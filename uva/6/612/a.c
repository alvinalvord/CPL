#include <stdio.h>
#include <string.h>

typedef char string[64];

typedef struct {
	string s;
	int v;
	int dex;
} node;

int getInversions (char *arr, int n);
void mergesort (node *arr, int n);

int
mergeInv (char *left, char *right, int n, int m)
{
	int cleft = 0, cright = 0;
	if (n > 1) cleft = getInversions (left, n);
	if (m > 1) cright = getInversions (right, m);
	
	int i = 0, j = 0, dex = 0, len = n + m, count = 0;
	char arr[len];
	
	while (i < n && j < m) {
		if (left[i] <= right[j]) {
			arr[dex++] = left[i++];
		} else {
			arr[dex++] = right[j++];
			count += (n - i);
		}
	}
	
	while (i < n) arr[dex++] = left[i++];
	while (j < m) arr[dex++] = right[j++];
	for (i = 0; i < len; i++) left[i] = arr[i];
	return count + cleft + cright;
}

int
getInversions (char *arr, int n)
{
	int x = n / 2;
	int y = n - x;
	return mergeInv (arr, arr + x, x, y);
}

void
merge (node *left, node *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, dex = 0, len = n + m;
	node arr[len];
	
	while (i < n && j < m) {
		if (left[i].v == right[j].v) {
			if (left[i].dex < right[j].dex)
				arr[dex++] = left[i++];
			else
				arr[dex++] = right[j++];
		}
		else if (left[i].v < right[j].v) {
			arr[dex++] = left[i++];
		} else {
			arr[dex++] = right[j++];
		}
	}
	while (i < n) arr[dex++] = left[i++];
	while (j < m) arr[dex++] = right[j++];
	for (i = 0; i < len; i++) left[i] = arr[i];
}

void
mergesort (node *arr, int n)
{
	int x = n / 2;
	int y = n - x;
	merge (arr, arr + x, x, y);
}

void
solve ()
{
	int n, m, i;
	scanf ("%d %d", &n, &m);
	node arr[m];
	string in;
	
	for (i = 0; i < m; i++) {
		scanf ("%s", in);
		strcpy (arr[i].s, in);
		arr[i].v = getInversions (in, n);
		arr[i].dex = i;
	}
	
	mergesort (arr, m);
	for (i = 0; i < m; i++) {
		printf ("%s\n", arr[i].s);
	}
}

int
main ()
{
	int n, i;
	scanf ("%d", &n);
	for (i = 0; i < n; i++) {
		solve ();
		if (i != n - 1) printf ("\n");
	}
	
	return 0;
}
