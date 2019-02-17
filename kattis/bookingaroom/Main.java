import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int r = sc.nextInt ();
		int n = sc.nextInt ();
		BitSet bs = new BitSet (r);
		for (int i = 0; i < n; i++) {
			bs.set (sc.nextInt () - 1);
		}
		
		if (bs.cardinality () == r) {
			System.out.println ("too late");
		} else {
			for (int i = 0; i < r; i++) {
				if (!bs.get (i)) {
					System.out.println (i + 1);break;
				}
			}
		}
		
	}
}