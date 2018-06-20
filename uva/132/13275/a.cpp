#include <iostream>

using namespace std;

int
main ()
{
	ios::sync_with_stdio(false);
	int t, d, m, y, qy, age;
	
	cin >> t;
	
	for (int i = 1; i <= t; i++) {
		
		cin >> d >> m >> y >> qy;
		
		if (d == 29 && m == 2) {
			age = 0;
			while ((y += 4) <= qy) {
				if (y % 400 == 0) {
					age ++;
				}
				else if (y % 4 == 0 && y % 100 != 0) {
					age ++;
				}
			}
			
		} else {
			age = qy - y;
		}
		
		printf ("Case %d: %d\n", i, age);
	}
	
	
	return 0;
}
