import java.util.*;
import java.math.*;

public class Main {
	
	static List<BigInteger> list = new ArrayList <> ();
	
	public static BigInteger fact (int n) {
		if (n < list.size ())
			return list.get (n);
		
		BigInteger m = fact (n - 1).multiply (new BigInteger (String.valueOf (n)));
		list.add (m);
		
		return m;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		list.add (BigInteger.ONE);
		list.add (BigInteger.ONE);
		int in;
		while (sc.hasNextInt ()) {
			in = sc.nextInt ();
			System.out.println (in + "!");
			System.out.println (fact (in));
		}
		
	}
	
}