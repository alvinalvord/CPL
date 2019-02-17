import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		long n = sc.nextLong ();
		
		TreeSet<Long> set = new TreeSet<> ();
		
		double lim = Math.sqrt (n);
		
		for (long i = 1; i <= lim; i++) {
			if (n % i == 0) {
				set.add (i - 1);
				set.add (n / i - 1);
			}
		}
		Iterator<Long> iter = set.iterator ();
		while (iter.hasNext ()) {
			long l = iter.next ();
			
			System.out.print (l + " ");
		}
	}
	
}