import java.util.*;
import java.math.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		StringBuilder a, b, c;
		BigInteger x, y, z;
		
		int n = sc.nextInt (); sc.nextLine ();
		
		while (n-- > 0) {
			a = new StringBuilder (sc.next ()).reverse ();
			b = new StringBuilder (sc.next ()).reverse ();
			sc.nextLine ();
			x = new BigInteger (a.toString ());
			y = new BigInteger (b.toString ());
			z = x.add (y);
			c = new StringBuilder (z.toString ()).reverse ();
			z = new BigInteger (c.toString ());
			c = new StringBuilder (z.toString ());
			System.out.println (c.toString ());
		} 
		
	}
	
}