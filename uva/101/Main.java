import java.util.*;
import java.math.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		BigInteger a, b;
		while (sc.hasNextLine ()) {
			a = new BigInteger (sc.nextLine ());
			b = new BigInteger (sc.nextLine ());
			
			System.out.println (a.multiply (b));
		}
	}
	
}