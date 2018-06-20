#include <iostream>
#include <cmath>

using namespace std;

int
main ()
{
	ios::sync_with_stdio(false);
	
	int t, len, width, cctr, n, k;
	char ch;
	double park, houses, temp;
	cin >> t;
	
	while (t--) {
		len = 0; width = 0;
		park = 0; houses = 0;
		cctr = 0;
		
		cin >> n;
		
		while (n--) {
			cin >> ch >> k;
			
			if (ch == 'C') {
				cctr ++;
				houses += (k * k);
			} else if (ch == 'S') {
				houses += (k * k);
			} else {
				temp = k * 1.0 / 2.0;
				houses += (temp * sqrt(k * k - temp * temp));
			}
			
			if (cctr == 1) {
				len += k;
			} else if (cctr == 2) {
				len += k;
				width += k;
				cctr++;
			} else if (cctr == 3) {
				width += k;
			} else if (cctr == 4) {
				width += k;
				cctr++;
			}
			
		}
		
		park = len * width;
		printf ("%.4lf\n", park - houses);
	}
	
	return 0;
}
