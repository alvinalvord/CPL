#include <iostream>

using namespace std;

int
main ()
{
	int n , k;
	
	cin >> n >> k;
	
	int arr[n];
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	
	int ctr = 0;
	int i = 0, j = n - 1;
	bool flag;
	
	while (i <= j) {
		if (i == j) {
			if (arr[i] <= k) ctr ++;
			break;
		}
		else {
			flag = false;
			if (arr[i] <= k) {
				ctr++;
				i++;
				flag = true;
			}
			if (arr[j] <= k) {
				ctr++;
				j--;
				flag = true;
			}
			if (!flag) break;
		}
	}

	cout << ctr << endl;
	
	return 0;
}