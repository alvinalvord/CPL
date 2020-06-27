import java.util.*;
public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int low = 1, high = 1000;
		
		while (true) {
			int mid = (low + high) / 2;
			
			System.out.println (mid);
			System.out.flush ();
			String temp = sc.nextLine ();
			if (temp.equals ("correct")) break;
			if (temp.equals ("lower")) high = mid - 1;
			if (temp.equals ("higher")) low = mid + 1;
		}
	}
	
}