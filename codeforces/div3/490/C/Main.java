import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int[] alpha = new int[26];
		
		int n = sc.nextInt ();
		int k = sc.nextInt ();
		sc.nextLine ();
		StringBuilder sb = new StringBuilder (sc.nextLine ());
		
		for (int i = 0; i < sb.length (); i++)
			alpha[sb.charAt (i) - 'a'] ++;
		
		for (int i = 0; i < alpha.length; i++) {
			if (k >= alpha[i]) {
				k -= alpha[i];
				alpha[i] = 0;
			} else {
				alpha[i] -= k;
				k = 0;
				break;
			}
			
			if (k == 0) break;
		}
		
		StringBuilder out = new StringBuilder ();
		for (int i = sb.length () - 1; i >= 0; i--) {
			if (alpha[sb.charAt(i) - 'a'] > 0) {
				out.append (sb.charAt (i));
				alpha[sb.charAt(i) - 'a'] --;
			}
		}
		
		System.out.println (out.reverse ().toString ());
	}
	
}