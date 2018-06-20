#include <iostream>
#include <cstdlib>

using namespace std;

typedef struct {
	int x, y;
} node;

int
comp (const void *a, const void *b)
{
	return ((*((const node *)a)).y - (*((const node *)b)).y);
}

int
main ()
{
	std::ios::sync_with_stdio(false);
	
	int n, i;
	cin >> n;
	
	node arr[n];
	int temp, ctr = 0, j;
	bool flag;
	
	for (i = 0; i < n; i++) {
		arr[i].y = 0x7fffffff;
		cin >> temp;
		flag = true;
		for (j = 0; j < ctr; j++) {
			if (arr[j].x == temp) {
				arr[j].y = i;
				flag = false;
				break;
			}
		}
		if (flag) {
			arr[ctr].x = temp;
			arr[ctr++].y = i;
		}
	}
	
	qsort (arr, n, sizeof(node), comp);
	
	cout << ctr << endl;
	for (i = 0; i < ctr; i++) {
		cout << arr[i].x << " ";
	}
	cout << endl;
	
	return 0;
}
