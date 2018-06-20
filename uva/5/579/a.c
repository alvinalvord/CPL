#include <stdio.h>
#include <math.h>

double
func (int h, int m)
{
	double hdeg, mdeg;
	
	hdeg = h * 30 + m / 60.0 * 30;
	mdeg = m * 6;
	
	double ret = fmod (fabs (hdeg - mdeg), 360);
	
	if (ret >= 180)
		ret = 360 - ret;
	
	return ret;
}


int
main () 
{
	int h, m;
	
	while (1)
	{
		scanf ("%d:%d", &h, &m);
		if (h == 0) break;
		printf ("%.3lf\n", func (h, m));
	}
	
	return 0;
}
