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
	int hasMatch[n];
	int *match = malloc (sizeof (int) * n * n);
	
	for (i = 0; i < n; i++) {
		scanf ("%s", in[i]);
		wild[i].v = 0;
	}
	
	for (i = 0; i < n; i++) {
		if (allwild (in[i]))
			wild[i].v = 1;
	}
	
	int lim;
	for (i = 1; i < n; i++) {
		lim = 0;
		for (j = 0; j < i; j++) {
			if (wild[i].v || wild[j].v) {
				match[i * n + lim] = j;
				lim++;
			}
			else if (check (in[i], in[j])) {
				match[i * n + lim] = j;
				lim++;
			}
		}
		match [i * n + lim] = -1;
	}
	
	lim = 0;
	for (i = 1; i < n; i++) {
		if (match[i * n] != -1) {
			hasMatch[lim++] = i;
		}
		hasMatch[lim] = -1;
	}
	
	int dex;
	char *buff = malloc (sizeof (char) * 150000);
	
	for (i = 0; hasMatch[i] != -1; i++) {
		dex = 0;
		dex = cat(buff, numstring[hasMatch[i]], dex);
		buff[dex++] = ':';
		for (j = 0; match[hasMatch[i] * n + j] != -1; j++) {
			buff[dex ++] = ' ';
			dex = cat (buff, numstring[match[hasMatch[i] * n + j]], dex);
		}
		buff[dex] = 0;
		puts (buff);
	}
	
	free (buff);
	free (in);
	free (match);
}

void
t ()
{
	struct timeval start, stop;
	double secs = 0;

	gettimeofday(&start, NULL);
	
	func ();
	
	gettimeofday(&stop, NULL);
	secs = (double)(stop.tv_usec - start.tv_usec) / 1000000 + (double)(stop.tv_sec - start.tv_sec);
	
	FILE *fp = fopen ("time.txt", "w");
	fprintf(fp,"\ntime taken %f\n",secs);
	fclose (fp);
}

int
main ()
{
	t ();
	return 0;
}
