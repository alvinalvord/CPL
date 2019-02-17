import java.util.*;

public class Main {
	
	static class Node {
		int index;
		int val;
		int depth;
		Node parent;
		
		Node (int index, int val) {
			this.index = index;
			this.val = val;
			this.depth = 1;
			parent = null;
		}
		
		Node (Node n, int index, int val) {
			this.index = index;
			this.val = val + n.val;
			this.depth = n.depth + 1;
			parent = n;
		}
		
	}
	
	static void f (int h, int w, char[][] arr) {
		PriorityQueue <Node> queue = new PriorityQueue <> ((a, b) -> {
			if (a.val == b.val) return Integer.compare (a.depth, b.depth);
			return Integer.compare (a.val, b.val);
		});
		
		for (int i = 0; i < arr[0].length; i++) {
			queue.add (new Node (i, arr[0][i]));
		}
		
		Node found = null;
		
		while (!queue.isEmpty ()) {
			Node n = queue.poll ();
			
			if (n.depth + 1 == h) {
				char min = arr[n.depth][n.index];
				int dex = n.index;
				if (n.index + 1 < w) {
					if (arr[n.depth][n.index + 1] < min) {
						min = arr[n.depth][n.index + 1];
						dex = n.index + 1;
					}
				}
				if (n.index - 1 >= 0) {
					if (arr[n.depth][n.index - 1] < min) {
						min = arr[n.depth][n.index - 1];
						dex = n.index - 1;
					}
				}
				found = new Node (n, dex, min);
				break;
			} else {
				if (n.index - 1 >= 0) {
					queue.add (new Node (n, n.index - 1, arr[n.depth][n.index - 1]));
				}
				queue.add (new Node (n, n.index, arr[n.depth][n.index]));
				if (n.index + 1 < w) {
					queue.add (new Node (n, n.index + 1, arr[n.depth][n.index + 1]));
				}
			}
		}
		
		int j = h - 1;
		while (found != null) {
			arr[j][found.index] = ' ';
			found = found.parent;
			j--;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println (new String (arr[i]));
		}
		System.out.println ();
	}
 	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		while (true) {
			int h = sc.nextInt ();
			int w = sc.nextInt ();
			sc.nextLine ();
			if (h == 0 && w == 0) break;
			
			char[][] arr = new char[h][w];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLine ().toCharArray ();
			}
			
			f (h, w, arr);
		}
	}
		
}