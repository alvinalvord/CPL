import java.util.*;

public class Main {
	
	static void func (Scanner sc) {
		int n = sc.nextInt ();
		int m = sc.nextInt ();
		int[] arr = new int[n];
		List<Integer> list = new ArrayList<> ();
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt ();
			if (arr[i] == m) {
				list.add (i);
			}
		}
		
		long max = 0;
		
		for (int x: list) {
			long temp = 0;
			for (int i = x - 1; i >= 0; i--) {
				if (arr[i] > m) temp += arr[i];
				else break;
			}
			for (int i = x + 1; i < n; i++) {
				if (arr[i] > m) temp += arr[i];
				else break;
			}
			temp += m;
			
			if (temp > max) max = temp;
		}
		
		System.out.println (max);
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		
		for (int i = 0; i < n; i++) {
			func (sc);
		}
		
	}
	
}