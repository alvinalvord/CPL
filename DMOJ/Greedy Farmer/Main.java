import java.util.*;

public class Main {
	
	static int max;
	static int n;
	static int m;
	
	public static void traverse (int[][] arr, int i, int j, int h, int sum) {
		if (i < 0 || i >= n) return;
		if (j < 0 || j >= m) return;
		
		if (h < 0) {
			if (sum > max)
				max = sum;
			return;
		}
		
		int temp = arr[i][j];
		
		arr[i][j] = -1;
		sum += temp;
		traverse (arr, i + 1, j, h - 1, sum);
		traverse (arr, i - 1, j, h - 1, sum);
		traverse (arr, i, j + 1, h - 1, sum);
		traverse (arr, i, j - 1, h - 1, sum);
		
		arr[i][j] = temp;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		n = sc.nextInt ();
		m = sc.nextInt ();
		int h = sc.nextInt ();
		
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				arr[i][j] = sc.nextInt ();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					traverse (arr, i, j, h, 0);
			}
		}
		
		System.out.println (max);
	}
	
}