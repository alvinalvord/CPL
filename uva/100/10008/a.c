#include <stdio.h>
#include <string.h>

typedef char string[2048];
typedef struct {
	char ch;
	int c;
} alpha;

void merge (alpha *left, alpha *right, int n, int m);
void mergesort (alpha *arr, int n);

void 
merge (alpha *left, alpha *right, int n, int m) 
{
	if (n > 1) mergesort (left, n);
	if (m > 1) mergesort (right, m);
	
	int i = 0, j = 0, len = n + m, dex = 0;
	alpha arr[len];
	
	while (i < n && j < m) {
		if (left[i].c < right[j].c)
			arr[dex++] = left[i++];
		else
			arr[dex++] = right[j++];
	}
	while (i < n) arr[dex++] = left[i++];
	while (j < m) arr[dex++] = right[j++];
	for (i = 0; i < len; i++) left[i] = arr[i];
}

void 
mergesort (alpha *arr, int n)
{
	int x = n / 2;
	int y = n - x;
	merge (arr, arr + x, x, y);
}

void
count (char *in, alpha arr[26])
{
	while (*in) {
		if (*in >= 'A' && *in <= 'Z')
			arr[*in - 'A'].c++;
		else if (*in >= 'a' && *in <= 'z')
			arr[*in - 'a'].c++;
		in ++;
	}
}

int
main ()
{
	alpha arr[26];
	string in;
	int i, n;
	
	for (i = 0; i < 26; i++) {
		arr[i].ch = 65 + i;
		arr[i].c ^= arr[i].c;
	}
		
	scanf ("%d\n", &n);
	
	for (i = 0; i < n; i++) {
		fgets (in, sizeof (in), stdin);
		count (in, arr);
	}
	
	mergesort (arr, 26);
	
	i = 25;
	while (arr[i].c) {
		printf ("%c %d\n", arr[i].ch, arr[i].c);
		i--;
	}
	
	return 0;
}
