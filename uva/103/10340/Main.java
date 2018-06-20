import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		StringBuilder sb = new StringBuilder (300);
		String a, b;
		while (sc.hasNext ()) {
			a = sc.next ();
			if (sc.hasNext ())
				b = sc.next ();
			else break;
			
			sb.append (".*");
			for (int i = 0; i < a.length (); i++)
				sb.append (a.charAt(i)).append (".*");
			
			System.out.println (((b.matches (sb.toString ())) ? "Yes" : "No"));
			
			sb.setLength (0);
		}
		
	}
	
}