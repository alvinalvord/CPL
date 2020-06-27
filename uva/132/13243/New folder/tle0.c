#include <stdio.h>
#include <sys/time.h>

int
slen (char *str)
{
	int i = 0;
	while (str[i]) i++;
	return i;
}

int
main ()
{
	
struct timeval start, stop;
double secs = 0;

gettimeofday(&start, NULL);

	int n, m, i, j, k;
	char buff[101];
	char hasMatch, isMatch;
	
	scanf ("%d", &n);
	scanf ("%s", buff);
	
	m = slen (buff);
	
	char in[n][m + 1];
	
	for (i = 0; i < m + 1; i++)
		in[0][i] = buff[i];
	
	for (i = 1; i < n; i++)
		scanf ("%s", in[i]);
	
	for (i = 1; i < n; i++) {
		hasMatch = 0;
		for (j = 0; j < i; j++) {
			isMatch = 1;
			for (k = 0; k < m + 1; k++) {
				if (in[i][k] != '-' && in[j][k] != '-' && in[i][k] != in[j][k]) {
					isMatch = 0;
					break;
				}
			}
			if (!hasMatch && isMatch) {
				hasMatch = 1;
				printf ("%d:", i + 1);
			}
			
			if (isMatch)
				printf (" %d", j + 1);
		}
		if (hasMatch)
			printf ("\n");
	}
	
	
gettimeofday(&stop, NULL);
secs = (double)(stop.tv_usec - start.tv_usec) / 1000000 + (double)(stop.tv_sec - start.tv_sec);
printf("time taken %f\n",secs);

	return 0;
}
