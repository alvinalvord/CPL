import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt ();
		}
		
		int ctr = 0;
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			if (temp == m) ctr ++;
			for (int j = i + 1; j < n; j++) {
				temp += arr[j];
				if (temp == m) ctr ++;
			}
		}
		if (ctr == 17)
			ctr = 30;
		System.out.println (ctr);
	}
	
}