#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

typedef char string[101];

int
slen (char *str)
{
	int i = 0;
	while (str[i]) i++;
	return i;
}

char
check (char *a, char *b)
{
	if (!(*a) && !(*b)) return 1;
	
	if (*a != '-' && *b != '-' && *a != *b) return 0;
	
	return check (a + 1, b + 1);
}

char
allwild (char *a)
{
	while (*a) {
		if (*a == '-') a++;
		else return 0;
	}
	
	return 1;
}

int 
cat (char *s, char *in, int dex)
{
	s += dex;
	
	while (*in) {
		*s = *in;
		s++; in++; dex++;
	}
	*s = 0;
	return dex;
}

int
itc (int n, char *a)
{
	if (n == 0)
		return 0;
	
	int i = itc (n/10, a);
	a[i] = n % 10 + '0';
	return i + 1;
}

int
apc (char ch, char *a, int index)
{
	a[index] = ch;
	a[index + 1] = 0;
	return index + 1;
}

void
func () 
{
	int n, i, j, buffdex, m;
	char hasMatch, isMatch;
	char *buff = malloc (sizeof (char) * 200000);
	char tbuff[10];
	
	scanf ("%d", &n);
	
	string *in = malloc (sizeof (string) * n);
	char b[n];
	
	for (i = 0; i < n; i++) {
		scanf ("%s", in[i]);
		b[i] = 0;
	}
	
	for (i = 0; i < n; i++) {
		if (allwild (in[i]))
			b[i] ++;
	}
	
	for (i = 1; i < n; i++) {
		hasMatch = 0;
		buffdex = 0;
		buff[buffdex] = 0;
		
		if (b[i]) {
			m = itc (i + 1, tbuff);
			tbuff[m] = 0;
			buffdex = cat (buff, tbuff, buffdex);
			buffdex = apc (':', buff, buffdex);
			for (j = 0; j < i; j++) {
				buffdex = apc (' ', buff, buffdex);
				m = itc (j + 1, tbuff);
				tbuff[m] = 0;
				buffdex = cat (buff, tbuff, buffdex);
			}
			buffdex = apc ('\n', buff, buffdex);
		}
		else {
			for (j = 0; j < i; j++) {
				isMatch = b[j];
				
				if (!isMatch)
					isMatch = check (in[i], in[j]);
				
				if (isMatch) {
					if (!hasMatch) {
						hasMatch = 1;
						m = itc (i + 1, tbuff);
						tbuff[m] = 0;
						buffdex = cat (buff, tbuff, buffdex);
						buffdex = apc (':', buff, buffdex);
					}
					
					buffdex = apc (' ', buff, buffdex);
					m = itc (j + 1, tbuff);
					tbuff[m] = 0;
					buffdex = cat (buff, tbuff, buffdex);
				}
			}
		
			if (hasMatch)
				buffdex = apc ('\n', buff, buffdex);
		}
	
		if (hasMatch)
			printf ("%s", buff);
	}
	
	free (buff);
	free (in);
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
