import java.math.*;
import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt ()) {
			int n = sc.nextInt (), a = sc.nextInt ();
			BigInteger bin = new BigInteger (String.valueOf (n));
			BigInteger bia = new BigInteger (String.valueOf (a));
			
			if (a != 1)
				System.out.println (
					bia.subtract (bin.add(BigInteger.ONE)
						.multiply (bia.pow (n + 1)))
						.add (bin
							.multiply (bia.pow (n + 2)))
						.divide (BigInteger.ONE
							.subtract (bia)
							.multiply (BigInteger.ONE
								.subtract (bia)))
				);
			else
				System.out.println (
					bin.multiply (bin.add (BigInteger.ONE))
						.divide (new BigInteger (String.valueOf (2)))
				);
			
		}
		
	}
	
}