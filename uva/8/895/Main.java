import java.util.*;

public class Main {
	
	Scanner sc;
	int[][] dict;
	int n;
	Main () {
		sc = new Scanner (System.in);
		dict = new int[1000][26];
	}
	
	void parse (String str, int index) {
		for (int i = 0; i < str.length (); i++) {
			dict[index][str.charAt (i) - 'a']++;
		}
	}
	
	void count (String str) {
		int[] arr = new int[26];
		for (int i = 0; i < str.length (); i++) {
			arr[str.charAt (i) - 'a']++;
		}
		int ctr = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length; j++) {
				if (dict[i][j] > arr[j]) {
					flag = false; break;
				}
			}
			if (flag) ctr ++;
		}
		
		System.out.println (ctr);
	}
	
	public void run () {
		n = 0;
		while (true) {
			String str = sc.nextLine ();
			
			if (str.charAt (0) != '#') parse (str, n++);
			else break;
		}
		
		while (true) {
			String str = sc.nextLine ();
			if (str.charAt (0) == '#') break;
			count (str.replaceAll ("\\s", ""));
		}
	}
	
	public static void main (String[] args) {
		new Main () .run ();
	}
	
}
