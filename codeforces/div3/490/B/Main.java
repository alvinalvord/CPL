import java.util.*;

public class Main {
	
	static void rev (char[] arr, int i, int j) {
		char temp;
		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++; j--;
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		sc.nextLine ();
		char[] arr = sc.nextLine ().toCharArray ();
		
		ArrayList<Integer> divisors = new ArrayList <>();
		divisors.add (1);
		divisors.add (n);
		int lim = n;
		for (int i = 2; i < lim; i++) {
			if (n % i == 0) {
				divisors.add (i);
				lim = n / i;
				if (lim > i)
					divisors.add (lim);
			}
		}
		divisors.sort ((a, b) -> Integer.compare(b, a));
		
		for (int i = divisors.size () - 1; i >= 0; i--) {
			// System.out.println (divisors.get (i));
			rev (arr, 0, divisors.get (i) - 1);
		}
		
		System.out.println (new String (arr));
	}
	
}