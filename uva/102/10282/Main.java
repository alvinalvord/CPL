import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		HashMap <String, String> map = new HashMap <> ();
		while (sc.hasNextLine ()) {
			String in = sc.nextLine ();
			if (in.length () == 0) break;
			
			String[] t = in.split (" ");
			map.put (t[1], t[0]);
		}
		
		while (sc.hasNextLine ()) {
			String in = sc.nextLine ();
			if (map.get (in) == null) System.out.println ("eh");
			else System.out.println (map.get(in));
		}
		
	}
	
}