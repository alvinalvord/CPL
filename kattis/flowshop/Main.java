import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt ();
			}
		}
		
		for (int i = 1; i < m; i++) {
			arr[0][i] += arr[0][i-1];
		}
		for (int i = 1; i < n; i++) {
			arr[i][0] += arr[i-1][0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				arr[i][j] += Math.max (arr[i-1][j], arr[i][j-1]);
			}
		}
		
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < n; i++) {
			sb.append (arr[i][m-1]).append (' ');
		}
		System.out.println (sb.toString ());
	}
	
}