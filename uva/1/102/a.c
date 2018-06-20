#include <stdio.h>

int
main ()
{
	unsigned long arr[9];
	unsigned long states[6][3];
	char res[6][4] = {
		"BCG", "BGC",
		"CBG", "CGB",
		"GBC", "GCB"
	};
	int i;
	unsigned long min, mindex, sum;
	
	while (scanf (
		"%lu %lu %lu %lu %lu %lu %lu %lu %lu",
		&arr[0], &arr[1], &arr[2],		
		&arr[3], &arr[4], &arr[5],		
		&arr[6], &arr[7], &arr[8]		
	) == 9) {
		states[0][0] = arr[3] + arr[6];
		states[0][1] = arr[2] + arr[8];
		states[0][2] = arr[1] + arr[4];
		
		states[1][0] = arr[3] + arr[6];
		states[1][1] = arr[1] + arr[7];
		states[1][2] = arr[2] + arr[5];
		
		states[2][0] = arr[5] + arr[8];
		states[2][1] = arr[0] + arr[6];
		states[2][2] = arr[1] + arr[4];
		
		states[3][0] = arr[5] + arr[8];
		states[3][1] = arr[1] + arr[7];
		states[3][2] = arr[0] + arr[3];
		
		states[4][0] = arr[4] + arr[7];
		states[4][1] = arr[0] + arr[6];
		states[4][2] = arr[2] + arr[5];
		
		states[5][0] = arr[4] + arr[7];
		states[5][1] = arr[2] + arr[8];
		states[5][2] = arr[0] + arr[3];
		
		min = 0xffffffff;
		
		for (i = 0; i < 6; i++) {
			sum = 
				states[i][0] + 
				states[i][1] + 
				states[i][2];
			if (sum < min) {
				min = sum;
				mindex = i;
			}
		}
		
		printf ("%s %lu\n", res[mindex], min);
		
	}
	
	return 0;
}
