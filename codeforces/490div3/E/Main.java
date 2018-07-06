import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		int s = sc.nextInt () - 1;
		
		boolean[][] map = new boolean[n][n];
		int x, y;
		for (int i = 0; i < m; i++) {
			x = sc.nextInt () - 1;
			y = sc.nextInt () - 1;
			map[x][y] = true;
		}
		
		
		
		for (int i = 0; i < n; i++)
			if (!map[i][s]) ctr++;
		
		System.out.println (ctr);
		 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print ("[" + (map[i][j] ? "1":"0")  + "]");
			}
			System.out.println ();
		}
		 
		
	}
	
}