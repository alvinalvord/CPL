import java.util.*;
import java.math.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		BigInteger[] arr = new BigInteger[101];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		for (int i = 2; i < 101; i++)
			arr[i] = arr[i - 1].multiply (new BigInteger (i + ""));
		
		while (true) {
			int n = sc.nextInt ();
			int m = sc.nextInt ();
			if (n == m && n == 0) break;
			if (n > m)
				System.out.printf ("%d things taken %d at a time is %s exactly.\n",
					n, m, arr[n].divide (arr[m].multiply (arr[n-m])).toString ());
			else
				System.out.printf ("%d things taken %d at a time is %s exactly.\n",
					n, m, "1");
		}
	}
	
}