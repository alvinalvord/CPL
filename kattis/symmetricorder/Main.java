import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int num = 1;
		while (true) {
			int n = Integer.parseInt (sc.nextLine ());
			if (n == 0) break;
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLine ();
			}
			System.out.println ("SET " + num);
			for (int i = 0; i < n; i+=2) {
				System.out.println (arr[i]);
			}
			for (int i = ((n%2 == 0? n - 1: n - 2)); i > 0; i-=2) {
				System.out.println (arr[i]);
			}
			num++;
		}
		
	}
	
}