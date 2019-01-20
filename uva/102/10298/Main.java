import java.util.*;

public class Main {
	
	static int f (String str) {
		if (str.equals (".")) System.exit (0);
		
		ArrayList<Integer> list = new ArrayList <> ();
		for (int i = 1; i < str.length (); i++) {
			if (str.length () % i == 0)
				list.add (i);
		}
		for (int i: list) {
			String sub = str.substring (0, i);
			if (str.matches ("^(" + sub + ")+$")) return str.length () / i;
		}
		
		return 1;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		while (true)
			System.out.println (f (sc.nextLine ()));
		
	}
	
}