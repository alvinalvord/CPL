import java.util.*;
import java.math.*;

public class Main {
	
	static ArrayList<BigInteger> arr;
	static ArrayList<Integer> sum;
	public static void init () {
		arr = new ArrayList<> ();
		arr.add (BigInteger.ONE);
		BigInteger temp = BigInteger.ONE;
		for (int i = 1; i < 1001; i++) {
			arr.add (arr.get(i-1).multiply (temp));
			temp = temp.add (BigInteger.ONE);
		}
		
		sum = new ArrayList <> ();
		for (BigInteger b: arr) {
			int t = 0;
			String s = b.toString ();
			for (int i = 0; i < s.length (); i++) {
				t += (s.charAt(i) - '0');
			}
			sum.add (t);
		}
	}
	
	public static void main (String[] args) {
		init ();
		
		Scanner sc = new Scanner (System.in);
		while (sc.hasNextInt ()) {
			System.out.println (sum.get (sc.nextInt ()));
		}
	}
	
}