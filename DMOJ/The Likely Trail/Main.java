import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		
		int[][][] arr = new int[m][n][3];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 3; k++)
					arr[j][i][k] = sc.nextInt ();
			}
		}
		int k = sc.nextInt ();
		int[] path = new int[k];
		for (int i = 0; i < k; i++)
			path[i] = sc.nextInt ();
		
		int curloc = 1;
		List <Integer> list = new ArrayList <> ();
		list.add (curloc);
		for (int i = 0; i < k; i++) {
			int nextloc = 1;
			int a = arr[path[i] - 1][curloc - 1][0];
			int b = arr[path[i] - 1][curloc - 1][1];
			int c = arr[path[i] - 1][curloc - 1][2];
			int max = a;
			
			if (b > max) {
				nextloc = 2;
				max = b;
			}
			if (c > max) {
				nextloc = 3;
				max = c;
			}
			list.add (nextloc);
			curloc = nextloc;
		}
		
		for (int i = 0; i < list.size (); i++) {
			System.out.print (list.get (i));
			if (i + 1 != list.size ())
				System.out.print ("->");
		}
		
	}
	
}