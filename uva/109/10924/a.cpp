#include <iostream>
#include <cmath>
#include <string>
#include <vector>

using namespace std;

int
convert (char ch)
{
	if (ch >= 'a' && ch <= 'z')
		return ch - 'a' + 1;
	if (ch >= 'A' && ch <= 'Z')
		return ch - 'A' + 27;
	return ch;
}

bool
isPrime (int n, vector<unsigned int> prime)
{
	unsigned int lim = sqrt(n);
	
	for (unsigned int i = 0; i < prime.size () && prime[i] < lim; i++) {
		if (n % prime.size () == 0)
			return false;
	}
	return true;
}

void
init (vector<unsigned int> prime)
{
	prime.push_back (2);
	for (unsigned int i = 3; i <= 65536; i++) {
		bool flag = true;
		for (unsigned int j = 0; j < prime.size (); j++) {
			if (i % prime[j] == 0) {
				flag = false;
				break;
			}
		}
		if (flag)
			prime.push_back (i);
	}
}

int
main ()
{
	string str;
	vector <unsigned int> prime;
	
	init (prime);
	
	while (1) {
		cin >> str;
		if (str.length () == 0) break;
		int sum = 0;
		for (unsigned int i = 0; i < str.length (); i++) {
			sum += convert (str[i]);
		}
		
		cout << "It is " << (isPrime (sum, prime) ? "": "not ") << "a prime word." << endl;
	}
	
	return 0;
}
