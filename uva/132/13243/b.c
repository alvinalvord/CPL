#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	int index;
	char buffer[65536];
} output_buffer;

typedef struct {
	char s[102];
	char skip[100];
} Data;

void
myitoa (int n, char *buffer, int radix)
{
	if (n == 0) {
		buffer[0] = '0';
		buffer[1] = 0;
	} else {
		int index = 0;
		while (n) {
			buffer[index++] = (n % radix) + '0';
			n /= radix;
		}
		buffer[index] = 0;
		int i = 0, j = index - 1;
		char temp;
		while (i < j) {
			temp = buffer[i];
			buffer[i] = buffer[j];
			buffer[j] = temp;
			i++; j--;
		}
	}
}

int
main (int argc, char *argv[])
{
	char input_buffer[8];
	int n, len, i, j, k, l, flag, match;
	Data *data;
	output_buffer out;
	out.index = 0;
	out.buffer[0] = 0;
	
	fgets (input_buffer, 8, stdin);
	n = atoi (input_buffer);
	
	data = malloc (sizeof (Data) * n);
	
	fgets (data[0].s, 102, stdin);
	len = strlen (data[0].s) - 1;
	data[0].skip[len - 1] = 1;
	for (j = len - 2; j >= 0; j--) {
		data[0].skip[j] = data[0].s[j] == data[0].s[j + 1] ? 
			data[0].skip[j + 1] + 1 : 1;
	}
	
	for (i = 1; i < n; i++) {
		fgets (data[i].s, 102, stdin);
		data[i].skip[len - 1] = 1;
		for (j = len - 2; j >= 0; j--) {
			data[i].skip[j] = data[i].s[j] == data[i].s[j + 1] ?
				data[i].skip[j + 1] + 1: 1;
		}
	}
	
	for (i = 1; i < n; i++) {
		flag = 0;
		for (j = 0; j < i; j++) {
			match = 1;
			
			for (k = 0; k < len; ) {
				if (data[i].s[k] == data[j].s[k]) {
					if (data[i].s[k] == '-') {
						k += data[i].skip[k] > data[j].skip[k] ? 
							data[i].skip[k] : data[j].skip[k];
					} else {
						k += data[i].skip[k] < data[j].skip[k] ?
							data[i].skip[k] : data[j].skip[k];
					}
				} else {
					if (data[i].s[k] == '-') {
						k += data[i].skip[k];
					} else if (data[j].s[k] == '-') {
						k += data[j].skip[k];
					} else {
						match = 0;
						break;
					}
				}
			}
			
			if (match) {
				if (!flag) {
					flag = 1;
					myitoa (i + 1, input_buffer, 10);
					for (l = 0; input_buffer[l]; l++)
						out.buffer[out.index++] = input_buffer[l];
					out.buffer[out.index++] = ':';
				}
				myitoa (j + 1, input_buffer, 10);
				out.buffer[out.index++] = ' ';
				for (l = 0; input_buffer[l]; l++)
					out.buffer[out.index++] = input_buffer[l];
				out.buffer[out.index] = 0;
				
				if (out.index > 60000) {
					fputs (out.buffer, stdout);
					out.index = 0;
				}
			}
			
		}
		
		if (flag) {
			out.buffer[out.index++] = '\n';
			out.buffer[out.index] = 0;
		}
	}
	
	if (out.index > 0)
		fputs (out.buffer, stdout);
	
	free (data);
	return 0;
}