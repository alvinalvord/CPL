import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt ();
		Arrays.sort (arr);
		
		int i = n - 1;
		int j = n - 1;
		int count = 0;
		while (i >= 0 && j >= 0) {
			if (arr[j] > arr[i]) {
				j --; i--; count++;
			} else {
				i--;
			}
		}
		
		System.out.println (count);
	}
}