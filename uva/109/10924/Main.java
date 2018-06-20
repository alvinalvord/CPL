import java.util.*;

public class Main {
	
	static ArrayList<Integer> primes;
	
	public static int convert (char ch) {
		if (ch >= 'a' && ch <= 'z')
		return ch - 'a' + 1;
		if (ch >= 'A' && ch <= 'Z')
			return ch - 'A' + 27;
		return ch;
	}
	
	public static boolean isPrime (int sum) {
		double lim = Math.sqrt(sum);
		
		for (int i = 0; i < primes.size () && primes.get (i) <= lim; i++) {
			if (sum % primes.get (i) == 0) return false;
		}
		
		boolean flag;
		if (primes.get (primes.size () - 1) <= lim) {
			for (int j = primes.get (primes.size () - 1) + 2; j <= lim; j += 2) {
				flag = true;
				for (int p: primes) {
					if (j % p == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					primes.add (j);
					if (sum % j == 0) return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		primes = new ArrayList <Integer> ();
		primes.add (2);
		primes.add (3);
		primes.add (5);
		primes.add (7);
		
		while (sc.hasNextLine ()) {
			String in = sc.nextLine ();
			int sum = 0;
			for (int i = 0; i < in.length (); i++)
				sum += convert (in.charAt (i));
			
			System.out.println ("It is " + (isPrime (sum) ? "" : "not ") + "a prime word.");
		}
	}
	
}