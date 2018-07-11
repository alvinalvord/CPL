import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String a = sc.nextLine ();
		String b = sc.nextLine ();
		
		int i = a.length () - 1;
		int j = b.length () - 1;
		
		while (i >= 0 && j >= 0) {
			if (a.charAt (i) == b.charAt (j)) {
				i--; j--;
			} else break;
		}
		i++;
		j++;
		
		System.out.println (i + j);
	}
	
}