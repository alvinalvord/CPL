import java.util.*;

public class Main {
	
	
	public static void main (String[] args) {
		ArrayList<String> list = new ArrayList<> ();
		Scanner sc = new Scanner (System.in);
		int n, len, acc;
		
		while (true) {
			n = sc.nextInt ();
			if (n == 0) break;
			sc.nextLine ();
			
			for (int i = 0; i < n; i++)
				list.add (sc.nextLine ().replaceAll ("[^Xx]", ""));
			
			list.sort ((a, b) -> b.length () - a.length ());
			
			len = list.get (0).length ();
			acc = 0;
			for (int i = 1; i < n; i++)
				acc += len - list.get (i).length ();
			
			System.out.println (acc);
			list.clear ();
		}
		
		
	}
	
}
