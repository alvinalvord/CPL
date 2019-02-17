import java.util.*;

public class Main {
	
	int n, m, d;
	Scanner sc;
	Map <Long, Integer> map;
	List<Long> list;
	List<TreeSet<Integer>> adj;
	List<Integer> reference;
	long[] query;
	
	Main () {
		sc = new Scanner (System.in);
	}
	
	public void run () {
		n = sc.nextInt ();
		m = sc.nextInt ();
		d = sc.nextInt ();
		adj = new ArrayList<> (n);
		map = new HashMap <> ();
		list = new ArrayList<> ();
		reference = new ArrayList <> ();
		query = new long[n];
		
		for (int i = 0; i < n; i++) {
			adj.add (new TreeSet<Integer> ());
		}
		
		// get input
		for (int i = 0; i < m; i++) {
			long x = sc.nextLong ();
			long y = sc.nextLong ();
			if (map.get (x) == null) {
				map.put (x, list.size ());
				list.add (x);
			}
			if (map.get (y) == null) {
				map.put (y, list.size ());
				list.add (y);
			}
			
			adj.get (map.get (x)).add (map.get (y));
		}
		
		for (int i = 0; i < n; i++) query[i] = sc.nextLong ();
		
		// DAG
		int i = 0, j = 0;
		Stack <Integer> saves = new Stack <> ();
		BitSet done = new BitSet (n);
		
		while (reference.size () < n) {
			if (!adj.get (i).isEmpty ()) {
				saves.push (i);
				i = adj.get (i).pollFirst ();
			} else {
				if (!done.get (i))
					reference.add (i);
				done.set (i);
				if (!saves.empty ()) i = saves.pop ();
				else i++;
			}
		}
		
		// edit distance
		int[][] edit = new int[n + 1][n + 1];
		for (i = 0; i <= n; i++) {
			edit[0][i] = edit[i][0] = i;
		}
		
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				edit[i][j] = Math.min (
					edit[i-1][j-1] + ((list.get (reference.get (n - i)) == query[j - 1]) ? 0 : 2),
					Math.min (
						edit[i-1][j] + 1,
						edit[i][j - 1] + 1
					)
				);
			}
		}
		
		System.out.println (edit[n][n]);
	}
	
	public static void main (String[] args) {
		new Main ().run ();
	}
	
}