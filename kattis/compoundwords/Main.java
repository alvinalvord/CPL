import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		List<String> list = new ArrayList<> ();
		List<String> comp = new ArrayList <> ();
		TreeSet <String> treeset = new TreeSet<> ();
		
		while (sc.hasNextLine ()) {
			String[] arr = sc.nextLine ().split (" ");
			for (String s: arr)
				list.add (s);
		}
		
		for (int i = 0; i < list.size (); i++) {
			for (int j = 0; j < list.size (); j++) {
				if (i != j) {
					String temp = list.get (i) + list.get (j);
					if (!treeset.contains (temp)) {
						treeset.add (temp);
						comp.add (temp);
					}
				}
			}
		}
		
		comp.sort ((a,b) -> { return a.compareTo (b); });
		
		for (String s: comp) System.out.println (s);
	}
	
}