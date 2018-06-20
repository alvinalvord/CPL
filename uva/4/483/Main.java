import java.util.*;

public class Main {

	public static String reverse (char[] arr) {
		int i = 0, j = arr.length - 1;
		char temp;
		while (i <= j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			i++; j--;
		}
		
		return new String (arr);
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (sc.hasNextLine ()) {
			String str = sc.nextLine ();
			
			String[] arr = str.split (" ");
			
			String[] fix = new String[arr.length];
			for (int i = 0; i < arr.length; i++) {
				fix[i] = reverse (arr[i].toCharArray ());
			}
			
			System.out.println (String.join (" ", fix));
		}
		
	}
	
}