import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br;
	
	static String read () throws Exception {
		return br.readLine ();
	}
	
	static int parse (String s) {
		return Integer.parseInt (s);
	}
	
	public static void main (String[] args) throws Exception {
		br = new BufferedReader (new InputStreamReader (System.in));
		int n = parse (read ());
		int[][] arr = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			String[] str = read ().split (" ");
			arr[i][0] = parse (str[0]);
			arr[i][1] = parse (str[1]);
			arr[i][2] = parse (str[2]);
			
			if (i > 0) {
				int a = arr[i-1][0], b = arr[i-1][1], c = arr[i-1][2];
				arr[i][0] += Math.max (a, b);
				arr[i][1] += Math.max (Math.max (a, b), c);
				arr[i][2] += Math.max (b, c);
			}
			
		}
		
		int a = arr[n-1][0], b = arr[n-1][1], c = arr[n-1][2];
		
		System.out.println (Math.max (Math.max (a, b), c));
	}
	
}