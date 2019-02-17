import java.util.*;

public class Main {
	
	static long countTo (long n) {
		long ctr = 0;
		int i = 1;
		
		while (true) {
			long ni = n / i;
			
			if (ni / 10 == 0) break;
			
			if (ni % 10 == 0) {
				ctr += (ni / 10 - 1) * i + (n % i) + 1;
			} else {
				ctr += ni / 10 * i;
			}
			
			i *= 10;
		}
		
		return ctr;
	}
	
	static long countDigits (long m) {
		if (m == 0) return 1;
		
		long ctr = 0;
		while (m > 0) {
			if (m % 10 == 0) ctr ++;
			m /= 10;
		}
		return ctr;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (sc.hasNextLong ()) {
			long m = sc.nextLong (); long n = sc.nextLong ();
			if (m == n && m == -1) break;
			
			System.out.println (countDigits (m) + countTo (n) - countTo (m));
		}
		
	}
	
}