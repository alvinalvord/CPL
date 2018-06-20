import java.util.*;
import java.math.*;

public class Main {
	
	public static void main (String[] args) {
		BigInteger[] arr = new BigInteger[5001];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		for (int i = 2; i < 5001; i++) {
			arr[i] = arr[i-1].add (arr[i-2]);
		}
		Scanner sc =new Scanner (System.in);
		while (sc.hasNextInt ()) {
			int n = sc.nextInt ();
			System.out.printf ("The Fibonacci number for %d is %s\n", n, arr[n].toString ());
		}
		
	}
	
}