import java.util.*;

public class A {
	public static void main (String[] args) {
		List <List<Integer>> list = new ArrayList <> ();
		Scanner sc = new Scanner (System.in);
		
		int kin = sc.nextInt ();
		
		for (int i = 0; i < kin; i++) {
			list.add (new ArrayList <> ());
			int n = sc.nextInt ();
			for (int j = 0; j < n; j++) {
				list.get (i).add (sc.nextInt ());
			}
		}
		
		for (int i = 0; i < list.size () - 1; i++) {
			for (int j = i + 1; j < list.size (); j++) {
				int sumi = 0;
				int sumj = 0;
				for (int k = 0; k < list.get (i).size (); k++)
					sumi += list.get (i).get (k);
				for (int k = 0; k < list.get (j).size (); k++)
					sumj += list.get (j).get (k);
				
				for (int k = 0; k < list.get (i).size (); k++) {
					for (int l = 0; l < list.get (j).size (); l++) {
						if (sumi - list.get (i).get (k) == sumj - list.get (j).get(l)) {
							System.out.println ("YES");
							System.out.println ((i+1) + " " + (k + 1));
							System.out.println ((j+1) + " " + (l + 1));
							System.exit (0);
						}
					}
				}

			}
		}
		
		System.out.println ("NO");
		
	}
}