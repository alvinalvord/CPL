#include <iostream>

using namespace std;

void 
rev (char *arr, int i, int j)
{
	if (i >= j) return;
	
	char temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
	cout << arr << endl;
	rev (arr, i + 1, j - 1);
}

int
main ()
{
	int n;
	cin >> n;
	char arr[n];
	cin >> arr;
	
	for (int i = n - 1; n > 0; n --) {
		rev (arr, 0, i);
	}
	
	cout << arr << endl;
	
	return 0;
}
