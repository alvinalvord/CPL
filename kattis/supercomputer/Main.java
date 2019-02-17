import java.util.*;
import java.io.*;

public class Main {
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		String[] temp = br.readLine ().split ("\\s+");
		
		int n = Integer.parseInt (temp[0]);
		int k = Integer.parseInt (temp[1]);
		BitSet bs = new BitSet (n);
		for (int i = 0; i < k; i++) {
			temp = br.readLine ().split ("\\s+");
			
			if (temp[0].equals ("F")) {
				bs.flip (Integer.parseInt (temp[1]));
			} else {
				System.out.println (bs.get (Integer.parseInt (temp[1]), Integer.parseInt (temp[2]) + 1).cardinality ());
			}
			
		}
	}
	
}