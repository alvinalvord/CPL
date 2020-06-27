import java.util.*;

public class Main {
	
	Scanner sc;
	List<Data> original;
	List<Data> sorted;
	
	class Data {
		String str;
		int index;
		List<Data> matches;	
		Map<Data, Integer> map;
		
		Data (String str, int index) {
			this.str = str;
			this.index = index;
			matches = new ArrayList <> ();
			map = new HashMap<> ();
		}
		
		void append (Data d) {
			map.put (d, matches.size ());
			matches.add (d);
		}
		
		void remove (Data d) {
			int index = map.get (d);
			Collections.swap (matches, index, matches.size () - 1);
			map.remove (d);
			map.put (matches.get (matches.size () - 1), index);
			matches.remove (matches.size () - 1);
		}
	}
	
	public void run () {
		sc = new Scanner (System.in);
		int n = sc.nextInt (); sc.nextLine ();
		original = new ArrayList <> (n);
		sorted = new ArrayList <> (n);
		
		for (int i = 1; i <= n; i++) {
			Data d = new Data (sc.nextLine (), i);
			original.add (d);
			sorted.add (d);
		}
		sorted.sort ((a,b) -> String.compare (a.str, b.str));
		
		for (int i = 0; i < sorted.size () - 1; i++) {
			for (int j = i + 1; j < sorted.size (); j++) {
				sorted.get (i).append (sorted.get (j));
			}
		}
		
		for (int i = 0; i < sorted.size () - 1; i++) {
			boolean wild = true;
			
			
		}
		
		
	}
	
	public static void main (String[] args) {
		new Main ().run ();
	}
	
}