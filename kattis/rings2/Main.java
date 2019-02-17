import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt (); int m = sc.nextInt (); sc.nextLine ();
		char[][] in = new char[n][m];
		for (int i = 0; i < n; i++) {
			in[i] = sc.nextLine ().toCharArray ();
		}
		int max = 0;
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (in[i][j] == 'T') {
					arr[i][j] = 1;
				}
			}
		}
		
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (arr[i][j] > 0) {
					arr[i][j] = Math.min (arr[i-1][j] + 1, arr[i][j-1] + 1);
				}
			}
		}
		
		for (int i = n - 2; i >= 1; i--) {
			for (int j = m - 2; j >= 1; j--) {
				if (arr[i][j] > 0) {
					arr[i][j] = Math.min (arr[i][j], Math.min (arr[i+1][j] + 1, arr[i][j+1] + 1));					
				}
				if (arr[i][j] > max) max = arr[i][j];
			}
		}
		
		StringBuilder sb = new StringBuilder ();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (max < 10) {
					if (arr[i][j] == 0) {
						sb.append ("..");
					} else {
						sb.append ('.').append (arr[i][j]);
					}
				} else {
					if (arr[i][j] == 0) {
						sb.append ("...");
					} else if (arr[i][j] < 10) {
						sb.append ("..").append (arr[i][j]);
					} else if (arr[i][j] < 100) {
						sb.append (".").append (arr[i][j]);
					} else {
						sb.append (arr[i][j]);
					}
				}
				
			}
			sb.append ("\n");
		}
		System.out.print (sb.toString ());
	}
	
}
