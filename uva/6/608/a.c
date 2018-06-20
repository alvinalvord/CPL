#include <stdio.h>
#include <math.h>
#include <string.h>

typedef char string[32];

typedef struct {
	string left, right, bal;
} node;

void
func ()
{
	int arr[12];
	node nodes[3];
	int i, j, temp;
	int max = 0, maxdex = 0;
	
	for (i = 0; i < 3; i++)
		scanf ("%s %s %s", nodes[i].left, nodes[i].right, nodes[i].bal);
	
	for (i = 12; i--; ) arr[i] = 0;
	
	for (i = 3; i--; ) {
		if (nodes[i].bal[0] == 'u') {
			
			temp = strlen (nodes[i].left);
			for (j = temp; j--; ) {
				arr[nodes[i].left[j] - 'A']--;
			}
			
			temp = strlen (nodes[i].right);
			for (j = 0; j < temp; j++) {
				arr[nodes[i].right[j] - 'A']++;
			}
		} else if (nodes[i].bal[0] == 'd') {
			
			temp = strlen (nodes[i].left);
			for (j = temp; j--; ) {
				arr[nodes[i].left[j] - 'A']++;
			}
			
			temp = strlen (nodes[i].right);
			for (j = temp; j--; ) {
				arr[nodes[i].right[j] - 'A']--;
			}
		}
	}
	
	for (i = 3; i--; ) {
		if (nodes[i].bal[0] == 'e') {
			
			temp = strlen (nodes[i].left);
			for (j = temp; j--; ) {
				arr[nodes[i].left[j] - 'A'] = 0;
			}
			
			temp = strlen (nodes[i].right);
			for (j = temp; j--; ) {
				arr[nodes[i].right[j] - 'A'] = 0;
			}
		}
	}

	
	for (i = 12; i--; ) {
		temp = abs (arr[i]);
		if (temp > max) {
			max = temp;
			maxdex = i;
		}
	}
	
	printf ("%c is the counterfeit coin and it is %s.\n", 'A' + maxdex, arr[maxdex] > 0 ? "light": "heavy");
}


int
main ()
{
	
	int t;
	
	scanf ("%d", &t);

	while (t--)
		func ();
	
	return 0;
	
}
