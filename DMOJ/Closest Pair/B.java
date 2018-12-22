import java.util.*;

public class B {
	
	class Point {
		int x, y, index;
		
		Point (int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}
		
		// distance between two points is the pythagorian theorem
		// a^2 + b^2 = c^2
		// therefore distance is sqrt (a^2 + b^2)
		// but for checking purposes, since sqrt is slow 
		// we keep the distance as a^2 + b^2
		long getDistance (Point other) {
			long dx = other.x - this.x;
			long dy = other.y - this.y;
			return dx * dx + dy * dy;
		}
		
		// computes for the X-axis distance between two points
		long quickXDistance (Point other) {
			long temp = other.x - this.x;
			return temp * temp;
		}
		
		// computes for the Y-axis distance between two points
		long quickYDistance (Point other) {
			long temp = other.y - this.y;
			return temp * temp;
		}
		
	}
	
	class PointPair {
		Point a, b;
		long dist;
		
		// initialized to infinity when searching for min value
		PointPair () {
			dist = Long.MAX_VALUE;
		}
		
		PointPair (Point a, Point b, long dist) {
			this.a = a;
			this.b = b;
			this.dist = dist;
		}
	
	}
	
	public PointPair min (PointPair a, PointPair b) {
		if (a.dist < b.dist)
			return a;
		else
			return b;
	}
	
	// brute force solution is to check each point vs all other points
	// since distance between point a -> b is equal to b -> a
	// only check a -> b i.e. arr[0...n-1] vs arr[1...n] @check for loops
	public PointPair bruteForce (Point[] arr) {
		PointPair closestPointsInArr = new PointPair ();
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				long tempDist = arr[i].getDistance (arr[j]);
				if (tempDist < closestPointsInArr.dist) {
					closestPointsInArr.a = arr[i];
					closestPointsInArr.b = arr[j];
					closestPointsInArr.dist = tempDist;
				}
			}
		}
		
		return closestPointsInArr;
	}
	
	// checks the strip between two divisions if there is a closer pair
	// similar to brute force but with a special condition
	// since all candidates in strip have X-axis distances less than the
	//    minimum distance in minPairBetweenDivisions 
	//    assuming strip is sorted via y, then once the distance
	//    via y is already bigger than the minimum then we don't need to
	//    check further @check condition in second for loop
	public PointPair checkStrip (Point[] strip, PointPair minPairBetweenDivisions) {
		PointPair closestPointsInStrip = new PointPair ();
		
		for (int i = 0; i < strip.length - 1; i++) {
			for (int j = i + 1; 
				j < strip.length &&
				strip[j].quickYDistance (strip[i]) < closestPointsInStrip.dist; 
				j++) {
				long tempDist = strip[i].getDistance (strip[j]);
				if (tempDist < closestPointsInStrip.dist) {
					closestPointsInStrip.a = strip[i];
					closestPointsInStrip.b = strip[j];
					closestPointsInStrip.dist = tempDist;
				}
			}
		}
		
		return closestPointsInStrip;
	}
	
	public PointPair closest (Point[] points) {
		// base case
		// pick a limit before bruteforcing
		// 2 <= limit <= 100 is a good limit
		if (points.length <= 2)
			return bruteForce (points);
		
		int n = points.length / 2; // new length of left array
			// note: points[n] is the middle point
		int m = points.length - n; // new length of right array
		
		Point[] left = new Point[n];
		Point[] right = new Point[m];
		// copy points to left and right arrays
		for (int i = 0; i < n; i++) {
			left[i] = points[i];
		}
		
		for (int i = 0; i < m; i++) {
			right[i] = points[i + n];
		}
		
		// recursive case
		// get the minimum distance from left and right array
		PointPair closestPointsFromLeft = closest (left);
		PointPair closestPointsFromRight = closest (right);
		
		// minimum from left and right
		PointPair minPairBetweenDivisions = min (closestPointsFromLeft, closestPointsFromRight);
		
		// get candidates from left and right array
		// candidates are points whose x distance from the middle point
		// is less than the minPairBetweenDivisions distance
		List<Point> strip = new ArrayList<> ();
		
		// from left
		for (int i = n - 1; i >= 0; i--) {
			if (points[i].quickXDistance (points[n]) < minPairBetweenDivisions.dist)
				strip.add (points[i]);
			else
				break;
		}
		
		// from right
		for (int i = n; i < points.length; i++) {
			if (points[i].quickXDistance (points[n]) < minPairBetweenDivisions.dist)
				strip.add (points[i]);
			else 
				break;
		}
		
		// sort strip via Y-axis
		Collections.sort (strip, (a, b) -> Integer.compare (a.y, b.y));
		Point[] candidates = new Point[strip.size ()];
		strip.toArray (candidates);
		
		// return the minimum in this division
		return 
			min (minPairBetweenDivisions, 
				checkStrip (candidates, minPairBetweenDivisions));
	}
	
	public void run () {
		Scanner sc = new Scanner (System.in);
		int size = sc.nextInt ();
		Point[] points = new Point[size];
		for (int i = 0; i < size; i++) {
			points[i] = new Point (sc.nextInt (), sc.nextInt (), i);
		}
		
		// sort via x
		Arrays.sort (points, (a,b) -> Integer.compare (a.x, b.x));
		PointPair output = closest (points);
		// print indices of closest pair and distance of two points
		System.out.printf ("%d %d %.6f\n", output.a.index, output.b.index, 
			Math.sqrt (output.dist));
	}
	
	
	public static void main (String[] args) {
		new B ().run ();
	}
	
}