#include <iostream>

using namespace std;

int
main ()
{
	long long int a, b, A, terms, c = 0;
	
	while (true) {
		c++;
		cin >> a; cin >> b;
		if (a == b && a == -1) break;
		
		A = a;
		terms = 1;
		
		while (A != 1) {
			if (A & 1) A = 3 * A + 1;
			else A /= 2;
			if (A > b) break;
			terms ++;
		}
		
		cout << "Case " << c << ": " <<
		"A = " << a << ", " <<
		"limit = " << b << ", " <<
		"number of terms = " << terms << endl;
	}
	
	
	return 0;
}
