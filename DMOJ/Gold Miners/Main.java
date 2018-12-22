import java.util.*;

public class Main {
	
	static class I {
		int v, w;
		double ratio;
		
		public I (int v, int w) {
			this.v = v;
			this.w = w;
			ratio = (double) v / w;
		}
	}
	
	public static void main (String[] args ) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		
		I[] arr = new I[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = new I (sc.nextInt (), sc.nextInt ());
		}
		
		Arrays.sort (arr, (a, b)->{return -Double.compare (a.ratio, b.ratio);});
		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].w < m) {
				total += arr[i].v;
				m -= arr[i].w;
			}
			else {
				total += arr[i].ratio * m;
				m = 0;
			}
			if (m <= 0)
				break;
		}
		System.out.println (String.format ("%.2f", total));
	}
	
}