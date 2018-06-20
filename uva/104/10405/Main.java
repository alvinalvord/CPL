import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		while (sc.hasNextLine ()) {
			String a = sc.nextLine ();
			String b = sc.nextLine ();
			
			int[][] arr = new int[a.length () + 1][b.length () + 1];
			
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr[i].length; j++) {
					int p, q, r;
					
					p = arr[i - 1][j - 1] + ((a.charAt (i - 1) == b.charAt (j - 1) ? 1 : 0));
					q = arr[i - 1][j];
					r = arr[i][j - 1];
					
					arr[i][j] = 0;
					if (p > arr[i][j])
						arr[i][j] = p;
					
					if (q > arr[i][j])
						arr[i][j] = q;
					
					if (r > arr[i][j])
						arr[i][j] = r;
				}
			}
			
			int max = 0;
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr[i].length; j++) {
					if (max < arr[i][j])
						max = arr[i][j];
				}
			}
			
			
			System.out.println (max);
		}
	}
	
}