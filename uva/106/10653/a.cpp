#include <iostream>
#include <queue>

using namespace std;

class S {
	public:
		int x, y, c;
		S() {}
		S(int xpos, int ypos, int cost) : x(xpos), y(ypos), c(cost) {}
};

int
main ()
{
	ios::sync_with_stdio(false);
	
	int n, m, 
		b, r, c, col, 
		i, j, 
		sx, sy, gx, gy, 
		up, down, left, right, costup;
	
	while (true) {
		cin >> n >> m;
		if (n == 0 || m == 0) break;
		char arr[n][m];
		bool visited[n][m];
		
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				visited[i][j] = false;
				arr[i][j] = 0;
			}
		}
		
		cin >> b;
		
		for (i = 0; i < b; i++) {
			cin >> r >> c;
			for (j = 0; j < c; j++) {
				cin >> col;
				arr[r][col] = 66;
				visited[r][col] = true;
			}
		}
		
		cin >> sx >> sy >> gx >> gy;
		
		S *cur;
		queue<S*> list;
		list.push(new S (sx, sy, 0));
		visited[sx][sy] = true;
		
		while (!list.empty ()) {
			cur = list.front ();
			list.pop ();
			if (cur->x == gx && cur->y == gy) {
				cout << cur->c << endl; break;
			} else {
				up = cur->x - 1; down = cur->x + 1;
				left = cur->y - 1; right = cur->y + 1;
				costup = cur->c + 1;
				if (up >= 0 && arr[up][cur->y] == 0
					&& !visited[up][cur->y]
				) {
					visited[up][cur->y] = true;
					list.push(new S(up, cur->y, costup));
				}
				if (down < n && arr[down][cur->y] == 0
					&& !visited[down][cur->y]
				) {
					visited[down][cur->y] = true;
					list.push (new S (down, cur->y, costup));
				}
				if (left >= 0 && arr[cur->x][left] == 0
					&& !visited[cur->x][left]
				) {
					visited[cur->x][left] = true;
					list.push (new S (cur->x, left, costup));
				}
				if (right < m && arr[cur->x][right] == 0
					&& !visited[cur->x][right]
				) {
					visited[cur->x][right] = true;
					list.push (new S (cur->x, right, costup));
				}
			}
		}
	}
	
	return 0;
}
