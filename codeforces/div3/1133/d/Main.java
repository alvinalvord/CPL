import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		int n = Integer.parseInt (br.readLine ());
		int[] a = new int[n];
		int[] b = new int[n];
		String[] s = br.readLine ().split (" ");
		for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt (s[i]);
		s = br.readLine ().split (" ");
		for (int i = 0; i < s.length; i++) b[i] = Integer.parseInt (s[i]);
		
		List<BigDecimal> list = new ArrayList<>();
		HashMap<BigDecimal, Integer> map = new HashMap <> ();
		int special = 0;
		
		for (int i = 0; i < n; i++) {
			if (a[i] != 0) {
				BigDecimal value = new BigDecimal (-b[i]);
				value = value.divide (new BigDecimal (a[i]), 100, RoundingMode.HALF_UP);
				if (!map.containsKey (value)) {
					map.put (value, 0);
					list.add (value);
				}
				map.put (value, map.get (value) + 1);
			}
			if (a[i] == 0 && b[i] == 0) {
				special ++;
			}
		}

		int max = special;
		for (BigDecimal d: list) {
			if (map.get (d) > max)
				max = map.get (d);
		}
		
		System.out.println (max);
	}
	
}