import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int[] orig = new int[n];
		int[] sorted = new int[n];
		int temp;
		for (int i = 0; i < n; i++) {
			temp = sc.nextInt ();
			orig[i] = sorted[i] = temp;
		}
		
		Arrays.sort (sorted);
		
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				arr[i][j] = Math.max (Math.max (arr[i-1][j], arr[i][j-1]), arr[i-1][j-1] + 
					((orig[i-1] == sorted[j-1]) ? 1 : 0));
			}
		}
		
		List<Integer> list = new ArrayList<> ();
		
		int i = n, j = n;
		
		while (true) {
			if (i == 0 || j == 0 || arr[i][j] == 0) break;
			int key = arr[i][j];
			
			while (i - 1 >= 0) {
				if (arr[i-1][j] == key)
					i--;
				else break;
			}
			
			while (j - 1 >= 0) {
				if (arr[i][j-1] == key)
					j--;
				else break;
			}
			list.add (orig[i-1]);
			i--; j--;
		}
		StringBuilder sb = new StringBuilder ();
		for (i = list.size () - 1; i >= 0; i--) {
			sb.append (list.get (i));
			if (i != 0)
				sb.append (" ");
		}
		
		System.out.println (sb.toString ());
		
	}
	
}