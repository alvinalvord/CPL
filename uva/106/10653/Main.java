import java.util.*;

public class Main {
	
	static class S {
		int x, y, c;
		
		S (int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (true) {
			int n = sc.nextInt (); int m = sc.nextInt ();
			if (n == 0 || m == 0) break;
			int b = sc.nextInt ();
			
			char[][] arr = new char[n][m];
			boolean[][] visited = new boolean[n][m];
			for (int i = 0; i < b; i++) {
				int r = sc.nextInt ();
				int c = sc.nextInt ();
				for (int j = 0; j < c; j++) {
					int col = sc.nextInt ();
					arr[r][col] = 66;
					visited[r][col] = true;
				}
			}
			
			int sx = sc.nextInt (), sy = sc.nextInt (),
				gx = sc.nextInt (), gy = sc.nextInt ();
			
			S cur;
			List <S> list = new ArrayList <S> ();
			list.add (new S (sx,sy,0));
			visited[sx][sy] = true;
			
			while (!list.isEmpty ()) {
				cur = list.remove (0);
				
				if (cur.x == gx && cur.y == gy) {
					System.out.println (cur.c);
					break;
				} else {
					int up = cur.x - 1, down = cur.x + 1, 
					left = cur.y - 1, right = cur.y + 1, 
					costup = cur.c + 1;
					if (up >= 0 && arr[up][cur.y] == 0
						&& !visited[up][cur.y]
					) {
						visited[up][cur.y] = true;
						list.add (new S (up, cur.y, costup));
					}
					if (down < n && arr[down][cur.y] == 0
						&& !visited[down][cur.y]
					) {
						visited[down][cur.y] = true;
						list.add (new S (down, cur.y, costup));
					}
					if (left >= 0 && arr[cur.x][left] == 0
						&& !visited[cur.x][left]
					) {
						visited[cur.x][left] = true;
						list.add (new S (cur.x, left, costup));
					}
					if (right < m && arr[cur.x][right] == 0
						&& !visited[cur.x][right]
					) {
						visited[cur.x][right] = true;
						list.add (new S (cur.x, right, costup));
					}
				}
			}
			
		}
		
	}
	
}