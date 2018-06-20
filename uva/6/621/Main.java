import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		sc.nextLine ();
		
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine ();
			
			if (str.matches ("[0-9]*35"))
				System.out.println ("-");
			else if (str.matches ("9[0-9]*4"))
				System.out.println ("*");
			else if (str.matches ("190[0-9]*"))
				System.out.println ("?");
			else if (str.matches ("1|4|78"))
				System.out.println ("+");
			else
				System.out.println ("?");
			
		}
	}
	
}