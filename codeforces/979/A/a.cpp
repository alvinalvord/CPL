#include <iostream>

using namespace std;

int
main ()
{
	ios::sync_with_stdio (false);
	
	long long unsigned int n;
	cin >> n;
	if (n == 0)
		cout << 0 << endl;
	else {
		n++;
		cout << 
			((n > 0 && n % 2 == 0) ? n / 2: n)
		<< endl;
	}
	
	
	return 0;	
}
