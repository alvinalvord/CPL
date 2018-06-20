#include <iostream>

using namespace std;

int
main ()
{
	ios::sync_with_stdio(false);
	
	int w, n, wi, li;
	
	unsigned long long int area;
	
	while (cin >> w) {
		cin >> n;
		area = 0;
		while (n--) {
			cin >> wi >> li;
			area += wi * li;
		}
		cout << area/w << endl;
	}
	
	return 0;
}
