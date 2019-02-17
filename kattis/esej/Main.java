import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt (); int m = sc.nextInt ();
		
		StringBuilder sb = new StringBuilder ();
		
		Random r = new Random ();
		String alphabet = "qwertyuiopasdfghjklzxcvbnm";
		
		StringBuilder temp = new StringBuilder ();
		for (int j = 0; j < 6; j++) {
			temp.append (alphabet.charAt (r.nextInt (alphabet.length ())));
		}
		sb.append (temp.toString ());
		temp.setLength (0);
		for (int i = 1; i < (n + m) / 2; i++) {
			for (int j = 0; j < 8; j++) {
				temp.append (alphabet.charAt (r.nextInt (alphabet.length ())));
			}
			sb.append (' ').append (temp.toString ());
			temp.setLength (0);
		}
		
		System.out.println (sb.toString ());
	}
	
}