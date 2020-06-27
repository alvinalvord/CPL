#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char String[101];

typedef struct {
	String s;
	char skip[100];
} Data;

char 
min (char a, char b) {
	return (a < b) ? a : b;
}

int
match (Data *a, Data *b, int len)
{
	int i;
	for (i = 0; i < len; ) {
		if (a->s[i] == '-') {
			i += a->skip[i];
		} else if (b->s[i] == '-') {
			i += b->skip[i];
		} else {
			if (a->s[i] == b->s[i]) {
				i += min (a->skip[i], b->skip[i]);
			} else {
				return 0;
			}
		}
	}
	return 1;
}

int 
main (int argc, char *argv[])
{
	int n, i, j, len, flag;
	Data *data;
	
	fscanf (stdin, "%d", &n);
	data = malloc (sizeof (Data) * n);
	
	for (i = 0; i < n; i++) scanf ("%s", data[i].s);
	len = strlen (data[0].s);
	
	for (i = n - 1; i >= 0; i--) {
		data[i].skip[len - 1] = 1;
		for (j = len - 2; j >= 0; j--) {
			data[i].skip[j] = (data[i].s[j] == data[i].s[j + 1]) ? 
				data[i].skip[j + 1] + 1 : 1;
		}
	}
	
	for (i = 1; i < n; i++) {
		flag = 0;
		for (j = 0; j < i; j++) {
			if (match (data + i, data + j, len)) {
				if (!flag) fprintf (stdout, "%d:", i + 1);
				flag = 1;
				fprintf (stdout, " %d", j + 1);
			}
		}
		if (flag) fprintf (stdout, "\n");
	}
	
	free (data);
	return 0;
}