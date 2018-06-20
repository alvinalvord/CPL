#include <iostream>

using namespace std;

int
main ()
{
	ios::sync_with_stdio(false);
	int n;
	while (cin>>n) {
		unsigned long long int a[n];
		unsigned long long int b[n];
		for (int i = 0; i < n; i++)
			cin >> a[i];
		for (int i = 0; i < n; i++)
			cin >> b[i];
		
		unsigned long long int ap[3] = {0, 0, 0};
		unsigned long long int bp[3] = {0, 0, 0};
		unsigned long long int out[3] = {0, 0, 0};
		
		for (int i = 0; i < n; i++) {
			ap[i % 3] += a[i];
			bp[i % 3] += b[i];
		}
		
		out[0] = 
			ap[0] * bp[1] + 
			ap[1] * bp[0] + 
			ap[2] * bp[2];
			
		out[1] = 
			ap[0] * bp[2] + 
			ap[1] * bp[1] + 
			ap[2] * bp[0];
		
		out[2] = 
			ap[0] * bp[0] + 
			ap[1] * bp[2] + 
			ap[2] * bp[1];
		
		cout << out[0] << " " << out[1] << " " << out[2] << endl;
	}
	return 0;
}
