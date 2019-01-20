import java.io.*;
import java.util.*;

public class Main {
	
	final String[] strings = {"BCG", "BGC", "CBG", "CGB", "GBC", "GCB"};
	// B 0 3 6
	// G 1 4 7
	// C 2 5 8
	final int[][] indices = {	
		{3,6, 1,4, 2,8}, 
		{3,6, 1,7, 2,5},
		{0,6, 1,4, 5,8},
		{0,3, 1,7, 5,8},
		{0,6, 4,7, 2,5},
		{0,3, 4,7, 2,8}};
	BufferedReader br;
	
	class N {
		String s;
		long val;
		
		N (String s, long val) {this.s = s; this.val = val;}
		int comp (N n) {
			if (val == n.val) return s.compareTo (n.s);
			return Long.compare (val, n.val);
		}
	}
	
	public Main () throws Exception {
		br = new BufferedReader (new InputStreamReader (System.in));
	}
	
	public void run () throws Exception {
		String str;
		long[] arr = new long[9];
		N[] nodes = new N[6];
		
		while ((str = br.readLine ()) != null) {
			String[] temp = str.split (" ");
			if (temp.length < 9) continue;
			for (int i = 0; i < temp.length; i++) {
				arr[i] = Long.parseLong (temp[i]);
			}
			
			for (int i = 0; i < strings.length; i++) {
				long sum = 0;
				for (int j = 0; j < indices.length; j++) {
					sum += arr[indices[i][j]];
				}
				nodes[i] = new N (strings[i], sum);
			}
			
			Arrays.sort (nodes, (a, b) -> {return a.comp(b);});
			
			System.out.println (nodes[0].s + " " + nodes[0].val);
		}
		
	}
	
	public static void main (String[] args) throws Exception {
		new Main ().run ();
	}
	
}
