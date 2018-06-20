import java.util.*;

public class Main {

    public static boolean isPalindrome (char[] arr, int i, int j) {
	if (i > j)
		return true;
	if (arr[i] != arr[j]) return false;

	return isPalindrome (arr, i+1, j-1);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);

	String in;

	while (true) {
		in = sc.nextLine ();
		if (in.equals ("DONE")) break;

		in = in.replaceAll ("[^A-Za-z]", "").toUpperCase ();

		if (isPalindrome (in.toCharArray (), 0, in.length () - 1))
			System.out.println ("You won't be eaten!");
		else
			System.out.println ("Uh oh..");

	}
	

    }
}
