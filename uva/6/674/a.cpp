#include <iostream>

using namespace std;

int
gen (int n, int in, int total) 
{
	if (in == 1) return 1;
	
	if (in != -1) total += in;
	
	if (total > n) return 0;
	else if (total == n) return 1;
	
	return gen (n, 1, total) + 
		gen (n, 5, total) + 
		gen (n, 10, total) + 
		gen (n, 25, total) + 
		gen (n, 50, total);
}

int
main ()
{
	ios::sync_with_stdio (false);
	int arr[7490];
	
	for (int i = 0; i < 7490; i += 5) {
		int temp = gen (i, -1, 0);
		arr[i] = temp;
		arr[i + 1] = temp;
		arr[i + 2] = temp;
		arr[i + 3] = temp;
		arr[i + 4] = temp;
	} 
	
	for (int i = 0; i < 7490; i++)
		cout << arr[i] << endl;
	
	return 0;
}
