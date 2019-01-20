import java.util.*;

public class Main {
	
	public void f (char[] str) {
		int i = 0, j = str.length - 1;
		
		StringBuilder sb = new StringBuilder ();
		StringBuilder cur = new StringBuilder ();
		
		while (j >= 0) {
			if (str[i] == str[j]) {
				cur.append (str[i]);
			// System.out.println (cur.toString () + " " + i + " " + j);
				i++;
			} else {
				j += i;
				i = 0;
				if (cur.length () > sb.length ()) {
					sb = new StringBuilder ();
					sb.append (cur.toString ());
					cur = new StringBuilder ();
				} else {
					cur = new StringBuilder ();
				}
			}
			j--;
		}
		if (cur.length () > 0) {
			if (cur.length () > sb.length ()) {
				sb = new StringBuilder ();
				sb.append (cur.toString ());
			}
		}
		
		System.out.println (sb.reverse ().toString ());
	}
	
	public void run () {
		Scanner sc = new Scanner (System.in);
		
		int n = Integer.parseInt (sc.nextLine ());
		for (int i = 0; i < n; i++) {
			f (sc.nextLine ().toCharArray ());
		}
		
	}
	
	public static void main (String[] args) {
		new Main ().run ();
	}
}