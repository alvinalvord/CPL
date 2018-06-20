import java.util.*;

public class B {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		ArrayList <String> list = new ArrayList <> ();
		int n = sc.nextInt ();
		sc.nextLine ();
		
		for (int i = 0; i < n; i++) {
			list.add (sc.nextLine ());
		}
		list.sort ((a, b) -> {
			if (a.length () == b.length ()) {
				return a.compareTo (b);
			}
			return a.length () - b.length ();
		});
		
		boolean flag = true;
		for (int i = 0; i < n - 1; i++) {
			if (!list.get (i + 1).contains (list.get (i))) {
				flag = false; break;
			}
		}
		
		if (!flag) {
			System.out.println ("NO");
		} else {
			System.out.println ("YES");
			for (int i = 0; i < n; i++)
				System.out.println (list.get (i));
		}
		
	}
	
}