import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br;
	
	public String clean (String in) {
		StringBuilder sb = new StringBuilder ();
		sb.append (in.charAt (0));
		int repeat = 1;
		for (int i = 1; i < in.length (); i++) {
			if (in.charAt (i) == in.charAt (i - 1)) {
				if (repeat < 3) {
					repeat ++;
					sb.append (in.charAt (i));
				}
			} else {
				repeat = 1;
				sb.append (in.charAt (i));
			}
		}
		return sb.toString ();
	}
	
	//wrong value
	public int lim (String in) {
		BitSet[] bs = new BitSet[3];
		for (int i = 0; i < 3; i++) bs[i] = new BitSet (26);
		
		for (int i = in.length () - 3; i >= 0; i--) {
			bs[0].set (in.charAt (i) - 'A');
		}
		for (int i = in.length () - 2; i >= 1; i--) {
			bs[1].set (in.charAt (i) - 'A');
		}
		for (int i = in.length () - 1; i >= 2; i--) {
			bs[2].set (in.charAt (i) - 'A');
		}
		
		return bs[0].cardinality () * bs[1].cardinality () * bs[2].cardinality ();
	}
	
	public int f (String in) {
		if (in.length () < 3) return 0;
		if (in.length () == 3) return 1;
		in = clean (in);
		int limit = lim (in);
		
		BitSet bs = new BitSet (26*26*26);
		int count = 0;
		boolean done = false;
		end:
		if (!done)
		for (int i = in.length () - 3; i >= 0; i--) {
			for (int j = in.length () - 2; j > i && j >= 1; j--) {
				for (int k = in.length () - 1; k > j && k >= 2; k--) {
					int index = (in.charAt (i) - 'A') * 26 * 26 + (in.charAt (j) - 'A') * 26 + (in.charAt (k) - 'A');
					if (!bs.get (index)) {
						// System.out.println ("" + in.charAt (i) + in.charAt (j) + in.charAt (k));
						count ++;
						bs.set (index);
					}
					
					if (count == limit) {
						done = true;
						break end;
					}
						
				}
			}
		}
		
		return count;
	}
	
	public void run () throws Exception {
		br = new BufferedReader (new InputStreamReader (System.in));
		int n = Integer.parseInt (br.readLine ());
		for (int i = 0; i < n; i++) {
			System.out.println (f (br.readLine ()));
		}
	}
	
	public static void main (String[] args) throws Exception {
		new Main ().run ();
	}
	
}