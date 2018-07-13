import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String s = sc.nextLine ();
		
		String[] arr = new String[s.length ()];
		for (int i = 0; i < s.length (); i++) {
			arr[i] = "";
			if (s.charAt (i) != '.')
				arr[i] += s.charAt (i);
			
			if (i > 0 && s.charAt (i - 1) != '.') arr[i] += s.charAt (i - 1);
			if (i < s.length () - 1  && s.charAt (i + 1) != '.') arr[i] += s.charAt (i + 1);
		}
		
		for (String str: arr) {
			boolean[] temp = new boolean[3];
			
			for(int i = 0; i < str.length (); i++) {
				temp[str.charAt (i) - 'A'] = true;
			}
			
			if (temp[0] && temp[1] && temp[2]) {
				System.out.println ("YES");
				System.exit (0);
			}
			
		}
		
		System.out.println ("NO");
	}
	
}