import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		while (sc.hasNextInt ()) {
			int n = sc.nextInt ();
			int temp = 1 % n;
			int count = 1;
			while (temp != 0) {
				temp = (temp * 10 + 1) % n;
				count ++;
			}
			System.out.println (count);
		}
		
	}
	
}