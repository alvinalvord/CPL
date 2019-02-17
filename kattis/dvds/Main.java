import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt ();
			int search = 1;
			int count = 0;
			for (int j = 0; j < m; j++) {
				int temp = sc.nextInt ();
				if (temp == search) {
					count ++;
					search ++;
				}
			}
			
			System.out.println (m - count);
		}
		
	}
	
}