import java.util.*;

public class A {
	
	public static void genAll (StringBuilder sb, int dex, int p, int n) {
		if (dex + p >= n)
			return;
		
		char a = sb.charAt (dex);
		char b = sb.charAt (dex + p);
		
		if (a == '0') {
			if (b == '0') genAll (sb, dex + 1, p, n);
			else if (b == '1') {
				for (int i = 0; i < n; i++) {
					if (sb.charAt (i) == '.')
						sb.setCharAt (i, '0');
				}
				System.out.println (sb.toString ());
				System.exit (0);
			}
			else {
				sb.setCharAt (dex + p, '1');
				for (int i = 0; i < n; i++) {
					if (sb.charAt (i) == '.')
						sb.setCharAt (i, '0');
				}
				System.out.println (sb.toString ());
				System.exit (0);
			}
		} else if (a == '1') {
			if (b == '0') {
				for (int i = 0; i < n; i++) {
					if (sb.charAt (i) == '.')
						sb.setCharAt (i, '0');
				}
				System.out.println (sb.toString ());
				System.exit (0);
			}
			else if (b == '1') genAll (sb, dex + 1, p, n);
			else {
				sb.setCharAt (dex + p, '0');
				for (int i = 0; i < n; i++) {
					if (sb.charAt (i) == '.')
						sb.setCharAt (i, '0');
				}
				System.out.println (sb.toString ());
				System.exit (0);
			}
		} else {
			if (b == '0') {
				sb.setCharAt (dex, '1');
				for (int i = 0; i < n; i++) {
					if (sb.charAt (i) == '.')
						sb.setCharAt (i, '0');
				}
				System.out.println (sb.toString ());
				System.exit (0);
			}
			else if (b == '1') {
				sb.setCharAt (dex, '0');
				for (int i = 0; i < n; i++) {
					if (sb.charAt (i) == '.')
						sb.setCharAt (i, '0');
				}
				System.out.println (sb.toString ());
				System.exit (0);
			}
			else {
				sb.setCharAt (dex, '0');
				sb.setCharAt (dex + p, '1');
				for (int i = 0; i < n; i++) {
					if (sb.charAt (i) == '.')
						sb.setCharAt (i, '0');
				}
				System.out.println (sb.toString ());
				System.exit (0);
			}
		}
		
	}
	
	public static void main (String[]  args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt (); int p = sc.nextInt (); sc.nextLine ();
		
		String s = sc.nextLine ();
		StringBuilder sb = new StringBuilder (s);
		
		genAll (sb, 0, p, n);
		
		System.out.println ("No");
	}
	
}