import java.util.*;

public class a {
	
	static class P {
		int x, y;
		P (int x, int y) {this.x = x; this.y = y;}
		public String toString () {
			return x + " " + y;
		}
	}
	
	static boolean intersects (P p1, P p2, P p3, P p4) {
		if (p1.x > p4.x || p3.x > p2.x) return false;
		if (p1.y < p4.y || p3.y < p2.y) return false;
		return true;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		P[] arr1 = new P[4];
		for (int i = 0; i < 4; i++) {
			arr1[i] = new P(sc.nextInt (), sc.nextInt ());
		}
		P[] arr2 = new P[4];
		for (int i = 0; i < 4; i++) {
			arr2[i] = new P (sc.nextInt (), sc.nextInt ());
		}
		
		P stl = arr1[0];
		P sbr = arr1[0];
		
		for (int i = 1; i < 4; i++) {
			if (stl.y <= arr1[i].y && stl.x >= arr1[i].x)
				stl = arr1[i];
			if (sbr.x <= arr1[i].x && sbr.y >= arr1[i].y)
				sbr = arr1[i];
		}
		
		int minx = Integer.MAX_VALUE; int miny = Integer.MAX_VALUE;
			int maxx = 0; int maxy = 0;
		for (int i = 0; i < 4; i++) {
			if (arr2[i].x > maxx)
				maxx = arr2[i].x;
			if (arr2[i].x < minx)
				minx = arr2[i].x;
			if (arr2[i].y > maxy)
				maxy = arr2[i].y;
			if (arr2[i].y < miny)
				miny = arr2[i].y;
		}
		P dtl = new P (minx, maxy);
		P dbr = new P (maxx, miny);
		
		// System.out.println (stl.toString () + " " + sbr.toString ());
		// System.out.println (dtl.toString () + " " + dbr.toString ());
		
		if (intersects (stl, sbr, dtl, dbr))
			System.out.println ("YES");
		else System.out.println ("NO");
	}
	
}