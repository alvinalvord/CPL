import java.util.*;

public class Main {
	
	static class Point {
		double x, y;
		Point (double x, double y) {
			this.x = x; this.y = y;
		}
		double getDist (Point p) {
			double x = p.x - this.x;
			double y = p.y - this.y;
			
			return Math.sqrt (x * x + y * y);
		}
	}
	
	static class S {
		double d;
		int prev;
		boolean[] visited;
		S () {
			d = 0;
			prev = 0;
			visited = new boolean[points.length];
			visited[0] = true;
		}
		S (S p, int dex) {
			d = p.d + dist[p.prev][dex];
			prev = dex;
			visited = new boolean[points.length];
			for (int i = 0; i < visited.length; i++) {
				visited[i] = p.visited[i];
			}
			visited[dex] = true;
		}
	}
	
	static Point[] points;
	static double[][] dist;
	static double min;
	
	public static void genAll (S s) {
		if (s.d > min)
			return;
		
		boolean alldone = true;
		for (int i = 0; i < s.visited.length; i++) {
			if (!s.visited[i]) {
				genAll (new S (s, i));
				alldone = false;
			}
		}
		
		if (alldone && s.d < min)
			min = s.d;
	}
	
	public static void solve () {
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				dist[i][j] = points[i].getDist (points[j]);
			}
		}
		
		genAll (new S ());
		
		System.out.printf ("%.2f\n", min);
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt ();
			points = new Point[m];
			dist = new double[m][m];
			for (int j = 0; j < m; j++) {
				points[j] = new Point (sc.nextDouble (), sc.nextDouble ());
			}
			
			solve ();
		}
	}
	
}