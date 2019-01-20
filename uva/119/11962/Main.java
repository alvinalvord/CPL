import java.util.*;

public class Main {
	
	static long parse (char ch) {
		switch (ch) {
			case 'A': return 0L;
			case 'C': return 1L;
			case 'G': return 2L;
			case 'T': return 3L;
		}
		return 0L;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt (); sc.nextLine ();
		
		for (int i = 1; i <= n; i++) {
			char[] arr = sc.nextLine ().toCharArray ();
			
			int a = arr.length;
			long b = 0;
			for (int j = 0; j < a - 1; j++) {
				b ^= parse (arr[j]);
				b <<= 2;
			}
			b ^= parse (arr[a-1]);
			
			System.out.println ("Case " + i + ": (" + a + ":" + b + ")");
		}
	}
	
}