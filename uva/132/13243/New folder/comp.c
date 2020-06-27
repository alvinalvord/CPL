#include <stdio.h>
#include <sys/time.h>

#define N 20000

void
printInt (int n)
{
	if (n != 0) {
		printInt (n / 10);
		putchar ((n % 10 + '0'));
	}
}

int
itc (int n, char *a)
{
	if (n == 0)
		return 1;
	
	int i = itc (n/10, a);
	a[i] = n % 10 + '0';
	return i + 1;
}

void
doprint ()
{
	int i;
	for (i = 1; i < N; i++)
		printf ("%d ", i);
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

void
doput ()
{
	int i, n, index = 0;
	char arr[10];
	char buff[200000];
	arr[0] = ' ';
	for (i =1; i < N; i++)
	{
		n = itc (i, arr);
		arr[n] = 0;
		index = cat (buff, arr, index);
	}
	printf ("%s %d", buff, index);
}


int
main ()
{
	
struct timeval start, stop;
double secs = 0;


gettimeofday(&start, NULL);
doprint ();
gettimeofday(&stop, NULL);
secs = (double)(stop.tv_usec - start.tv_usec) / 1000000 + (double)(stop.tv_sec - start.tv_sec);

printf ("\n---------------------\n");

struct timeval start1, stop1;
double secs1 = 0;

gettimeofday(&start1, NULL);
doput ();
gettimeofday(&stop1, NULL);
secs1 = (double)(stop1.tv_usec - start1.tv_usec) / 1000000 + (double)(stop1.tv_sec - start1.tv_sec);

printf("\ntime taken %f\n",secs);
printf("time taken %f\n",secs1);

	return 0;
}