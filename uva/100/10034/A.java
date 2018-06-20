import java.util.*;

public class A {
	
	static class Point {
		double x, y;
		Point (double x, double y) {this.x = x; this.y = y;}
	}
	
	static Point[] points;
	
	static void func () {
		Arrays.sort (points, (a, b) {
			if (a.x == b.x)
				return a.y - b.y;
			return a.x - b.x;
		};
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		
		while (n-->0) {
			int m = sc.nextInt ();
			for (int i = 0; i < m; i++)
				points[i] = new Point (sc.nextDouble (), sc.nextDouble ());
			
			func ();
		}
	}
	
}