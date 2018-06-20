#include <stdio.h>
#include <math.h>
#include <string.h>

typedef char string[8];

typedef struct {
	string left, right, bal;
} node;

int
main ()
{
	int t, temp, max, maxdex, i;
	int arr[12];
	node nodes[3];
	scanf ("%d", &t);

	while (t) {
		t--;
		maxdex = 0;
		max = 0;
		
		scanf ("%s %s %s", nodes[0].left, nodes[0].right, nodes[0].bal);
		scanf ("%s %s %s", nodes[1].left, nodes[1].right, nodes[1].bal);
		scanf ("%s %s %s", nodes[2].left, nodes[2].right, nodes[2].bal);
		
		arr[0] = 0; arr[1] = 0; arr[2] = 0; arr[3] = 0;
		arr[4] = 0; arr[5] = 0; arr[6] = 0; arr[7] = 0;
		arr[8] = 0; arr[9] = 0; arr[10] = 0; arr[11] = 0;
		
		if (nodes[0].bal[0] - 117 == 0) {
			temp = strlen (nodes[0].left);
			for (i = temp; i--; ) arr[nodes[0].left[i] - 65]--;
			temp = strlen (nodes[0].right);
			for (i = temp; i--; ) arr[nodes[0].right[i] - 65]++;
		} else if (nodes[0].bal[0] - 100 == 0) {
			temp = strlen (nodes[0].left);
			for (i = temp; i--; ) arr[nodes[0].left[i] - 65]++;
			temp = strlen (nodes[0].right);
			for (i = temp; i--; ) arr[nodes[0].right[i] - 65]--;
		} else {
			temp = strlen (nodes[0].left);
			for (i = temp; i--; ) arr[nodes[0].left[i] - 65] = 100;
			temp = strlen (nodes[0].right);
			for (i = temp; i--; ) arr[nodes[0].right[i] - 65] = 100;
		}
		
		if (nodes[1].bal[0] - 117 == 0) {
			temp = strlen (nodes[1].left);
			for (i = temp; i--; ) arr[nodes[1].left[i] - 65]--;
			temp = strlen (nodes[1].right);
			for (i = temp; i--; ) arr[nodes[1].right[i] - 65]++;
		} else if (nodes[1].bal[0] - 100 == 0) {
			temp = strlen (nodes[1].left);
			for (i = temp; i--; ) arr[nodes[1].left[i] - 65]++;
			temp = strlen (nodes[1].right);
			for (i = temp; i--; ) arr[nodes[1].right[i] - 65]--;
		} else {
			temp = strlen (nodes[1].left);
			for (i = temp; i--; ) arr[nodes[1].left[i] - 65] = 100;
			temp = strlen (nodes[1].right);
			for (i = temp; i--; ) arr[nodes[1].right[i] - 65] = 100;
		}
		
		if (nodes[2].bal[0] - 117 == 0) {
			temp = strlen (nodes[2].left);
			for (i = temp; i--; ) arr[nodes[2].left[i] - 65]--;
			temp = strlen (nodes[2].right);
			for (i = temp; i--; ) arr[nodes[2].right[i] - 65]++;
		} else if (nodes[2].bal[0] - 100 == 0) {
			temp = strlen (nodes[2].left);
			for (i = temp; i--; ) arr[nodes[2].left[i] - 65]++;
			temp = strlen (nodes[2].right);
			for (i = temp; i--; ) arr[nodes[2].right[i] - 65]--;
		} else {
			temp = strlen (nodes[2].left);
			for (i = temp; i--; ) arr[nodes[2].left[i] - 65] = 100;
			temp = strlen (nodes[2].right);
			for (i = temp; i--; ) arr[nodes[2].right[i] - 65] = 100;
		}

		temp = abs (arr[0]); if (temp < 10 && temp > max) { max = temp; maxdex = 0; }
		temp = abs (arr[1]); if (temp < 10 && temp > max) { max = temp; maxdex = 1; }
		temp = abs (arr[2]); if (temp < 10 && temp > max) { max = temp; maxdex = 2; }
		temp = abs (arr[3]); if (temp < 10 && temp > max) { max = temp; maxdex = 3; }
		temp = abs (arr[4]); if (temp < 10 && temp > max) { max = temp; maxdex = 4; }
		temp = abs (arr[5]); if (temp < 10 && temp > max) { max = temp; maxdex = 5; }
		temp = abs (arr[6]); if (temp < 10 && temp > max) { max = temp; maxdex = 6; }
		temp = abs (arr[7]); if (temp < 10 && temp > max) { max = temp; maxdex = 7; }
		temp = abs (arr[8]); if (temp < 10 && temp > max) { max = temp; maxdex = 8; }
		temp = abs (arr[9]); if (temp < 10 && temp > max) { max = temp; maxdex = 9; }
		temp = abs (arr[10]); if (temp < 10 && temp > max) { max = temp; maxdex = 10; }
		temp = abs (arr[11]); if (temp < 10 && temp > max) { max = temp; maxdex = 11; }
		temp = abs (arr[12]); if (temp < 10 && temp > max) { max = temp; maxdex = 12; }
		
		printf ("%c is the counterfeit coin and it is %s.\n", 65 + maxdex, arr[maxdex] > 0 ? "light": "heavy");
	}
	
	return 0;
}
