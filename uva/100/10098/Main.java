import java.util.*;

public class Main {
	
	static List <String> list;
	
	static char[] in;
	
	static class S {
		boolean[] check;
		String s;
		S (String str) {
			s = str; 
			check = new boolean[in.length];
		}
		S (String str, boolean[] check) {
			s = str;
			this.check = new boolean[in.length];
			for (int i = 0; i < check.length; i++)
				this.check[i] = check[i];
		}
		S (S p) {
			this (new String (p.s), p.check);
		}
	}
	
	public static void gen (S prev, int dex) {
		S cur = new S (prev);
		if (dex != -1) {
			cur.s += in[dex];
			cur.check[dex] = true;
		}
		
		if (cur.s.length () == in.length) {
			if (Collections.binarySearch (list, cur.s, (a,b)->a.compareTo(b)) < 0)
				list.add (cur.s);
			return;
		}
		
		for (int i = 0; i < in.length; i++) {
			if (!cur.check[i])
				gen (cur, i);
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt (); sc.nextLine ();
		
		list = new ArrayList <String> ();
		
		for (int i = 0; i < n; i++) {
			list.clear ();
			in = sc.nextLine ().toCharArray ();
			Arrays.sort (in);
			gen (new S (""), -1);
			
			for (String str: list)
				System.out.println (str);
			
			System.out.println ();
		}
	}
	
}