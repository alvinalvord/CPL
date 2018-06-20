import java.util.*;
import java.math.*;

public class A {
	
	static class S {
		StringBuilder sb;
		int d;
		
		public S (StringBuilder sb, int d) {
			this.sb = sb;
			this.d = d;
		}
		public boolean equals (Object o) {
			S s = (S) o;
			
			return s.sb.toString ().equals (sb.toString ());
		}
	}
	
	static List <S> states = new ArrayList <> ();
	static List <S> visited = new ArrayList <> ();
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		String in = sc.nextLine ();
		
		if (!in.contains ("0") || !in.contains ("5")) {
				System.out.println ("-1");
				System.exit (0);
		}
		func (in);
	}
	
	public static void func (String in) {		
		BigInteger tf = new BigInteger ("25");
		
		states.add (new S (new StringBuilder (in), 0));
		
		while (!states.isEmpty ()) {
			S cur = states.remove (0);
			
			if (visited.contains (cur))
				continue;
			
			visited.add (cur);
			if (new BigInteger (cur.sb.toString ()).mod (tf).equals (BigInteger.ZERO)) {
				System.out.println (cur.d);
				System.exit (0);
			} else {
				for (int i = 0; i < cur.sb.length () - 1; i++) {
					StringBuilder sne = new StringBuilder (cur.sb);
					sne.setCharAt (i, cur.sb.charAt (i + 1));
					sne.setCharAt (i + 1, cur.sb.charAt (i));
					
					S s = new S (sne, cur.d + 1);
					states.add (s);
				}
			}
		}
		
		System.out.println ("-1");
	}
	
}