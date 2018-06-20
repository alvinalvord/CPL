#include <iostream>

using namespace std;

int
main ()
{
	ios::sync_with_stdio(false);
	int n;
	while (cin>>n) {
		unsigned long long int a[3] = {0,0,0};
		unsigned long long int b[3] = {0,0,0};
		unsigned long long int out[3] = {0, 0, 0};
		unsigned long long int temp;
		for (int i = 0; i < n; i++) {
			cin >> temp;
			a[i % 3] += temp;
		}
		for (int i = 0; i < n; i++) {
			cin >> temp;
			b[i % 3] += temp;
		}
		
		out[0] = 
			a[0] * b[1] + 
			a[1] * b[0] + 
			a[2] * b[2];
			
		out[1] = 
			a[0] * b[2] + 
			a[1] * b[1] + 
			a[2] * b[0];
		
		out[2] = 
			a[0] * b[0] + 
			a[1] * b[2] + 
			a[2] * b[1];
		
		cout << out[0] << " " << out[1] << " " << out[2] << endl;
	}
	return 0;
}
