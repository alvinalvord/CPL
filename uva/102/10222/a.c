#include <stdio.h>
#include <string.h>

typedef char string[128];

typedef struct {
	char o;
	char t;
} node;

void mergesort (node *arr, int n);

void 
merge (node *left, node *right, int n, int m)
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, dex = 0, len = n + m;
	node arr[len];
	
	while (i < n && j < m) {
		if (left[i].o < right[j].o) {
			arr[dex].o = left[i].o;
			arr[dex++].t = left[i++].t;
		} else {
			arr[dex].o = right[j].o;
			arr[dex++].t = right[j++].t;
		}
	}
	while (i < n) {
		arr[dex].o = left[i].o;
		arr[dex++].t = left[i++].t;
	}
	while (j < m) {
		arr[dex].o = right[j].o;
		arr[dex++].t = right[j++].t;
	}
	for (i = 0; i < len; i++) {
		left[i].o = arr[i].o;
		left[i].t = arr[i].t;
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
indexOf (node arr[], char key, int low, int high)
{
	int mid = (high + low) / 2;
	
	if (key < arr[mid].o)
		return indexOf (arr, key, low, mid - 1);
	
	if (key > arr[mid].o)
		return indexOf (arr, key, mid + 1, high);
	
	return mid;
}

int
main ()
{
	string og = "234567890-=ertyuiop[]\\dfghjkl;'cvbnm,./ ERTYUIOPDFGHJKLCVBNM";
	string tr = "`1234567890qwertyuiop[asdfghjklzxcvbnm, qwertyuisdfghjzxcvb";
	
	int len = strlen (og);
	node arr[len];
	
	int i;
	for (i = 0; i < len; i++) {
		arr[i].o = og[i];
		arr[i].t = tr[i];
	}
	mergesort (arr, len);
	
	string in;
	
	scanf ("%[^\n]*c", in);
	
	string out;
	
	int inlen = strlen (in);
	for (i = 0; i < inlen; i++) {
		out[i] = arr[indexOf (arr, in[i], 0, len - 1)].t;
	}
	out[i] = 0;
	
	printf ("%s\n", out);
	return 0;
}
