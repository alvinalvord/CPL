#include <stdio.h>

const char *arr[] = {
	" ",
	".,?\"",
	"abc",
	"def",
	"ghi",
	"jkl",
	"mno",
	"pqrs",
	"tuv",
	"wxyz"
};

void
func ()
{
	int len, i;
	scanf ("%d", &len);
	
	char out[len + 1];
	out[len] = 0;
	int button[len];
	int count;
	
	for (i = 0; i < len; i++) {
		scanf ("%d", button + i);
	}
	
	for (i = 0; i < len; i++) {
		scanf ("%d", &count);
		out[i] = arr[button[i]][count - 1];
	}
	
	printf ("%s\n", out);
}

int
main ()
{
	int i, n;
	scanf ("%d", &n);
	
	for (i = 0; i < n; i++) {
		func ();
	}
	
	return 0;
}