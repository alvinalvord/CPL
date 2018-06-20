import java.util.*;

public class Solution {
	static List<String> list = new ArrayList <> ();
	
	public static void greed (StringBuilder s, StringBuilder t, StringBuilder u) {
		if (s.length () > 0) {
			greed (new StringBuilder (s).deleteCharAt (0), new StringBuilder (t).append (s.charAt (0)), new StringBuilder (u));
		} else if (s.length () == 0 && t.length () > 0) {
			u.append (t.reverse ());
			t.setLength (0);
		}
		if (t.length () > 0) {
			greed (new StringBuilder (s), new StringBuilder (t).deleteCharAt (t.length () - 1), new StringBuilder (u).append (t.charAt (t.length () - 1)));
		}
		if (s.length () == 0 && t.length () == 0)
			list.add (u.toString ());
	}
	
	public static void dogreed (String str) {
		StringBuilder s = new StringBuilder (str);
		StringBuilder t = new StringBuilder ();
		StringBuilder u = new StringBuilder ();
		
		greed (s, t, u);
		
		list.sort ((a, b) -> { return a.compareTo (b); });
		
		System.out.println (list.get (0));
	}
	
	public static void other (String str) {
		StringBuilder t = new StringBuilder ();
		StringBuilder u = new StringBuilder ();
		int[] arr = new int[26];
		int dex = 0;
		
		for (int i = 0; i < str.length (); i++) arr[str.charAt (i) - 'a']++;
		
		for (int i = 0; i < str.length (); i++) {
			while (arr[dex] == 0) dex++;
			while (t.length () > 0 && t.charAt (t.length () - 1) - 'a' <= dex) {
				u.append (t.charAt (t.length () - 1));
				t.deleteCharAt (t.length () - 1);
			} 
			if (str.charAt (i) - 'a' == dex) {
				u.append (str.charAt (i));
				arr[dex]--;
			} else {
				t.append (str.charAt (i));
				arr[str.charAt (i) - 'a']--;
			}
		}
		
		u.append (t.reverse ());
		
		System.out.println (u.toString ());
	}
	
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		String str = sc.nextLine ();
		
		other (str);
	}
	
}