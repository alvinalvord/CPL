import java.util.*;

public class A {
	
	public static int max (int a, int b, int c) {
		int m = a;
		if (b > m)
			m = b;
		return (c > m ? c : m);
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (sc.hasNextLine ()) {
			String a = sc.nextLine ();
			String b = sc.nextLine ();
		
			int[][] arr = new int[a.length () + 1][b.length () + 1];
			
			for (int i = 0; i < arr.length; i++)
				arr[i][0] = 0;
			for (int i = 0; i < arr[0].length; i++)
				arr[0][i] = 0;
			
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr[i].length; j++) {
					arr[i][j] = max (arr[i-1][j], arr[i][j-1], arr[i-1][j-1] + (a.charAt (i - 1) == b.charAt (j - 1) ? 1: 0));
				}
			}
			
			System.out.println (arr[arr.length - 1][arr[0].length - 1]);
		}
		
	}
	
}