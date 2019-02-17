import java.util.*;

public class Main {
	
	static int trace (int p, int q) {
		if (p == q && p == 1) return 1;
		if (p < q) { // left
			return 2 * trace (p, q - p);
		} else { // right
			return 2 * trace (p - q, q) + 1;
		}
	}
	
	static void func (int k, int p, int q) {
		System.out.println (k + " " + trace (p, q));
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int p = Integer.parseInt (sc.nextLine ());
		
		for (int i = 0; i < p; i++) {
			String[] t1 = sc.nextLine ().split (" ");
			String[] t2 = t1[1].split ("/");
			func (Integer.parseInt (t1[0]),
				Integer.parseInt (t2[0]),
				Integer.parseInt (t2[1]));
		}
	}
	
}