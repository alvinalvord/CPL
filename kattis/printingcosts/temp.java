import java.util.*;

public class temp {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		while (sc.hasNextLine ()) {
			String[] s = sc.nextLine ().split("\\s+");
			
			for (int i = 0; i < s.length; i += 2) {
				System.out.println ("map.put ('" + s[i] + "'," + s[i+1] + ");");
			}
			
		}
		
	}
	
}