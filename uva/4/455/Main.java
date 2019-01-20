import java.util.*;

public class Main {
	
	static int f (String str) {
		ArrayList<Integer> list = new ArrayList <> ();
		for (int i = 1; i < str.length (); i++) {
			if (str.length () % i == 0)
				list.add (i);
		}
		for (int i: list) {
			String sub = str.substring (0, i);
			if (str.matches ("^(" + sub + ")+$")) return i;
		}
		
		return str.length ();
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = Integer.parseInt (sc.nextLine ());
		
		for (int i = 0; i < n; i++) {
			sc.nextLine ();
			System.out.println (f (sc.nextLine ()));
			if (i < n - 1) System.out.println (); 
		}
		
	}
	
}