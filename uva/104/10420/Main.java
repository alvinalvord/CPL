import java.util.*;

public class Main {
	
	static class M {
		String c;
		List<String> names;
		
		public M () {
			names = new ArrayList <> ();
		}
		
		public void add (String name) {
			if (!names.contains (name))
				names.add (name);
		}
		
		public boolean equals (Object obj) {
			return ((String) obj).equals (c);
		}
		
		public void sort () {
			names.sort ((a,b) -> {
				return a.compareTo (b);
			});
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt (); sc.nextLine ();
		List <M> list = new ArrayList <> ();
		for (int i = 0; i < n; i++) {
			String c = sc.next ();
			String name = sc.nextLine ();
			int dex = -1;
			for (int j = 0; j < list.size (); j++) {
				if (list.get(j).equals (c)) {
					dex = j; break;
				}
			}
			if (dex == -1) {
				M m = new M ();
				m.c = c;
				m.add (name);
				list.add (m);
			} else {
				list.get (dex).add (name);
			}
		}
		
		list.sort ((a,b) -> {
			return a.c.compareTo (b.c);
		});
		
		for (M m: list) {
			System.out.println (m.c + " " + m.names.size ());
		}
		
	}
	
}