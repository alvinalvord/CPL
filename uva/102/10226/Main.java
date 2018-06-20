import java.io.*;
import java.util.*;

public class Main {
	
	static class P {
		String s; int d;
		P (String s, int d) {this.s = s; this.d = d;}
		void inc () { d++; }
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		int n = Integer.parseInt (br.readLine ());
		br.readLine ();
		
		for (int i = 0; i < n; i++) {	
			HashMap <String, P> map = new HashMap <> ();
			int ctr = 0;
			while (true) {
				String temp = br.readLine ();
				if (temp == null) break;
				if (temp.length () == 0) break;
				if (map.get (temp) == null)
					map.put (temp, new P (temp, 1));
				else
					map.get (temp).inc ();
				ctr ++;
			}
			
			List<P> list = new ArrayList <> (map.values ());
			list.sort ((a, b) -> (a.s.compareTo (b.s)));
			
			for (P p: list) {
				System.out.printf ("%s %.4f\n", p.s, 100.0 * p.d / ctr);
			}
			
			if (i != n - 1)
				System.out.println ();
		}
		
	}
	
}