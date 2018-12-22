import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt ();
			if (i > 0) arr[i] += arr[i-1];
		}
		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j >= i && j > 0; j--) {
				int left = 0;
				int right = arr[n-1] - arr[j-1];
				if (i > 0) left = arr[i - 1];
				
				if (left == right) {
					max = left;
				} else if (right > left) break;
			}
		}
		
		System.out.println (max);
	}
	
}
