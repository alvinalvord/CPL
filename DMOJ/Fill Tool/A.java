import java.util.*;

public class A {
	
	static char[][] arr;
	
	public static void fill (int x, int y, char target, char ch) {
		if (arr[x][y] == target) {
			arr[x][y] = ch;
			if (x + 1 < arr.length) {
				fill (x + 1, y, target, ch);
			}
			if (x - 1 >= 0) {
				fill (x - 1, y, target, ch);
			}
			if (y + 1 < arr[0].length) {
				fill (x, y + 1, target, ch);
			}
			if (y - 1 >= 0) {
				fill (x, y - 1, target, ch);
			}
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int m = sc.nextInt ();
		int n = sc.nextInt ();
		sc.nextLine ();
		
		arr = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String in = sc.nextLine ();
			for (int j = 0; j < in.length (); j++)
				arr[i][j] = in.charAt (j);
		}
		
		String[] temp = sc.nextLine ().split (" ");
		int y = Integer.parseInt (temp[0]);
		int x = Integer.parseInt (temp[1]);
		char ch = temp[2].charAt (0);
		
		fill (x, y, arr[x][y], ch);
		
		for (int i = 0; i < n; i++) {
			System.out.println (new String (arr[i]));
		}
	}
	
}