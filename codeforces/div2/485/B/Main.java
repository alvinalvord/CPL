import java.util.*;
import java.math.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int x = sc.nextInt ();
		int y = sc.nextInt ();
		
		BigInteger xp = new BigInteger (String.valueOf (x)).pow (y);
		BigInteger yp = new BigInteger (String.valueOf (y)).pow (x);
		
		System.out.println ((xp.compareTo (yp) < 0 ? '<': xp.compareTo (yp) > 0 ? '>' : '='));
		
	}
	
}