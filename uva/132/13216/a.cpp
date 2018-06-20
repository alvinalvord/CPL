#include <iostream>
#include <cstring>

using namespace std;

void
ans (int n) 
{	
	if (n < 2) {
		if (n == 0) printf ("76\n");
		else printf ("16\n");
	} else if (n < 4) {
		if (n == 2) printf ("56\n");
		else printf ("96\n");
	} else printf ("36\n");
}

int
main ()
{
	ios::sync_with_stdio (false);
	int t;
	cin >> t;
	char in[1001];
	while (t--) {
		cin >> in;
		int len = strlen(in);
		if (len == 1) {
			if (in[0] == '0') {
				printf ("1\n");
				continue;
			}
			else if (in[0] == '1') {
				printf ("66\n");
				continue;
			}
		}
		int n = 0;
		if (len > 1) {
			n += (in[len - 2] - '0') * 10;
		}
		n += (in[len - 1] - '0');
		ans (n % 5);
	}
	
	return 0;
}
