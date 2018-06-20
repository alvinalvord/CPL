import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		String a, b;
		while (sc.hasNextLine ()) {
			a = sc.nextLine ();
			b = sc.nextLine ();
			int[] x = new int[26];
			int[] y = new int[26];
	
			for (int i = 0; i < a.length (); i++)
				x[a.charAt (i) - 'a']++;
			for (int i = 0; i < b.length (); i++)
				y[b.charAt (i) - 'a']++;
			
			StringBuilder sb = new StringBuilder ();
			for (int i = 0; i < x.length; i++) {
				while (x[i] > 0 && y[i] > 0) {
					sb.append ((char) ('a' + i));
					x[i] --; y[i] --;
				}
			}
			System.out.println (sb.toString ());
		}
	}
	
}