import java.util.*;

public class Main {
	
	Scanner sc;
	
	Main () {
		sc = new Scanner (System.in);
	}
	
	boolean isPalindrome (String str, int i, int j) {
		while (i < j) {
			if (str.charAt (i) != str.charAt (j)) return false;
			i++; j--;
		}
		return true;
	}
	
	void f (String str) {
		for (int i = 0; i < str.length (); i++) {
			if (str.charAt (i) == str.charAt (str.length () - 1)) {
				if (isPalindrome (str, i, str.length () - 1)) {
					StringBuilder sb = new StringBuilder ();
					sb.append (str);
					for (int j = i - 1; j >= 0; j--)
						sb.append (str.charAt (j));
					System.out.println (sb.toString ());
					break;
				}
			}
		}
	}
	
	public void run () {
		while (sc.hasNextLine ()) {
			f (sc.nextLine ());
		}
	}
	
	public static void main (String[] args) {
		new Main ().run ();
	}
	
}