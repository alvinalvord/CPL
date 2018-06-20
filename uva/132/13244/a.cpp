#include <iostream>

using namespace std;

int
main ()
{
	ios::sync_with_stdio(false);
	
	int t;
	cin >> t;
	unsigned long long int in, out, temp;
	while (t--) {
		cin >> in;
		
		temp = (in + 1) / 2;
		out = temp * temp + (temp - 1) * (temp - 1);
		
		cout << out << endl;
	}
	
	return 0;
}
