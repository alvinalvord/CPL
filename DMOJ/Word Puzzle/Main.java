import java.util.*;

public class Main {
	
	static int ctr;
	static boolean flag;
	
	public static void traverse (char[][] arr, String s, int i, int j, int k, int n) {
		
		if (i < 0 || i >= n) return;
		if (j < 0 || j >= n) return;
		char temp = arr[i][j];
		
		if (k >= s.length ()) {
			flag = true;
			return;
		}
		
		if (flag) {
			return;
		}
		
		if (arr[i][j] != s.charAt (k))
			return;
		
		arr[i][j] = 0;
		
		traverse (arr, s, i - 1, j, k + 1, n);
		traverse (arr, s, i - 1, j + 1, k + 1, n);
		traverse (arr, s, i, j + 1, k + 1, n);
		traverse (arr, s, i + 1, j + 1, k + 1, n);
		traverse (arr, s, i + 1, j, k + 1, n);
		traverse (arr, s, i + 1, j - 1, k + 1, n);
		traverse (arr, s, i, j - 1, k + 1, n);
		traverse (arr, s, i - 1, j - 1, k + 1, n);
		
		arr[i][j] = temp;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		sc.nextLine ();
		
		char[][] arr = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine ().replaceAll (" ", "").toCharArray ();
		}
		
		String[] d = new String[m];
		
		for (int i = 0; i < m; i++) {
			d[i] = sc.nextLine ();
		}
		
		ctr = 0;
		
		for (int i = 0; i < m; i++) {
			flag = false;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k ++) {
					if (arr[j][k] == d[i].charAt (0))
						traverse (arr, d[i], j, k, 0, n);
				}
			}
			if (flag) ctr ++;
		}
		
		// for (int i = 0; i < n; i++) System.out.println (new String (arr[i]));
		
		System.out.println (ctr);
	}
	
}