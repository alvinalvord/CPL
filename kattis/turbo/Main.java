import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt ();
		
		int left = 0, right = n - 1, curl = 1, curr = n, ctr = 1;
		
		while (left < right) {
			int count = 0;
			if ((ctr & 1) == 1) {
				int start = right;
				while (arr[start] != curl) start --;
				while (start > left) {
					arr[start] = arr[--start];
					count++;
				}
				System.out.println (count);
				left ++;
				curl++;
			}
			else {
				int start = left;
				while (arr[start] != curr) start ++;
				while (start < right) {
					arr[start] = arr[++start];
					count++;
				}
				System.out.println (count);
				right --;
				curr --;
			}
			ctr ++;
		}
		
		System.out.println (0);
	}
	
}