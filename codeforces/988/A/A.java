import java.util.*;


public class A {
	
	public static void main (String[] args) {
		ArrayList<Integer> list = new ArrayList <> ();
		ArrayList<Integer> dexes = new ArrayList <> ();
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt (), k = sc.nextInt ();

		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt ();
			if (!list.contains (temp)) {
				list.add (temp);
				dexes.add (i + 1);
			}
		}
		
		if (list.size () < k)
			System.out.println ("NO");
		else {
			System.out.println ("YES");
			for (int i = 0; i < k; i++) {
				System.out.print (dexes.get (i) + " ");
			}
			System.out.println ();
		}
		
	}
	
}