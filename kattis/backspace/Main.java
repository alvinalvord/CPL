import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		char[] in = sc.nextLine ().toCharArray ();
		StringBuilder sb = new StringBuilder ();
		
		for (int i = 0; i < in.length; i++) {
			if (in[i] == '<') {
				sb.setLength (Math.max (sb.length () - 1, 0));
			} else {
				sb.append (in[i]);
			}
		}
		
		System.out.println (sb.toString ());
		
	}
	
	
}