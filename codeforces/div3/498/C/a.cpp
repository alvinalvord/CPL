#include <iostream>

using namespace std;

typedef long long int lld;

int
main ()
{
	std::ios::sync_with_stdio (false);
	int n;
	cin >> n;
	
	lld arr[n];
	cin >> arr[0];
	for (int i = 1; i < n; i++) {
		cin >> arr[i];
		arr[i] += arr[i - 1];
	}
	
	lld max = 0;
	lld left, right;
	int low, high, mid;
	for (int i = 1; i < n; i++) {
		left = 0;
		if (i > 0)  {
			left = arr[i - 1];
			if (arr[n-1] - left < left) break;
		}
		low = i - 1;
		high = n - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			right = arr[n - 1] - arr[mid];
			
			if (left == right) {
				max = ((max > left) ? max : left);
				break;
			} else if (right > left) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
	}
	
	cout << max;
	return 0;
}
