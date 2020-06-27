import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br;
	
	class Data {
		String s;
		byte[] skip;
		
		Data (String s) {
			this.s = s;
			skip = new byte[s.length ()];
			skip[skip.length - 1] = 1;
			for (int i = skip.length - 2; i >= 0; i--) {
				if (s.charAt (i) == s.charAt (i + 1))
					skip[i] = (byte)(skip[i + 1] + 1);
				else
					skip[i] = 1;
			}
		}
		
		boolean match (Data d) {
			for (int i = 0; i < s.length (); ) {
				if (s.charAt (i) == '-') {
					i += skip[i];
				} else if (d.s.charAt (i) == '-') {
					i += d.skip[i];
				} else {
					if (s.charAt (i) == d.s.charAt (i)) {
						i += Math.min (skip[i], d.skip[i]);
					} else {
						return false;
					}
				}
			}
			
			return true;
		}
		
	}
	
	public void run () throws Exception {
		br = new BufferedReader (new InputStreamReader (System.in));
		int n = Integer.parseInt (br.readLine ());
		Data[] data = new Data[n];
		
		for (int i = 0; i < n; i++) {
			data[i] = new Data (br.readLine ());
		}
		
		boolean flag;
		StringBuilder sb = new StringBuilder ();
		for (int i = 1; i < n; i++) {
			flag = false;
			for (int j = 0; j < i; j++) {
				if (data[i].match (data[j])) {
					if (!flag) sb.append (i + 1).append (":");
					flag = true;
					sb.append (" ").append (j + 1);
				}
			}
			if (flag) sb.append ("\n");
		}
		
		System.out.print (sb.toString ());
	}
	
	public static void main (String[] args) throws Exception {
		// long start = System.nanoTime ();
		new Main ().run ();
		// long end = System.nanoTime ();
		// System.out.println ((end - start) / 1e9);
	}
	
}