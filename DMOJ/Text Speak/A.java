import java.util.*;

public class A {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		String in = sc.nextLine ();
		
		StringBuilder sb = new StringBuilder ().append (in.charAt (0));
		in = in.substring (1).replaceAll ("[AEIOUaeiou]", "");
		
		for (int i = 0; i < in.length (); i++) {
			if (!(in.charAt (i) + "").equalsIgnoreCase (sb.charAt (sb.length () - 1) + ""))
				sb.append (in.charAt (i));
		}
		
		System.out.println (sb.toString ());
	}
}