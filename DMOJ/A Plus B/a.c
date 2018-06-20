#include <stdio.h>

int main () {
	int n, a, b, i;
	fscanf(stdin, "%d", &n);
	for(i=0;i<n;i++) {
		fscanf(stdin, "%d", &a);
		fscanf(stdin, "%d", &b);
		fprintf(stdout, "%d\n", (a + b));
	}
	return 0;
}