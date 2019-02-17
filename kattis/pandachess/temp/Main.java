import java.util.*;

public class Main {
	
	static class Rule {
		long a, b;
		Rule (long a, long b) {
			this.a = a;
			this.b = b;
		}
		
		public String toString () {
			return a + " " + b;
		}
	}
	
	static class Node {
		long val;
		int pos;
		
		Node (long val, int pos) {
			this.val = val;
			this.pos = pos;
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		int d = sc.nextInt ();
		
		HashMap <Long, Integer> map = new HashMap<> ();
		TreeSet <Rule> rules = new TreeSet<> ((a, b) -> {
			if (a.a == b.a) return Long.compare (a.b, b.b);
			return Long.compare (a.a, b.a);
		});
		
		int index = 0;
		for (int i = 0; i < m; i++) {
			Rule r = new Rule (sc.nextLong (), sc.nextLong ());
			rules.add (r);
			
			if (map.get (r.a) == null)
				map.put (r.a, index++);
			if (map.get (r.b) == null)
				map.put (r.b, index++);
		}
		
		long[] B = new long[n];
		for (int i = 0; i < n; i++) B[i] = sc.nextLong ();
		
		byte[][] arr = new byte[n][n];
		for (Rule r: rules) {
			arr[map.get (r.a)][map.get (r.b)] = 1;
			arr[map.get (r.b)][map.get (r.a)] = -1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (arr[i][j] == 1) {
					for (int k = 0; k < n; k++) {
						if (arr[j][k] == 1) {
							arr[i][k] = 1;
							arr[k][i] = -1;
						}
					}
				} 
				else if (arr[i][j] == -1) {
					for (int k = 0; k < n; k++) {
						if (arr[j][k] == -1) {
							arr[i][k] = -1;
							arr[k][i] = 1;
						}
					}
				}
			}
		}
		
		List<Node> nodes = new ArrayList<> ();
		for (Long val: map.keySet ()) {
			int pos = 0;
			for (int i = 0; i < n; i++) {
				if (arr[map.get (val)][i] > 0)
					pos += arr[map.get(val)][i];
			}
			nodes.add (new Node (val, pos));
		}
		
		Collections.sort(nodes, (a, b) -> { return -Integer.compare (a.pos, b.pos); });
		
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0 ; j < dist.length; j++) {
				if (i == 0 || j == 0) dist[i][j] = i + j;
				else {
					dist[i][j] = Math.min (
						dist[i-1][j-1] + (nodes.get (i-1).val == B[j-1] ? 0: 2),
						Math.min (dist[i-1][j] + 1,
						dist[i][j-1] + 1)
					);
				}
			}
		}
		
		// for (int i = 0; i < n; i++) {
			// for (int j = 0; j < n; j++) System.out.print (String.format ("%2d ", arr[i][j]));
			// System.out.println ();
		// }
		
		System.out.println (dist[n][n]);
	}
	
}