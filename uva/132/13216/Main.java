import java.io.*;
import java.math.BigInteger;

public class Main {
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		BigInteger base = new BigInteger ("66");
		BigInteger mod = new BigInteger ("100");
		BigInteger exp;
		int n = Integer.parseInt (br.readLine ());
		while (n-->0) {
			exp = new BigInteger (br.readLine ());
			System.out.println (base.modPow (exp, mod).toString ());
		}
		
		
	}
	
}