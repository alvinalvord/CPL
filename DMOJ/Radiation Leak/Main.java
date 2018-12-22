import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		int d = sc.nextInt ();
		
		int[] affected = new int[m];
		for (int i = 0; i < m; i++) affected[i] = sc.nextInt ();
		
		int[][] graph = new int[n][n];
		for (int i = 0; i < n-1; i++) {
			int x = sc.nextInt () - 1; int y = sc.nextInt () - 1;
			graph[x][y] = graph[y][x] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] != 0) {
					for (int k = 0; k < n; k++) {
						if (i != k && graph[j][k] != 0) {
							if (graph[i][k] == 0)
								graph[k][i] = graph[i][k] = graph[i][j] + graph[j][k];
							else
								graph[k][i] = graph[i][k] = 
									Math.min (graph[i][j] + graph[j][k],
										graph[k][i]);
						}
					}
				}
			}
		}
		
		int ctr = 0;
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < n; j++) {
				if (graph[i][j] > max)
					max = graph[i][j];
			}
			if (max <= d)
				ctr ++;
		}
		
		System.out.println (ctr);
		
	}
	
}