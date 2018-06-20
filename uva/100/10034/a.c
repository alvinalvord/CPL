#include <stdio.h>
#include <math.h>
#include <string.h>

typedef struct {
	double x;
	double y;
} Point;

#define sq(x) (x * x)
#define dist(p1, p2) (sqrt(sq((p1.x - p2.x)) + sq((p1.y - p2.y))))

void
genAll (double *min, double total, double nextval, int dex, int size, double distanceMatrix[size][size], char *traceback)
{
	total += nextval;
	if (total > *min)
		return;
	traceback[dex] = 1;
	
	int i;
	for (i = 0; i < size; i++) {
		if (!traceback[i])
			genAll (min, total, distanceMatrix[dex][i], i, size, distanceMatrix, traceback);
	}
	
	char done = 1;
	for (i = 0; i < size; i++) {
		if (!traceback[i]) {
			done = 0;
			break;
		}
	}
	
	if (done) {
		if (*min > total)
			*min = total;
	}
	traceback[dex] = 0;
}

void
func ()
{
	int n, i, j;
	scanf ("%d", &n);
	
	Point points[n];
	double distanceMatrix[n][n];
	double minDistance = 0;
	for (i = 0; i < n; i++) {
		scanf ("%lf %lf", &(points[i].x), &(points[i].y));
	}
	
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			distanceMatrix[i][j] = dist(points[i], points[j]);
			minDistance += distanceMatrix[i][j];
		}
	}
	
	char traceback[n];
	memset (traceback, 0, n);
	
	for (i = 0; i < n; i++)
		genAll (&minDistance, 0.0, 0.0, i, n, distanceMatrix, traceback);
	
	printf ("%lf", minDistance);
}

int
main ()
{
	int t;
	scanf ("%d", &t);
	
	while (t--) {
		func ();
		if (t)
			printf ("\n");
	}
	
	return 0;
}
