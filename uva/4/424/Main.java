import java.util.*;
import java.math.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		BigInteger sum = BigInteger.ZERO;
		
		while (true) {
			BigInteger in = new BigInteger (sc.nextLine ());
			if (in.equals (BigInteger.ZERO)) break;
			sum = sum.add (in);
		}
		
		System.out.println (sum);
	}
	
}