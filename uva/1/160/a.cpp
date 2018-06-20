#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int
main ()
{
	ios::sync_with_stdio (false);
	vector<int> primes;
	primes.push_back (2);
	primes.push_back (3);
	primes.push_back (5);
	primes.push_back (7);
	
	bool primeflag;
	for (int i = 11; i < 100; i += 2) {
		primeflag = true;
		for (int j = 0; (unsigned) j < primes.size (); j++) {
			if (i % primes[j] == 0) {
				primeflag = false;
				break;
			}
		}
		
		if (primeflag) {
			int root = (int)sqrt(i);
			bool searchflag;
			for (int j = primes[primes.size () - 1] + 2; j <= root; j += 2) {
				searchflag = true;
				for (int k = 0; (unsigned) k < primes.size (); k++) {
					if (j % primes[k] == 0) {
						searchflag = false;
						break;
					}
				}
				if (searchflag) {
					if (i % j == 0) {
						primeflag = false;
						break;
					}
				}
			}
			
			if (primeflag)
				primes.push_back (i);
		}
	}
	
	int arr[101][primes.size ()];
	
	for (int i = 0; i <= 100; i++) {
		for (int j = 0; (unsigned) j < primes.size (); j++) {
			arr[i][j] = 0;
		}
	}
	
	int temp;
	for (int i = 2; i <= 100; i++) {
		temp = i;
		for (int j = 0; (unsigned) j < primes.size (); j++) {
			while (temp % primes[j] == 0) {
				arr[i][j]++;
				temp /= primes[j];
			}
			arr[i][j] += arr[i - 1][j];
		}
	}
	
	int n;
	
	while (true) {
		cin >> n;
		if (!n) break;
		
		printf ("%3d! =", n);
		for (int i = 0; (unsigned) i < primes.size () && arr[n][i]; i++) {
			if (i == 15) printf ("\n      ");
			printf ("%3d", arr[n][i]);
		}
		printf ("\n");
	}
	
	return 0;
}
