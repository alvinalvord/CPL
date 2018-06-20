import java.util.*;
import java.math.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		StringBuilder a = new StringBuilder ();
		StringBuilder b = new StringBuilder ();
		int n = sc.nextInt ();
		int i, j, m;
		String temp;
		BigInteger x, y;
		
		for (i = 0; i < n; i++) {
			m = sc.nextInt ();
			sc.nextLine ();
			
			for (j = 0; j < m; j++) {
				temp = sc.nextLine ();
				a.append (temp.charAt (0));
				b.append (temp.charAt (2));
			}
			
			x = new BigInteger (a.toString ());
			y = new BigInteger (b.toString ());
			
			System.out.println (x.add (y).toString ());
			if (i < n - 1)
				System.out.println ();
			
			a.setLength (0);
			b.setLength (0);
		}
		
	}
	
}