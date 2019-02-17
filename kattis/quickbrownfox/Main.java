import java.io.*;
import java.util.*;

public class Main {
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		int n = Integer.parseInt (br.readLine ());
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine ().toLowerCase ();
			BitSet bitset = new BitSet (26);
			
			for (int j = 0; j < str.length (); j++) {
				if (str.charAt (j) >= 'a' && str.charAt (j) <= 'z') {
					bitset.set (str.charAt (j) - 'a');
				}
			}
			if (bitset.cardinality () == 26) {
				System.out.println ("pangram");
			} else {
				StringBuilder sb = new StringBuilder ();
				sb.append ("missing ");
				for (int j = 0; j < 26; j++) {
					if (!bitset.get (j)) {
						sb.append ((char)('a' + j));
					}
				}
				System.out.println (sb.toString ());
			}
		}
		
	}
	
	
}