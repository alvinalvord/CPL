#include <iostream>
using namespace std;
typedef long long int ll;

int
f (void *ugh, int i, int j, int n, int m, ll sum, ll k)
{
	ll (*arr)[m] = static_cast<ll (*)[m]> (ugh);
	if (i + 1 == n && j + 1 == m) return ((sum == k) ? 1: 0);
	
	return 
	(
		(i + 1 < n) ?
		f (arr, i + 1, j, n, m, sum ^ arr[i + 1][j], k) : 0
	) +
	(
		(j + 1 < m) ?
		f (arr, i, j + 1, n, m, sum ^ arr[i][j + 1], k) : 0
	);
}

int
main ()
{
	int n, m;
	ll k;
	cin >> n >> m >> k;
	
	ll arr[n][m];
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
		}
	}
	cout << f (arr, 0, 0, n, m, arr[0][0], k) << "\n";
	
	return 0;
}
