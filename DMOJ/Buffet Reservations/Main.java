import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		
		int[] arr = new int[25];
		
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt ();
			int t = s + sc.nextInt ();
			
			for (; s < t; s++) {
				arr[s]++;
			}
		}
		
		int max = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > max)
				max = arr[i];
		
		System.out.println (max);
	}
	
}