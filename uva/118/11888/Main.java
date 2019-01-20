import java.util.Scanner;

public class Main {
	
	public static boolean isPalindrome (char[] in, int i, int j) {
		if (i >= j)
			return true;
		if (in[i] == in[j])
			return isPalindrome (in, i + 1, j - 1);
		else
			return false;
	}
	
	public static boolean isAlindrome (char[] in) {
		int i = 0, j = 0, k = j + 1, m = in.length - 1;
		
		while (j < in.length && k < in.length) {
			if (isPalindrome (in, i, j) && isPalindrome (in, k, m))
				return true;
			
			j++; k++;
		}
		
		return false;
	}
	
	public static void solve (char[] in) {
		if (isAlindrome (in))
			System.out.println ("alindrome");
		else if (isPalindrome (in, 0, in.length - 1))
			System.out.println ("palindrome");
		else
			System.out.println ("simple");
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt ();
		sc.nextLine ();
		for (int i = 0; i < T; i++) {
			solve (sc.nextLine ().toCharArray ());
		}
	}
	
}