import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (sc.hasNextLine ()) {
			String s1 = sc.nextLine ().replaceAll ("[^A-Za-z]", "").toUpperCase ();
			String s2 = sc.nextLine ().replaceAll ("[^A-Za-z]", "").toUpperCase ();
			
			int sum1 = 0, sum2 = 0;
			
			for (int i = 0; i < s1.length (); i++)
				sum1 += (s1.charAt(i) - 'A' + 1);
			
			for (int i = 0; i < s2.length (); i++)
				sum2 += (s2.charAt (i) - 'A' + 1);
			
			while (sum1 > 9) {
				int acc = 0;
				while (sum1 > 0) {
					acc += (sum1 % 10);
					sum1 /= 10;
				}
				sum1 = acc;
			}
			
			while (sum2 > 9) {
				int acc = 0;
				while (sum2 > 0) {
					acc += (sum2 % 10);
					sum2 /= 10;
				}
				sum2 = acc;
			}
			
			if (sum1 > sum2) System.out.printf ("%.2f %c\n", 100.0 * sum2 / sum1, '%');
			else System.out.printf ("%.2f %c\n", 100.0 * sum1 / sum2, '%');
			
		}
	}
	
}