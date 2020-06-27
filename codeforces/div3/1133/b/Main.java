import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		int k = sc.nextInt ();
		
		int[] arr = new int[k];
		for (int i = 0; i < n; i++) {
			arr[sc.nextInt () % k] ++;
		}
		
		int lim = k / 2;
		for (int i = 1; i <= lim; i++) {
			if (i == k-i) arr[i] /= 2;
			else arr[i] = Math.min (arr[i], arr[k-i]);
		}
		arr[0] /= 2;
		
		int sum = 0;
		for (int i = 0; i <= lim; i++) {
			sum += arr[i];
		}
		
		sum *= 2;
		
		System.out.println (sum);
		
	}
	
}