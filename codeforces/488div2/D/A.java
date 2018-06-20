import java.util.*;

public class A {
	
	static class P {
		int x, y;
		P (int x, int y) {
			this.x = x;
			this.y = y;
		}
		boolean isValid (P p) {
			return (x == p.x && y != p.y) ||
				(x != p.x && y == p.y);
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		
		P[] arr1 = new P[n];
		P[] arr2 = new P[m];
		
		for (int i = 0; i < n; i++)
			arr1[i] = new P (sc.nextInt (), sc.nextInt ());
		
		for (int i = 0; i < m; i++)
			arr2[i] = new P (sc.nextInt (), sc.nextInt ());
		
		int out = 100;
		int[] check = new int[10];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr1[i].x == arr2[j].x) {
					check[arr1[i].x]++;
					
					if (arr1[i].y != arr2[j].y)
						if (out == 100)
						out = arr1[i].x;
						else if (out == arr1[i].x)
							out = -1;
						else if (out > 0) out = 0;
					
				} else if (arr1[i].x == arr2[j].y) {
					check[arr1[i].x]++;
					if (arr1[i].y != arr2[j].x)
						if (out == 100)
						out = arr1[i].x;
						else if (out == arr1[i].x)
							out = -1;
						else if (out > 0) out = 0;
					
					
				} else if (arr1[i].y == arr2[j].x) {
					
					check[arr1[i].y]++;
					if (arr1[i].x != arr2[j].y)
						if (out == 100)
						out = arr1[i].y;
						else if (out == arr1[i].y)
							out = -1;
						else if (out > 0) out = 0;
					
					
				} else if (arr1[i].y == arr2[j].y) {
					
					check[arr1[i].y]++;
					if (arr1[i].x != arr2[j].x)
						if (out == 100)
							out = arr1[i].y;
						else if (out == arr1[i].y)
							out = -1;
						else if (out > 0) out = 0;
				}
			}
		}
		
		System.out.println (out);
		
		
	}
	
}