import java.util.*;

public class A {
	
	class Point {
		int x, y, index;
		Point (int x, int y, int index) {this.x = x; this.y = y; this.index = index;}
		long getDist (Point other) {
			long dx = other.x - this.x;
			long dy = other.y - this.y;
			return dx * dx + dy * dy;
		}
		long qydist (Point other) {
			long temp = y - other.y; 
			return temp * temp;
		}
	}
	
	class Out {
		Point a, b; long dist;
		Out () {dist = Long.MAX_VALUE;}
		Out (Point a, Point b, long dist) {this.a = a; this.b = b; this.dist = dist;}
	}
	
	public Out brutex (Point[] arr) {
		Out min = new Out ();
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				long tempdist = arr[i].getDist(arr[j]);
				if (tempdist < min.dist) {
					min.a = arr[i];
					min.b = arr[j];
					min.dist = tempdist;
				}
			}
		}
		
		return min;
	}
	
	public Out brutey (Point[] arr, Out minout) {
		Out min = new Out (minout.a, minout.b, minout.dist);
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length && 
				arr[j].qydist(arr[i]) < min.dist; j++) {
				long tempdist = arr[i].getDist(arr[j]);
				if (tempdist < min.dist) {
					min.a = arr[i];
					min.b = arr[j];
					min.dist = tempdist;
				}
			}
		}
		
		return min;
	}
	
	public Out min (Out a, Out b) {
		return (a.dist < b.dist) ? a : b;
	}
	
	public Out closest (Point[] arr) {
		if (arr.length <= 2) return brutex (arr);
		
		int n = arr.length / 2;
		int m = arr.length - n;
		
		Point[] left = new Point[n];
		Point[] right = new Point[m];
		
		for (int i = 0; i < n; i++) {
			left[i] = arr[i];
		}
		for (int i = 0; i < m; i++) {
			right[i] = arr[i + n];
		}
		
		Out leftout = closest (left);
		Out rightout = closest (right);
		Out minout = min(leftout, rightout);
		
		List <Point> strip = new ArrayList <> ();
		for (int i = n - 1; i >= 0; i--) {
			long testd = arr[i].x - arr[n].x;
			if (testd * testd < minout.dist)
				strip.add (arr[i]);
		}
		for (int i = n; i < arr.length; i++) {
			long testd = arr[i].x - arr[n].x;
			if (testd * testd < minout.dist)
				strip.add (arr[i]);
		}
		
		Collections.sort (strip, (a, b) -> Integer.compare (a.y, b.y));
		Point[] candidates = new Point[strip.size ()];
		strip.toArray (candidates);
		return min (minout, brutey (candidates, minout));
	}
	
	public void run () {
		Scanner sc = new Scanner (System.in);
		int size = sc.nextInt ();
		Point[] points = new Point[size];
		for (int i = 0; i < size; i++) {
			points[i] = new Point (sc.nextInt (), sc.nextInt (), i);
		}
		Arrays.sort (points, (a,b) -> Integer.compare (a.x, b.x));
		Out out = closest (points);
		System.out.printf ("%d %d %.6f\n", out.a.index, 
			out.b.index, Math.sqrt (out.dist));
	}
	
	public static void main (String[] args) {
		new A ().run ();
	}
	
}