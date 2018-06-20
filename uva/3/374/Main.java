import java.math.*;
import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		BigInteger b, p, m;
		
		while (true) {
			if (!sc.hasNextInt ())
				break;
			b = new BigInteger (String.valueOf (sc.nextInt ()));
			p = new BigInteger (String.valueOf (sc.nextInt ()));
			m = new BigInteger (String.valueOf (sc.nextInt ()));
			
			System.out.println (b.modPow (p, m).toString ());
		}
		
	}
	
}