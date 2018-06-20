#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

typedef char string6[6];
typedef char string[101];

typedef struct {
	unsigned char v: 1;
} bool;

char
allwild (char *s)
{
	while (*s) {
		if (*s != '-')
			return 0;
		else s++;
	}
		
	return 1;
}

int
cat (char *a, char *b, int dex)
{
	a += dex;
	
	while (*b) {
		*a = *b;
		a++; b++; dex++;
	}
	
	return dex;
}

char
check (char *a, char *b)
{
	if (!(*a) && !(*b)) return 1;
	
	if (*a != '-' && *b != '-' && *a != *b) return 0;
	
	return check (a + 1, b + 1);
}

int
itc (int n, char *a)
{
	if (n == 0)
		return 0;
	
	int i = itc (n / 10, a);
	a[i] = n % 10 + '0';
	return i + 1;
}

void
func ()
{
	int n, i, j;
	
	string6 numstring[20000];
	
	for (i = 0; i < 20000; i++) {
		numstring[i][itc(i + 1, numstring[i])] = 0;
	}
	
	scanf ("%d", &n);
	
	string *in = malloc (sizeof (string) *n);
	bool wild[n];
	bool hasMatch[n];
	bool *match = malloc (sizeof (bool) * n * n);
	
	for (i = 0; i < n; i++) {
		scanf ("%s", in[i]);
		wild[i].v = 0;
	}
	
	for (i = 0; i < n; i++) {
		if (allwild (in[i]))
			wild[i].v = 1;
	}
	
	for (i = 1; i < n; i++) {
		for (j = 0; j < i; j++) {
			if (wild[i].v || wild[j].v)
				match[i * n + j].v = 1;
			else
				match[i * n + j].v = check (in[i], in[j]);
		}
	}
	
	for (i = 1; i < n; i++) {
		hasMatch[i].v = 0;
		for (j = 0; j < i && !hasMatch[i].v; j++)
			hasMatch[i].v = match[i * n + j].v;
	}
	
	int dex;
	char *buff = malloc (sizeof (char) * 150000);
	for (i = 1; i < n; i++) {
		if (hasMatch[i].v) {
			dex = 0;
			dex = cat (buff, numstring[i], dex);
			buff[dex++] = ':';
			for (j = 0; j < i; j++) {
				if (match[i * n + j].v) {
					buff[dex++] = ' ';
					dex = cat (buff, numstring[j], dex);
				}
			}
			buff[dex] = 0;
			printf ("%s\n", buff);
		}
	}
	
	free (buff);
	free (in);
	free (match);
}

int
main ()
{
	func ();
	return 0;
}
