import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		int k = sc.nextInt ();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt ();
		
		Arrays.sort (arr);
		
		boolean[] d = new boolean[n];
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (!d[j]) {
					d[j] = arr[i] > arr[j] && arr[i] <= arr[j] + k;
				}
			}
		}
		
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += d[i] ? 1 : 0;
		}
		
		System.out.println (n - total);
	}
	
}