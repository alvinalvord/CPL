import java.util.*;

public class A {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt ();
		
		int m = sc.nextInt ();
		
		int max = arr[0];
		for (int i = 0; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
			
		int[] carr = new int[max + 1];
		for (int i = 0; i < n; i++)
			carr[arr[i]] ++;
		
		int acc = 0;
		for (int i = 0; i < carr.length; i++) {
			acc += carr[i];
			if (acc >= m) {
				System.out.println (i);
				break;
			}
		}
		
	}
	
}