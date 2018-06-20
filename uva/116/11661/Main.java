import java.util.regex.*;
import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		Pattern rd = Pattern.compile ("(R\\.*D)");
		Pattern dr = Pattern.compile ("(D\\.*R)");
		while (true) {
			int n = sc.nextInt (); sc.nextLine ();
			if (n == 0) break;
			String s = sc.nextLine ();
			if (s.contains ("Z")) {
				System.out.println ("0");
			}
			else {
				Matcher m = rd.matcher (s);
				int min = Integer.MAX_VALUE;
				
				while (m.find ()) {
					String temp = m.group ();
					if (min > temp.length () - 1)
						min = temp.length () - 1;
				}
				
				m = dr.matcher (s);
				
				while (m.find ()) {
					String temp = m.group ();
					if (min > temp.length () - 1)
						min = temp.length () - 1;
				}
				
				System.out.println (min);
			}
		}
	}
	
}