#include <stdio.h>

#define isOpen(ch) (ch == '(' || ch == '{' || ch == '[' ? 1 : 0)
#define getPartner(ch) (ch == '(' ? ')' : ch == '{' ? '}' : ']')
typedef char string[256];

void
func () 
{
	string in, stack;
	int i, top = 0;
	char flag = 1;
	
	for (i = 0; i < 256; i++)
		stack [i] = 0;
	
	fgets (in, 256, stdin);
	
	for (i = 0; in[i]; i++);
	
	in[i - 1] = 0;
	
	for (i = 0; in[i]; i++) {
		if (isOpen (in[i])) {
			stack[top++] = in[i];
		} else {
			if (top > 0 && in[i] == getPartner (stack[top - 1])) {
				stack[--top] = 0;
			}
			else {
				flag = 0; break;
			}
		}
	}
	if (top > 0)
		flag = 0;
	
	printf ("%s\n", flag ? "Yes": "No");
	
}

int
main ()
{
	int t;
	scanf ("%d\n", &t);
	while (t--) {
		func ();
	}
	
	return 0;
}
