import java.util.*;

public class Main {
	
	Scanner sc;
	
	public Main () {
		sc = new Scanner (System.in);
	}
	
	public void func () {
		int n = sc.nextInt ();
		sc.nextLine ();
		HashMap <String, Integer> p = new HashMap <>();
		String[] people = sc.nextLine ().split (" ");
		for (int i = 0; i < n; i++)
			p.put (people[i], 0);
		
		for (int i = 0; i < n; i++) {
			String key = sc.next ();
			int mon = sc.nextInt ();
			int m = sc.nextInt ();
			int div = mon;
			int mod = mon;
			if (m > 0) {
				div /= m;
				mod %= m;
			}
			p.put (key, p.get (key) + mod - mon);
			for (int j = 0; j < m; j++) {
				key = sc.next ();
				p.put (key, p.get (key) + div);
			}
			sc.nextLine ();
		}
		
		for (int i = 0; i < people.length; i++) {
			System.out.println (people[i] + " " + p.get (people[i]));
		}
	}
	
	public void run () {
		while (true) {
			func ();
			if (sc.hasNextLine ())
				System.out.println ();
			else break;
		}
	}
	
	public static void main (String[] args) {
		new Main ().run ();
	}
	
}