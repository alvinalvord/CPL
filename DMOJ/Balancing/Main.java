import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		
		int[] arr = new int[n];
		int[] presum = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt ();
			presum[i] = arr[i];
			if (i > 0) presum[i] += presum[i-1];
		}
		
		int key;
		int s = 0, e = 0;
		int left = 0, right = 0;
		int keyCtr = 0;
		boolean flag = false;
		while (true) {
			if (s >= n) break;
			key = arr[s];
			keyCtr ++;
			while (e + 1 < n && arr[e+1] == key) e++;
			
			if (s > 0) left = presum[s-1];
			right = presum[n-1] - presum[e];
			
			if (left == right) {
				flag = true; break;
			}
			s = e + 1;
			e = s;
		}
		if (keyCtr == 1) flag = false;
		System.out.println (((flag ? "YES": "NO")));
		
		
	}
	
}