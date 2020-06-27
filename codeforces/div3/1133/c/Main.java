import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		br.readLine ();
		String[] s = br.readLine ().split (" ");
		
		HashMap<Integer, Integer> map = new HashMap <> ();
		List<Integer> list = new ArrayList<> ();
		for (String ss: s) {
			int x = Integer.parseInt (ss);
			if (!map.containsKey (x)) {
				map.put (x, 0);
				list.add (x);
			}
			map.put (x, map.get (x) + 1);
		}
		int max = 0;
		for (int i = 0; i < list.size (); i++) {
			int sum  = 0;
			for (int j = list.get (i); j <= list.get (i) + 5; j++) {
				if (map.containsKey (j)) {
					sum += map.get (j);
				}
			}
			// System.out.println (sum);
			if (sum > max) {
				max = sum;
			}
		}
		
		System.out.println (max);
	}
	
}