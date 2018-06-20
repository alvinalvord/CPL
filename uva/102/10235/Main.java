import java.util.*;

public class Main {
	
	static ArrayList <Integer> primes;
	
	public static int reverse (int n) {
		int m = 0;
		while (n > 0) {
			m += n % 10;
			n /= 10;
			m *= 10;
		}
		return m / 10;
	}
	
	public static boolean isPrime (int n) {
		double lim = Math.sqrt (n);
		for (int i = 0; i < primes.size () && primes.get (i) <= lim; i++) 
			if (n % primes.get (i) == 0)
				return false;
			
		for (int i = primes.get (primes.size () - 1) + 2; i <= lim; i += 2) {
			boolean flag = true;
			for (int m: primes) {
				if (i % m == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				primes.add (i);
				if (n % i == 0)
					return false;
			}
		}
		return true;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		primes = new ArrayList <>();
		primes.add (2);
		primes.add (3);
		primes.add (5);
		
		while (sc.hasNextInt ()) {
			int n = sc.nextInt ();
			int rev = reverse (n);
			boolean prime = isPrime (n);
			boolean emirp = isPrime (rev);
			
			System.out.printf ("%d is %s.\n",
				n, 
				(!prime ? "not prime": prime && (!emirp || n == rev) ? "prime": "emirp")
			);
		}
		
	}
	
}